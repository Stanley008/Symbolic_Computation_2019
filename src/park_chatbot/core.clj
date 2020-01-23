(ns park-chatbot.core
    "The chatbot library that includes all necessary functions for it to run."
    (:require [opennlp.nlp :as nlp]
              [park-chatbot.data :as data]
              [park-chatbot.dog-data :as ddata]
              [park-chatbot.park-data :as pdata]
              [clojure.string :as str]
              [park-chatbot.easter-egg :as egg]
              [park-chatbot.dog-core :as dcore]
              [park-chatbot.park-core :as pcore]
              [park_chatbot.image-recognition :as ir]))

(defn main_loop "Dummy main_loop function" [])
(defn select_topic "Dummy select_topic function" [])

(def tokenize
  "Initialize the pre-trained tokenizer from 'en-token.bin'."
  (nlp/make-tokenizer "src/en-token.bin"))

(defn take_user_input
  "Take user input from the CLI and outputs it."
  []
  (let [user_input (read-line)]
    user_input))

(defn reset_questions
  "Resets the status of all question objects back to 0 (unused)."
  [question_obj_vector]
  (doseq [question_obj question_obj_vector]
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

(defn find_topic
  "Find the topic the user wants to talk about, either dogs or parks.
  user_input -> string that represent the input of the user."
  [user_input]
  (with-local-vars [tokens (tokenize (str/lower-case user_input))
                    topic nil]
    (doseq [word @tokens]
      (if (contains? (set '["dogs" "dog" "doggies"]) word)
        (var-set topic "dogs")
        (when (contains? (set '["park" "parks"]) word)
          (var-set topic "parks"))))
    (if (nil? topic)
      (do
        (println "Can you repeat your answer?")
        (find_topic (take_user_input)))
      @topic)))

(defn ask_for_nickname
  "Ask the user whether he wants to be called by a nickname and if so change
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

(defn find_recognition_type
  "Ask the user what type of dog recognition (text/image) is desired.
  user_input -> string that represent the input of the user."
  [user_input]
  (with-local-vars [tokens (tokenize (str/lower-case user_input))
                    type nil]
    (doseq [word @tokens]
      (if (contains? (set '["image" "photo" "images" "photos"]) word)
        (var-set type "image")
        (when (contains? (set '["text" "sentence" "word" "words" "information"]) word)
          (var-set type "text"))))
    (if (nil? type)
      (do
        (println "Can you repeat your answer?")
        (find_recognition_type (take_user_input)))
      @type)))

(defn recognise_image
  "Predicts the dog breed that appeared on a given photo"
  []
  (println "Please insert the path to the dog image.")
  (let [dog (ir/predict ir/model (take_user_input))]
    (println (rand-nth ddata/dog_found) dog ".")
    (dcore/give_dog_facts dog))
  (println (rand-nth data/user_end_questions))
  (let [answer (tokenize (str/lower-case (take_user_input)))]
    (doseq [word answer]
      (if (or (contains? data/pos_preference word) (contains? data/end_words word))
        (println (rand-nth data/user_goodbye))
        (select_topic)))))

(defn select_topic
  "Ask the user for a topic and selects the respective one based on the answer"
  []
  (println (rand-nth data/user_park_dog))
  (if (= (find_topic (take_user_input)) "dogs")
    (do
      (println (rand-nth ddata/user_dog_picture_information))
      (if (= (find_recognition_type (take_user_input)) "text")
        (main_loop 2 dcore/find_dog dcore/give_dog_answers ddata/dog_question_obj_vector)
        (recognise_image)))
    (main_loop 7 pcore/find_park pcore/give_park_answers pdata/park_question_obj_vector)))

(defn approve_ending?
  "Confirm if the user really want to end the conversation with the chatbot.
  If yes update the 'terminate' value in 'user' record to true.
  counter -> integer that stores the length of the conversation;
  selected_options -> reference to the list of parks with suitable preferences;
  giving_answer_func -> function to give user response whether the topic of his choice
  is found or not (i.e. parks or dogs)"
  [counter selected_options giving_answer_func question_obj_vector]
  (giving_answer_func selected_options)
  (println (rand-nth data/user_end_questions))
  (let [answer (tokenize (str/lower-case (take_user_input)))]
    (doseq [word answer]
      (if (or (contains? data/pos_preference word) (contains? data/end_words word))
        (do
          (ref-set (:terminate data/user) true)
          (println (rand-nth data/user_goodbye)))
        (when (contains? data/neg_preference word)
          (reset_questions question_obj_vector)
          (var-set counter 0)
          (println (rand-nth data/user_continue_conv))
          (select_topic))))))

(defn end_conversation?
  "Check if the user wants to finish the conversation. If yes it calls
  'approve_ending?' function
  user_input -> string that represent the input of the user."
  [user_input]
  (with-local-vars [tokens (tokenize (str/lower-case user_input))
                    flag false]
    (doseq [word @tokens]
      (when (contains? data/end_words word)
        (var-set flag true)))
    @flag))

(defn select_question
  "Select a random question object from the 'question_objects' list in data.clj.
  question_obj -> reference to question object variable from 'parkbot_loop' function;
  question_obj_vector -> the list of question objects from where a new one will be taken."
  [question_obj question_obj_vector]
  (loop [new_question (rand-nth question_obj_vector)]
    (if (= 0 @(:status new_question))
      (var-set question_obj new_question)
      (recur (rand-nth question_obj_vector)))))

(defn main_loop
  "The loop function of the chatbot. It is used to find the appropriate park
  for the user, based on his/her preferences.
  counter_max -> integer that stores the maximum no of questions in the topic of user's choice
  (i.e. parks or dogs)
  finding_func -> function to find the topic that the user wants to talk;
  giving_answer_func -> function to give user response whether the topic of his choice
  is found or not;
  question_obj_vector -> the list of question objects from where a new one will be taken."
  [counter_max finding_func giving_answer_func question_obj_vector]
  (with-local-vars [counter 1
                    user_input ""
                    question_obj (rand-nth question_obj_vector)
                    selected_options []]
    (reset_questions question_obj_vector)
    (while (not @(:terminate data/user))
      (let []
        (println (rand-nth (:sent @question_obj)))
        (var-set user_input (take_user_input))
        (egg/check_easter_egg (tokenize (str/lower-case @user_input)))
        (when (end_conversation? @user_input)
          (approve_ending? counter selected_options giving_answer_func question_obj_vector))
        (finding_func @question_obj @user_input selected_options @counter)
        (if (= 0 (rem @counter counter_max))
          (if (= false @(:terminate data/user))
            (approve_ending? counter selected_options giving_answer_func question_obj_vector)))
        (var-set counter (+ @counter 1))
        (ref-set (:status @question_obj) 1)
        (select_question question_obj question_obj_vector)))))

(defn -main
  "The starter function. It initializes the conversation and asks for basic information."
  []
  (dosync
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
   (select_topic)))
