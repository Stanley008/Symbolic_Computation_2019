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

"""Define a list of asking nickname yes or no answer"""
(def nickname_ask_yes_no ["Do you want me to call you by a nickname?",
                          "Would you like to be called by a nickname?",
                          "I did not get your nickname, would you like to be called by a nickname?",
                          "People rarely do have nicknames, would you like to be called by one?",
                          "Ok, now I know your name, but would you like to be rather called by your nickname?",
                          "What a nice name, I prefer nicknames. Mine is Parkiebot, would you also like to be called by a nickname?",
                          "I never heard this name. I prefer nicknames. Would you like to be called by a nickname?",
                          "Oh wow what a nice name. That’s cool, but I prefer nicknames. Mine is Parkiebot. Do you want to be called by a nickname?"])

"""Define a list of asking nickname"""
(def nickname_ask ["What nickname would you like?",
                   "What is your nickname?",
                   "I like your answer. I love nicknames. What is yours?",
                   "I am thrilled to hear you answer. What is your nickname?",
                   "I am waiting for your secret nickname. Tell me it!",
                   "WOW, you are the first one. What is your nickname? ",
                   "Positive answer, nice… I was just wondering, if you can type your nickname here? That’s my only input. Thank you."])

"""Define a list of nickname_answer"""
(def nickname_answer ["Than I will call you",
                      "It is your choice, I will call you",
                      "Your choice, I will call you",
                      "I like it. I will call you than ",
                      "Oh wow what a nice nickname, I will call you",
                      "Never heard this nickname, I shall call you than",
                      "Did you type it correctly? I am just kidding, It is your nickname. I am gonna call you than",
                      "Any mistake in your nickname? Just kidding, I am gonna call you",
                      "This is the first time I hear this. I love it",
                      "OK, as you wish",
                      "Great, I am gonna make your wish go true"])

"""Define a list of nickname_end"""
(def nickname_end ["OK, as you wish.",
                   "As you wish master.",
                   "Your choice.",
                   "I thought that you love nicknames. Oh well...",
                   "What a biggie, but It is your choice.",
                   "If you don't like nicknames, there is nothing that I can do.",
                   "No problem, I agree."])

"""Vocabulary"""
(def pos_preference (set '["yes", "like", "love", "enjoy"]))
(def neg_preference (set '["no", "not", "don't"]))
(def verbs (set '["have", "eat", "drink", "ride", "cycle", "bike", "roller skate", "skate", "play", "practice", "use",
                  "do", "walk", "go", "end", "finish", "goodbye", "want", "open", "close", "fun"]))
(def nouns (set '["lunch", "breakfast", "dinner", "bike", "sports", "skate", "dog",
                  "coffee", "tea", "dessert", "skateboard", "football", "basketball",
                  "wc", "meal", "animal", "sport", "cake"]))

"""Park questions"""
(def questions [{:sent "Would you like to use toilet in the park?" :topic (:wc user)}
                {:sent "Would you like to visit a restaurant in the park?" :topic (:restaurant user)}
                {:sent "Would you like to visit a cafe in the park?" :topic (:cafe user)}
                {:sent "Would you like to ride a bicycle in the park?" :topic (:bicycle_paths user)}
                {:sent "Would you like to skate in the park?" :topic (:skating user)}
                {:sent "Would you like to have park some sports_ground?" :topic (:sports_ground user)}
                {:sent "Would you like to have a playground in the park?" :topic (:plauyground user)}
                {:sent "Would you like to walk a dog in the park?" :topic (:dogs user)}])
