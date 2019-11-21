(ns park-chatbot.core
    (:require [opennlp.nlp :as nlp]
        [park-chatbot.data :as data]))

(def tokenize (nlp/make-tokenizer "src/en-token.bin"))
(def name-find (nlp/make-name-finder "src/en-ner-person.bin"))

(defn take_user_input []
  (let [user_input (read-line)]
    user_input))

(defn -main []
  (dosync
    (print (rand-nth data/greetings))
   (newline)
   (println (rand-nth data/name_ask))))
