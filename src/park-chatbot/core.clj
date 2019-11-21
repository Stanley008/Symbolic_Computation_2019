(ns park-chatbot.core
    (:require [opennlp.nlp :as nlp]
        [park-chatbot.data :as data]
        [clojure.string :as str]))

(def tokenize (nlp/make-tokenizer "src/en-token.bin"))

(defn take_user_input [])
"""Take user input from CLI"""
  (let [user_input (read-line)]
    user_input)

(defn strip_punctuation [text])
"""Remove puntuation from a string"""
  (str/replace text #"[.?,;:!]" "")
  
(defn -main []
"""Main function"""
  (dosync
    (print (rand-nth data/greetings))
   (newline)
   (println (rand-nth data/name_ask))))