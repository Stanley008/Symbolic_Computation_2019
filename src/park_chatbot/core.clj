(ns park-chatbot.core
    (:require [opennlp.nlp :as nlp]
        [park-chatbot.data :as data]
        [clojure.string :as str]))

(def tokenize (nlp/make-tokenizer "src/en-token.bin"))

(defn take_user_input []
  """Take user input from CLI"""
  (let [user_input (read-line)]
    user_input))

(defn strip_punctuation [text]
  """Remove puntuation from a string"""
  (str/replace text #"[.?,;:!]" ""))

(defn find_name [sent]
  """Ask user's name"""
  (with-local-vars [name nil]
    (doseq [token sent]
      (if (= token (str/capitalize token))
        (var-set name token)
        (if (= @name nil)
          (var-set name "Visitor"))))
    @name))

(defn ask_for_nickname []
  """Ask the user whether he wants to be called by a nickname and if so, call as such"""
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

(defn match_park [topic user_preference selected_parks]
  (if (empty? @selected_parks)
    (doseq [park data/parks]
      (if (= user_preference (topic park))
        (var-set selected_parks (conj @selected_parks park))))
    (doseq [park @selected_parks]
      (if (not= user_preference (topic park))
        (var-set selected_parks (remove #{park} @selected_parks))))))

(defn find_preferences [question_obj answer selected_parks]
  """Find preference from the user's answer and raise a flag (true/false) in user records"""
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

(defn approve_ending? [counter]
  (println "Do you want to end this conversation?")
  (let [answer (tokenize (str/lower-case (take_user_input)))]
    (doseq [word answer]
      (if (contains? data/pos_preference word)
        (ref-set (:terminate data/user) true)
        (if (contains? data/neg_preference word)
          (do
            (var-set counter 0)
            (println "As you wish master.")))))))

(defn end_conversation? [user_input counter]
  (let [tokens (tokenize (str/lower-case user_input))]
    (doseq [word tokens]
      (if (contains? data/end_words word)
        (approve_ending? counter)))))

(defn select_question [question_obj]
  (loop [new_question (rand-nth data/questions)]
    (if (= 0 @(:status new_question))
      (var-set question_obj new_question)
      (recur (rand-nth data/questions)))))

(defn reset_questions []
    (doseq [question_obj data/questions]
      (ref-set (:status question_obj) 0)))

(defn parkbot_loop []
  (with-local-vars [counter 1
                    word_class {:verb nil :noun nil}
                    user_input ""
                    question_obj (rand-nth data/questions)
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

(defn -main []
  """Main function"""
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
