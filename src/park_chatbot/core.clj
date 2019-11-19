(ns park-chatbot.core
    (:require [opennlp.nlp :as nlp]))

(def tokenize (nlp/make-tokenizer "src/en-token.bin"))
(def name-find (nlp/make-name-finder "src/en-ner-person.bin"))

(defn take_user_input []
  (let [user_input (read-line)]
    user_input))

(defn main []
  (rand-nth ["Hello, I am Parkbot. I am the most advanced park information bot and I am here to help you. Hello, I am Parkbot. " "I am here to serve your needs." "Hi, I am Parkbot. I am here today to help you to find the best park just for you." "Welcome, I am Parkbot. I am here to help you to find the best park just for you." "Hi, I am Parkbot. It’s a pleasure to meet you. I am here to help you." "Hey there, I am Parkbot. I am advanced interficial park information bot and I am here to help you to find the most suitable park just for you." "Good day. I am the most advanced interfacial park information bot. My name is Parkbot." "Howdy, my name is Parkbot. I am here to help you." "Great to see you. My name is Parkbot. I am advanced park information bot and I am here to help you." "Nice to see you. I am a Parkbot living in Prague. I would like to help you to find the right park just for you." "Look who it is! It’s me Parkbot and I am here today to help you."]))
