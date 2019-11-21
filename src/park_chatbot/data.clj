(ns park-chatbot.data)

"""Park record"""
(defrecord Park [name wc restaurant cafe bicycle_paths skating sports_ground playground dogs opening_hours])

"""Defrecord variable for Park"""
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

"""A list of parks"""
(def Parks [betramka, fran_garden, obora, kampa, zahrada, klam, ladronka, letna, petrin, riegrovy, stromovka, vajanovy, vysehrad])

"""Define a list of greetings"""
(def greetings ["Hello, I am Parkbot. I am the most advanced park information bot and I am here to help you. Hello, I am Parkbot.",
                "I am here to serve your needs.",
                "Hi, I am Parkbot. I am here today to help you to find the best park just for you.",
                "Welcome, I am Parkbot. I am here to help you to find the best park just for you.",
                "Hi, I am Parkbot. It’s a pleasure to meet you. I am here to help you.",
                "Hey there, I am Parkbot. I am advanced interficial park information bot and I am here to help you to find the most suitable park just for you.",
                "Good day. I am the most advanced interfacial park information bot. My name is Parkbot.",
                "Howdy, my name is Parkbot. I am here to help you.",
                "Great to see you. My name is Parkbot. I am advanced park information bot and I am here to help you.",
                "Nice to see you. I am a Parkbot living in Prague. I would like to help you to find the right park just for you.",
                "Look who it is! It’s me Parkbot and I am here today to help you."])

"""Defrecord variable for User"""
(defrecord User [name wc restaurant cafe bicycle_paths skating sports_ground playground dogs terminate])

"""Create defrecord variable User"""
(def user (User. (ref nil) (ref nil) (ref nil) (ref nil) (ref nil) (ref nil) (ref nil) (ref nil) (ref nil) (ref false)))

"""Define a list of asking name"""
(def name_ask ["What is your name?",
               "May I have your name?",
               "How may I address you?",
               "Do you mind if I ask you for your name?",
               "How do they call you?",
               "I am sorry, I did not catch your name. What is your name?",
               "What can I call you?",
               "How do you like to be called?"])

"""Vocabulary"""
(def pos_preference (set '["yes", "like", "love", "enjoy"]))
(def neg_preference (set '["no", "not", "don't"]))
(def verbs (set '["have", "eat", "drink", "ride", "cycle", "bike", "roller skate", "skate", "play", "practice", "use",
                  "do", "walk", "go", "end", "finish", "goodbye", "want", "open", "close", "fun"]))
(def nouns (set '["lunch", "breakfast", "dinner", "bike", "sports", "skate", "dog",
                  "coffee", "tea", "dessert", "skateboard", "football", "basketball",
                  "wc", "meal", "animal", "sport", "cake"]))