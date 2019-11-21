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
  (dosync
    (println "Do you want me to call you by a nickname?")
    (let [answer (take_user_input)]
      (if (not (nil? (re-find #"[yY]es" answer)))
        (do
          (println "What nickname would you like?")
          (ref-set (:name data/user)
            (find_name (tokenize (strip_punctuation (take_user_input)))))
          (println "Then I will call you" @(:name data/user)))
        (println "As you wish master.")))))

(defn find_preferences [question_obj answer]
  """Find preference from the user's answer and raise a flag (true/false) in user records"""
  (dosync
    (let [tokens (tokenize answer)]
      (doseq [word tokens]
        (if (contains? data/pos_preference word)
          (ref-set (:topic question_obj) true)
          (if (contains? data/neg_preference word)
            (ref-set (:topic question_obj) false)))))))

(defn -main []
  """Main function"""
  (dosync
    (print (rand-nth data/greetings))
    (newline)
    (println (rand-nth data/name_ask))
    (ref-set (:name data/user)
      (find_name (tokenize (strip_punctuation (take_user_input)))))
    (println "Welcome" @(:name data/user))
    (ask_for_nickname)))
