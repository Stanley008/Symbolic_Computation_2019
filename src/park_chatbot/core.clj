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
  (with-local-vars [name nil]
    (doseq [token sent]
      (if (= token (str/capitalize token))
        (var-set name token)
        (if (= @name nil)
          (var-set name "Visitor"))))
    @name))

(defn ask_for_nickname []
  (dosync
    (println (rand-nth data/nickname_ask_yes_no))
    (let [answer (take_user_input)]
      (if (not (nil? (re-find #"[yY]es" answer)))
        (do
          (println (rand-nth data/nickname_ask))
          (ref-set (:name data/user)
            (find_name (tokenize (strip_punctuation (take_user_input)))))
          (println "Then I will call you" @(:name data/user)))
        (println "As you wish master.")))))

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
