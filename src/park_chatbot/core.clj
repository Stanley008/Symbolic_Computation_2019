(ns park-chatbot.core
    (:require [opennlp.nlp :as nlp]))

"""define Park record """
(defrecord Park [name wc restaurant cafe bicycle_paths skating sports_ground playground dogs opening_hours])

"""create a defrecord variable Park"""
(def betramka (->Park "Betramka" true false true true false false false nil "All year round with different closing hours"))
(def fran_garden (->Park "Františkánská zahrada" true false false true false false true true "All year round but closes at night"))
(def obora (->Park "Obora Hvězda" true true true true false false true true "All year round"))
(def kampa (->Park "Kampa" true true true true true false true nil "All year round"))
(def zahrada (->Park "Kinského zahrada" true false true false false false true nil "All year round"))
(def klam (->Park "Klamovka" true true false true false true true true "All year round"))
(def ladronka (->Park "Ladronka" true true false true true false true true "All year round"))
(def letna (->Park "Letná" true true false true true true true true "All year round"))
(def petrin (->Park "Petřín" true true false true true false true nil "All year round"))
(def riegrovy (->Park "Riegrovy sady" true true false true true true true true "All year round"))
(def stromovka (->Park "Stromovka" true true false true true true true true "All year round"))
(def vajanovy (->Park "Vojanovy sady" false false false false false false false true "All year round"))
(def vysehrad (->Park "Vyšehrad" true true true true false true true nil "All year round"))


(def tokenize (nlp/make-tokenizer "src/en-token.bin"))
(def name-find (nlp/make-name-finder "src/en-ner-person.bin"))

(defn take_user_input []
  (let [user_input (read-line)]
    user_input))

(defn main []
  (println (rand-nth ["Hello, I am Parkbot. I am the most advanced park information bot and I am here to help you. Hello, I am Parkbot. " "I am here to serve your needs." "Hi, I am Parkbot. I am here today to help you to find the best park just for you." "Welcome, I am Parkbot. I am here to help you to find the best park just for you." "Hi, I am Parkbot. It’s a pleasure to meet you. I am here to help you." "Hey there, I am Parkbot. I am advanced interficial park information bot and I am here to help you to find the most suitable park just for you." "Good day. I am the most advanced interfacial park information bot. My name is Parkbot." "Howdy, my name is Parkbot. I am here to help you." "Great to see you. My name is Parkbot. I am advanced park information bot and I am here to help you." "Nice to see you. I am a Parkbot living in Prague. I would like to help you to find the right park just for you." "Look who it is! It’s me Parkbot and I am here today to help you."])))
