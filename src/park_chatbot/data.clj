(ns park-chatbot.data)

"""define Park record """
(defrecord Park [name wc restaurant cafe bicycle_paths skating sports_ground playground dogs opening_hours])

"""create a defrecord variable Park"""
(def betramka (Park. "Betramka" true false true true false false false nil "All year round with different closing hours"))
(def fran_garden (Park. "Frantiskanska zahrada" true false false true false false true true "All year round but closes at night"))
(def obora (Park. "Obora Hvezda" true true true true false false true true "All year round"))
(def kampa (Park. "Kampa" true true true true true false true nil "All year round"))
(def zahrada (Park. "Kinskeho zahrada" true false true false false false true nil "All year round"))
(def klam (Park. "Klamovka" true true false true false true true true "All year round"))
(def ladronka (Park. "Ladronka" true true false true true false true true "All year round"))
(def letna (Park. "Letna" true true false true true true true true "All year round"))
(def petrin (Park. "Petrin" true true false true true false true nil "All year round"))
(def riegrovy (Park. "Riegrovy sady" true true false true true true true true "All year round"))
(def stromovka (Park. "Stromovka" true true false true true true true true "All year round"))
(def vajanovy (Park. "Vojanovy sady" false false false false false false false true "All year round"))
(def vysehrad (Park. "Vysehrad" true true true true false true true nil "All year round"))

"""define a list for parks"""
(def Parks [betramka, fran_garden, obora, kampa, zahrada, klam, ladronka, letna, petrin, riegrovy, stromovka, vajanovy, vysehrad])
