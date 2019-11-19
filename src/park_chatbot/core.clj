(ns park-chatbot.core
    (:require [opennlp.nlp :as nlp]
        [park-chatbot.data :as data]
        [clojure.string :as str]))

(def tokenize (nlp/make-tokenizer "src/en-token.bin"))
(def name-find (nlp/make-name-finder "src/en-ner-person.bin"))

(defn take_user_input [])
"""Take user input from CLI"""
  (let [user_input (read-line)]
    user_input)

(defn strip_punctuation [text])
"""Remove puntuation from a string"""
  (str/replace text #"[.?,;:!]" "")

(defn -main [])
"""Main function"""
  (dosync
    (println (rand-nth data/greetings)))
