(ns park-chatbot.core
    "The chatbot library that includes all necessary functions for it to run."
    (:require [opennlp.nlp :as nlp]
        [park-chatbot.data :as data]
        [clojure.string :as str]))

(def
  "Initialize the pre-trained tokenizer from 'en-token.bin'."
  tokenize (nlp/make-tokenizer "src/en-token.bin"))

(defn take_user_input
  "Takes user input from the CLI and outputs it."
  []
  (let [user_input (read-line)]
    user_input))

(defn reset_questions
  "Resets the status of all question objects back to 0 (unused)."
  []
  (doseq [question_obj data/question_objects]
    (ref-set (:status question_obj) 0)))

(defn strip_punctuation
  "Remove the puntuation from a string and outputs the new string.
  text -> string from where the punctuation should be removed."
  [text]
  (str/replace text #"[.?,;:!]" ""))

(defn find_name
  "Search for a name in a string
  sent -> the string which should be searched for names."
  [sent]
  (with-local-vars [name nil]
    (doseq [token sent]
      (if (= token (str/capitalize token))
        (var-set name token)
        (if (= @name nil)
          (var-set name "Visitor"))))
    @name))

(defn ask_for_nickname
  "Ask the user whether he wants to be called by a nickname and if so, change
  the 'name' in the 'user' record with the nickname."
  []
  (println (rand-nth data/nickname_ask_yes_no))
  (let [answer (tokenize (str/lower-case (take_user_input)))]
    (doseq [word answer]
      (if (contains? data/pos_preference word)
        (do
          (println (rand-nth data/nickname_ask))
          (ref-set (:name data/user)
            (find_name (tokenize (strip_punctuation (take_user_input)))))
          (println (rand-nth data/nickname_answer) @(:name data/user) "."))
        (if (contains? data/neg_preference word)
          (println (rand-nth data/nickname_end)))))))

(defn match_park
  "Creates/Updates the list of selected parks based on the user preference.
  topic -> the facility of the park that the function searches for;
  user_preference -> boolean, represents wether the user want that facility included;
  selected_parks -> reference to the list of parks with suitable preferences."
  [topic user_preference selected_parks]
  (if (empty? @selected_parks)
    (doseq [park data/parks]
      (if (= user_preference (topic park))
        (var-set selected_parks (conj @selected_parks park))))
    (doseq [park @selected_parks]
      (if (not= user_preference (topic park))
        (var-set selected_parks (remove #{park} @selected_parks))))))

(defn find_preferences
  "Finds user's preference about a park facility and updates the facility preference
  values in the user record with true/false. Then it calls 'match_park' function.
  question_obj -> the question object (see 'question_objects' from data.clj);
  selected_parks -> reference to the list of parks with suitable preferences."
  [question_obj answer selected_parks]
  (let [tokens (tokenize (str/lower-case answer))]
    (doseq [word tokens]
      (if (contains? data/pos_preference word)
        (do
          (ref-set ((:topic question_obj) data/user) true)
          (match_park (:topic question_obj) true selected_parks))
        (if (contains? data/neg_preference word)
          (do
            (ref-set ((:topic question_obj) data/user) false)
            (match_park (:topic question_obj) false selected_parks)))))))

(defn approve_ending?
  "Confirms if the user really want to end the conversation with the cahtbot.
  If yes updates the 'terminate' value in 'user' record to true.
  counter -> integer that stores the length of the conversation."
  [counter]
  (println "Do you want to end this conversation?")
  (let [answer (tokenize (str/lower-case (take_user_input)))]
    (doseq [word answer]
      (if (contains? data/pos_preference word)
        (ref-set (:terminate data/user) true)
        (if (contains? data/neg_preference word)
          (do
            (reset_questions)
            (var-set counter 0)
            (println "As you wish master.")))))))

(defn end_conversation?
  "Checks if the user has the desire to finish the converastion. If yes it calls
  'approve_ending?' funcition
  user_input -> string that represent the input of the user;
  counter -> integer that stores the length of the conversation."
  [user_input counter]
  (let [tokens (tokenize (str/lower-case user_input))]
    (doseq [word tokens]
      (if (contains? data/end_words word)
        (approve_ending? counter)))))

(defn select_question
  "Selects a random question object from the 'question_objects' list in data.clj.
  question_obj -> reference to question object variable from 'parkbot_loop' function."
  [question_obj]
  (loop [new_question (rand-nth data/question_objects)]
    (if (= 0 @(:status new_question))
      (var-set question_obj new_question)
      (recur (rand-nth data/question_objects)))))

(defn parkbot_loop
  "The loop function of the chatbot. It is used to find the appropriate park
  for the user, based on his/her preferences."
  []
  (with-local-vars [counter 1
                    word_class {:verb nil :noun nil}
                    user_input ""
                    question_obj (rand-nth data/question_objects)
                    selected_parks []]
    (while (not @(:terminate data/user))
      (let []
        (println (:sent @question_obj))
        (var-set user_input (take_user_input))
        (end_conversation? @user_input counter)
        (find_preferences @question_obj @user_input selected_parks)
        (if (= 0 (rem @counter 3))
          (do
            (if (empty? @selected_parks)
              (println "I could not find an apropriate park for you.")
              (println "You can visit"
                (:name (rand-nth @selected_parks) ".")))
            (approve_ending? counter)))
        (var-set counter (+ @counter 1))
        (ref-set (:status @question_obj) 1)
        (select_question question_obj)))
      ;when it asks all questions it stucks
    (println "Ok goodbye.")))

(defn -main
  "The starter function. It initialize the conversation and asks for basic information."
  []
  (dosync
    (reset_questions)
    (print (rand-nth data/greetings))
    (newline)
    (println (rand-nth data/name_ask))
    (ref-set (:name data/user)
      (find_name (tokenize (strip_punctuation (take_user_input)))))
    (println "Welcome" @(:name data/user))
    (ask_for_nickname)
    (println "How are you?")
    (take_user_input)
    (parkbot_loop)))
