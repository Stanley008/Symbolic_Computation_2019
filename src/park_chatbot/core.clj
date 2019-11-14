(ns park-chatbot.core)

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











(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))
