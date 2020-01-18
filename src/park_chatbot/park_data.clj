(ns park-chatbot.park-data)

; A park record template:
; name -> string that represents the name of the park;
; wc, restaurant, cafe, bicycle_paths, skating, sports_ground, playground, dogs ->
; boolean values that represent whether a park has one of the facilities;
; opening_hours -> string that provides when the park is open during the year.
(defrecord Park
  [name wc restaurant cafe bicycle_paths skating sports_ground playground dogs opening_hours])

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

(def parks
  "A vector of the parks known by the chatbot."
  [betramka, fran_garden, obora, kampa, zahrada, klam, ladronka,
   letna, petrin, riegrovy, stromovka, vajanovy, vysehrad])

(def park_found
  "Answers for the user about finding the park he wants."
  ["You can visit",
   "You can go to",
   "I would advice you to go to",
   "My most recent informations, shows the best solution for you is",
   "My advice would be to go to",
   "Oooh, I see. That way I would advice you park",
   "That's not my most favourite choice, but you chose the requirements and the best park for you is",
   "Naaah, that's not my most favourite park, but it is your choice and I would advice you to go to",
   "Allright, I heard everything I needed and my advice is to go to",
   "Interesting replies. My information system shows that most suitable park is"])

(def park_not_found
  "Answers for the user about not finding the park."
  ["I could not find an apropriate park for you.",
   "I could not find anything. I am reallly sorry.",
   "I have tried hard, but I could not find anything suitable for you.",
   "I have tried hard, But I could not find anything regarding your needs.",
   "My information system does not show anything that will suit you. I am really sorry.",
   "I don't know how to say it, but nothing suits you. I would advice you to visit BRNO instead."
   "I am really sorry, but I could not find an appropriate park for you. Let me at least suggest you the most beautiful park in the world, which is Royal Botanics Garden in Melbourne. That would be a good trip."])

(def question_restrooms
  "Questions regarding restrooms."
  ["Would you like to have restrooms in the park?",
   "Would you like to visit restrooms in the park? ",
   "Would you like to be able to use toilets in the park?",
   "Would you like to be able to use restrooms in the park?",
   "Are restrooms important for you? Would you like to have them in the park?"])

(def question_restaurant
  "Questions regarding restaurants."
  ["Would you like to visit a restaurant in the park?",
   "Would you like to have a restaurant in the park?",
   "Would you like to be able to eat in a restaurant in the park?",
   "Are restaurants important for you? Would you like to visit one in the park?",
   "Are you getting hungry often? Would you like to visit a restaurant in the park?",
   "There is nothing better than a good meal. Would you like to visit a restaurant in the park?"])

(def question_cafe
  "Questions regarding cafes."
  ["Would you like to visit a cafe in the park?",
   "Would you like to grab a cup of coffee in the park?",
   "Would you like some nice cup of an espresso or any other coffee in the park?",
   "Are you a coffee person? Would you like to have a shot of coffee in the park?",
   "Are you black beans(=coffee) lover? Would you like to have a cafe in the park?",
   "Aren't you feeling tired? Wouldn't you like a cup of coffee in the park?",
   "I am feeling tired. I need to wake up. I need a cup of coffee. Would you like to join me and get a cup of coffee in the park also?"])

(def question_bicycle
  "Questions regarding bicycles."
  ["Would you like to ride a bicycle in the park?",
   "Are you a fan of bicycles? Would you like to ride a bicycle in the park?",
   "I don't feel like walking today and maybe even you, wouldn't you rather ride a bicycle in the park?",
   "Are you a bike fan? Would you like to join me in the park riding a bike side by side?",
   "There is nothing wrong with walking, but riding a bike is much better. Would you like to ride a bike in the park?"])

(def question_skate
  "Questions regarding skating."
  ["Would you like to skate in the park?",
   "Do you like skating? Would you like to have a nice ride in the park?",
   "Is skating your favourite hobby? Would you like to have a ride in the park?",
   "If you are not a big bike fan I can advice use you to use your skates. Would you like to skate in the park?",
   "If you don't feel like walking today. Can I advice you to use skates? Would you like to skate in the park? "])

(def question_sports
  "Questions regarding sports."
  ["Would you like to play some sports in the park?",
   "Are you a sports person? Would you like to play some sports in the park?",
   "I am a huge fan of sports. How about you? Would you like to play some in the park?",
   "It's time to move! Don't you think so? Would you like to do some sports in the park?",
   "Would you like to play some sports in the park? It's a great oppurtunity to meet friends.",
   "It's time to get healthy! Would you like to play sports in the park? "])

(def question_playground
  "Questions regarding playground."
  ["Would you like a playground in the park?",
   "Would you like to have a playpark?",
   "Do you have kids? Would you like to have a playground in the park?",
   "Would you like to be able to play in the park?"])

(def question_dog
  "Questions regarding dog."
  ["Would you like to walk your dog in the park?",
   "Do you have a dog? Would you like to walk it in the park?",
   "Don't you have a small pal that you would like to walk in the park?",
   "Do you have a small buddy that you would like to walk in the park?"])

(def park_question_obj_vector
  "A vector of question objects that include:
  :sent -> the sentences that are used to ask the user for a preference;
  :topic -> the topic of the asked sentence;
  :status -> the status of the object, if 0 it is unused, if 1 it was already used"
  [{:sent question_restrooms :topic :wc :status (ref 0)}
   {:sent question_restaurant :topic :restaurant :status (ref 0)}
   {:sent question_cafe :topic :cafe :status (ref 0)}
   {:sent question_bicycle :topic :bicycle_paths :status (ref 0)}
   {:sent question_skate :topic :skating :status (ref 0)}
   {:sent question_sports :topic :sports_ground :status (ref 0)}
   {:sent question_playground :topic :playground :status (ref 0)}
   {:sent question_dog :topic :dogs :status (ref 0)}])
