(ns park-chatbot.core
    "The chatbot library that includes all necessary functions for it to run."
    (:require [opennlp.nlp :as nlp]
              [park-chatbot.data :as data]
              [park-chatbot.dog-data :as ddata]
              [park-chatbot.park-data :as pdata]
              [clojure.string :as str]
              [park-chatbot.easter-egg :as egg]
              [park-chatbot.dog :as dog]
              [park-chatbot.park :as park]))

(def tokenize
  "Initialize the pre-trained tokenizer from 'en-token.bin'."
  (nlp/make-tokenizer "src/en-token.bin"))

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
  (str/replace text #"[.?,;:!']" ""))

(defn find_name
  "Search for a name in a string
  sent -> the string which should be searched for names."
  [sent]
  (with-local-vars [name nil]
    (doseq [token sent]
      (if (not= data/name_words (str/lower-case token))
        (var-set name token)))
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

(defn approve_ending?
  "Confirms if the user really want to end the conversation with the cahtbot.
  If yes updates the 'terminate' value in 'user' record to true.
  counter -> integer that stores the length of the conversation.
  selected_options -> reference to the list of parks with suitable preferences."
  [counter selected_options]
  (if (empty? @selected_options)
    (println (rand-nth data/user_park_not_find))
    (println (rand-nth data/user_visit)
      (:name (rand-nth @selected_options) ".")))
  (println (rand-nth data/user_end_questions))
  (let [answer (tokenize (str/lower-case (take_user_input)))]
    (doseq [word answer]
      (if (or (contains? data/pos_preference word) (contains? data/end_words word))
        (do
          (ref-set (:terminate data/user) true))
        (when (contains? data/neg_preference word)
          (reset_questions)
          (var-set counter 1)
          (println (rand-nth data/user_continue_conv)))))))

(defn end_conversation?
  "Checks if the user has the desire to finish the converastion. If yes it calls
  'approve_ending?' funcition
  user_input -> string that represent the input of the user;"
  [user_input]
  (with-local-vars [tokens (tokenize (str/lower-case user_input))
                    flag false]
    (doseq [word @tokens]
      (when (contains? data/end_words word)
        (var-set flag true)))
    @flag))

(defn select_question
  "Selects a random question object from the 'question_objects' list in data.clj.
  question_obj -> reference to question object variable from 'parkbot_loop' function."
  [question_obj]
  (loop [new_question (rand-nth question_obj_list)]
    (if (= 0 @(:status new_question))
      (var-set question_obj new_question)
      (recur (rand-nth question_obj_list)))))

(defn find_topic
  "Finds the topic the user want to talk about, either dogs or parks.
  user_input -> string that represent the input of the user;"
  [user_input]
  (with-local-vars [tokens (tokenize (str/lower-case user_input))
                    topic nil]
    (doseq [word @tokens]
      (if (contains? ["dogs" "dog" "doggies"] word)
        (var-set topic "dogs")
        (when (contains? ["park" "parks"] word)
          (var-set topic "parks"))))
    (if (nil? topic)
      (do
        (println "Can you repet your answer?")
        (find_topic (take_user_input)))
      @topic)))

(defn main_loop
  "The loop function of the chatbot. It is used to find the appropriate park
  for the user, based on his/her preferences."
  [counter_max finding_func question_obj_list]
  (with-local-vars [counter 1
                    user_input ""
                    question_obj (rand-nth data/question_objects)
                    selected_options []]
    (while (not @(:terminate data/user))
      (let []
        (println (rand-nth (:sent @question_obj)))
        (var-set user_input (take_user_input))
        (egg/check_easter_egg (tokenize (str/lower-case @user_input)))
        (when (end_conversation? @user_input)
          (approve_ending? counter selected_options))
        (finding_func @question_obj @user_input selected_options @counter)
        (if (= 0 (rem @counter counter_max))
          (if (= false @(:terminate data/user))
            (approve_ending? counter selected_options)))
        (var-set counter (+ @counter 1))
        (ref-set (:status @question_obj) 1)
        (select_question question_obj)))
    (println (rand-nth data/user_goodbye))))

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
    (println (rand-nth data/user_questions))
    (take_user_input)
   (println (rand-nth data/user_reply))
   (println (rand-nth data/user_no_question))
   (println (rand-nth data/user_park_dog))
   (if (= (find_topic (take_user_input)) "dogs")
     (main_loop 2 dog/find_dog ddata/dog_question_obj_vector)
     (main_loop 7 park/find_park pdata/park_question_obj_vector))))
