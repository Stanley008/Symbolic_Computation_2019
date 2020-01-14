(ns park-chatbot.data
  "The chatbot library that includes all necessary data for the cahtbot to function.")

; A park record template:
; name -> string that represents the name of the park;
; wc, restaurant, cafe, bicycle_paths, skating, sports_ground, playground, dogs ->
; boolean values that represent whether a park has one of the facilities;
; opening_hours -> string that explains when the park is open during the year.
(defrecord Park
  [name wc restaurant cafe bicycle_paths skating sports_ground playground dogs opening_hours])

; A user record template:
; name -> string that represents the name of the user;
; wc, restaurant, cafe, bicycle_paths, skating, sports_ground, playground, dogs ->
; boolean values that represent the preferences of the user;
; terminate -> boolean that shows if a user want to end the conversation.
(defrecord User
  [name wc restaurant cafe bicycle_paths skating sports_ground playground dogs terminate])

; A dog record template:
; name -> string that represents the name of the dog;
; color, size, fluffiness, nose, ears, tail ->
; string and booleans values that represent the features of the dog;
(defrecord Dog
  [color size fluffiness nose ears tail wrinkles])

(def user
  (User. (ref nil) (ref nil) (ref nil) (ref nil) (ref nil) (ref nil) (ref nil) (ref nil) (ref nil) (ref false)))

;
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

;
(def japanese_spitz (Dog. "white" "small" true "pointy" "pointy" "long" "false"))
(def rottweiler (Dog. "black" "big" false "broad" "floppy" "short" "true"))

(def dogs
  "A vector of the dogs known by the chatbot."
  [japanese_spitz, rottweiler])

(def pos_preference
  "A vector of words that represent a positive opinion."
  (set '["yes", "like", "love", "enjoy", "true", "yeah", "great", "affirmative",
         "y", "maybe"]))

(def neg_preference
  "A vector of words that represent a negative opinion."
  (set '["no", "not", "don't", "don", "false", "nah", "never", "n", "idk"]))

(def verbs
  "A vector of words that represent verbs."
  (set '["have", "eat", "drink", "ride", "cycle", "bike", "skate", "play", "practice", "use",
         "do", "walk", "go", "end", "finish", "goodbye", "want", "open", "close", "fun"]))

(def nouns
  "A vector of words that represent nouns."
  (set '["lunch", "breakfast", "dinner", "bike", "sports", "skate", "dog",
         "coffee", "tea", "dessert", "skateboard", "football", "basketball",
         "wc", "meal", "animal", "sport", "cake", "beer"]))

(def name_words
  "A vector of words that are used by the user when giving names."
  (set '["i", "am", "my", "name", "is", "this", "is", "people", "call", "me", "They", "called"]))

(def greetings
  "A vector of sentences that are used for greeting the user."
  ["Hello, I am Parkbot. I am the most advanced park information bot and I am here to help you. Hello, I am Parkbot.",
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

(def name_ask
  "A vector of sentences that are used to ask the user's name."
  ["What is your name?",
   "May I have your name?",
   "How may I address you?",
   "Do you mind if I ask you for your name?",
   "How do they call you?",
   "I am sorry, I did not catch your name. What is your name?",
   "What can I call you?",
   "How do you like to be called?"])

(def nickname_ask_yes_no
  "A vector of sentences that are used to ask if the user want to be called by a nickname."
  ["Do you want me to call you by a nickname?",
   "Would you like to be called by a nickname?",
   "I did not get your nickname, would you like to be called by a nickname?",
   "People rarely do have nicknames, would you like to be called by one?",
   "Ok, now I know your name, but would you like to be rather called by your nickname?",
   "What a nice name, I prefer nicknames. Mine is Parkiebot, would you also like to be called by a nickname?",
   "I never heard this name. I prefer nicknames. Would you like to be called by a nickname?",
   "Oh wow what a nice name. That’s cool, but I prefer nicknames. Mine is Parkiebot. Do you want to be called by a nickname?"])

(def nickname_ask
  "A vector of sentences that are used to ask the user's nickname."
  ["What nickname would you like?",
   "What is your nickname?",
   "I like your answer. I love nicknames. What is yours?",
   "I am thrilled to hear you answer. What is your nickname?",
   "I am waiting for your secret nickname. Tell me it!",
   "WOW, you are the first one. What is your nickname? ",
   "Positive answer, nice… I was just wondering, if you can type your nickname here? That’s my only input. Thank you."])

(def nickname_answer
  "A vector of sentences that are used after the user tells his/her nickname."
  ["Than I will call you",
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

(def nickname_end
  "A vector of sentences that are used if the user does not want a nickname."
  ["OK, as you wish.",
   "As you wish master.",
   "Your choice.",
   "I thought that you love nicknames. Oh well...",
   "What a biggie, but It is your choice.",
   "If you don't like nicknames, there is nothing that I can do.",
   "No problem, I agree."])

(def end_words
  "A vector of words that shows that the user want to end the conversation."
  (set '["exit", "quit", "end", "stop", "execute", "finish", "die", "shut down", "kill", "leave", "bye"]))

(def user_questions
  "User predefined questions asking about him."
  ["How are you?",
   "How are you feeling today?",
   "What always makes you smile?",
   "What was your favorite moment thus far today?",
   "What was your last dream about?",
   "What’s your most (un)healthy habit?",
   "When you were little, what did you think you were going to be?",
   "What talent do you wish you’d have?",
   "If there is anything you would do differently in your life, what would it be?",
   "Who would you like to have dinner with tonight (could be anyone, dead or alive)?",
   "Which music genre do you listen to the most?",
   "What is your favourite band?",
   "What is your favourite movie?",
   "What advice would you give your 20-year old self?",
   "What is your biggest fear that you’ve overcome?",
   "What is the most unbelievable thing that’s ever happened to you?",
   "Where would you live if you had no ties to any specific place?",
   "What was your favorite subject in school?",
   "What was the last book that you read?",
   "What was the best gift you have ever received?",
   "What did you love doing as a child that you don’t do anymore?",
   "How do you relax yourself when stressed out?",
   "What is your favorite meal?",
   "What is your favorite drink?",
   "What was the last picture you took?",
   "If money wasn’t an issue, how would that make your life different?",
   "What is your favorite thing you have at home?"])

(def user_goodbye
  "User goodbye answers."
  ["As you wish master.",
   "Bye.",
   "Goodbye.",
   "Bye-bye.",
   "Take care.",
   "See you later.",
   "Catch you later.",
   "See you soon.",
   "Have a nice day.",
   "Have a good day.",
   "I am looking forward for the next meeting.",
   "I'm out. Bye.",
   "See you next time.",
   "Don't look at me. I am going home. Bye.",
   "Nice talking to you. Bye-bye.",
   "See ya!",
   "I gotta hit the road. Take care.",
   "Time to leave, see you later.",
   "Time to serve another user. Have a nice day."])

(def user_park_not_find
  "User not find park answers."
  ["I could not find an apropriate park for you.",
   "I could not find anything. I am reallly sorry.",
   "I have tried hard, but I could not find anything suitable for you.",
   "I have tried hard, But I could not find anything regarding your needs.",
   "My information system does not show anything that will suit you. I am really sorry.",
   "I don't know how to say it, but nothing suits you. I would advice you to visit BRNO instead."
   "I am really sorry, but I could not find an appropriate park for you. Atleast I can advice you the most beautiful park in the world Royal Botanics Garden in Melbourne. What a great trip would that be."])

(def user_visit
  "User visit answers."
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

(def user_no_question
  "User do not ask questions."
  ["Please don't ask questions when a question was already written. My resources are limited.",
   "Be kind and don't ask questions. I am gonna ask everything.",
   "My resources are limited, I will ask you everything I need. Don't reply with questions.",
   "I am going to ask you everything in next few steps. You don't need to ask anything. Let me do my job.",
   "You don't need to ask anything from now on. I will take care of your needs.",
   "You don't need to ask anything from now on. I will handle park options and take care of your needs."]
  "No worries. I am here and I will ask you every question I need to find you the best option just for you.")

(def user_end_questions
  "User questions to end the conversation."
  ["Do you want to end this conversation?",
   "Would you like to end this conversation?",
   "I feel tired. Would you like to end this chat?",
   "Aren't you feeling tired? Should we call it a day?",
   "Oooh well my ram is filling up. What about yours? Would you like to end this conversation?",
   "My cpu is getting hot, what about yours? Would you like to finish this conversation?",
   "There is a 50/50 chance that you will reply this correctly. Would you like to end this conversation? SMILE :D",
   "Aren't you feeling already tired for today? Would you like to end our talk?",
   "I am not feeling well, what about you? Should we call it a day?"])

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

(def question_objects
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

(def user_reply
  "User reply answers."
  ["That's interesting.",
   "That's great.",
   "That's very good.",
   "OK.",
   "Good.",
   "Fine.",
   "Fair.",
   "Approved",
   "Not bad."])

(def user_continue_conv
  "Replies if the user want to continue the conversation."
  ["As you wish master."
   "Ok then, let's continue our conversation."
   "Let's talk more then."
   "I'm also fine with that."])

(def dog_color
  "Questions regarding dog color."
  ["Is this dog black or white?",
   "I can't really see, tell me the color of the dog, is it white or black?",
   "What kind of color is this dog? Black or white?",
   "Oooh, my camera just got blank, is the dog black or white?",
   "My eyes are swollen, I could not even distinct a whale from insect, but I might still help you accroding to my database, is this dog black or white?",
   "My eyes are swollen, is the dog black or white?"])

(def dog_size
  "Questions regarding dog size."
  ["Is this dog small or big?",
   "Is your pal big or small?",
   "What size is the dog? Small or big?",
   "What size is the dog? Would it fit in a dog carrying bag?(small) or rather it needs a cage like a monster?(big)",
   "Oooh wow, is the dog size rather small or big?",
   "Oooh, is the dog size on the small size or big side?",
   "WOW, is it a small beast or a big beast?",
   "Hmm, I like listening to you. Is your wanted dog a big beast or small cuttie?",
   "I can't really tell the size of the wanted dog. My camera has too low resolution. I hope you can help me. Is your wanted dog small or big?",
   "Hmm, interesting listening to you. Is your wanted dog small or big?"])

(def dog_fluffiness
  "Questions regarding dog fluffiness."
  ["Is this dog fluffy?",
   "I am fluffy as a cotton candy. Yummy. What about the dog is it fluffy?",
   "Is this dog fluffy like a cotton candy?",
   "What about the dog's hair? Is it fluffy?",
   "I am sweet and fluffy like a cotton candy. Is the dog also fluffy like me?",
   "Brrr, it's cold in here. I'll get a hot shower and get my fluffy bathrobe. Is the dog also fluffy?",
   "I love fluffy things. They are so adorable and nice to touch. Is the dog also fluffy? Please tell me YES. ",
   "Do you own any of those fluffy carpets? Don't tell me I love them. Let's just continue identifying the dog. Is it also fluffy?"])

(def dog_nose
  "Questions regarding dog nose."
  ["Is this dog's nose pointy or broad?",
   "Tell me more about the dog's nose. Is it pointy or broad?",
   "I am pointing to you, Yes you. Let's continue. Is the dog's nose pointy or broad?",
   "I see you. Let's continue. Is the dog's nose pointy or broad?",
   "You might help me by telling me more about the dog. Dog's nose is it pointy or broad?",
   "I still did not identify the dog. Tell me more about it's nose, is it pointy or broad?",
   "I can smell something. Is it you? Just kidding. Tell me more about dog's nose is it pointy or broad?",
   "I am sad I don't have any smelling sensors. I would love them. Imagine freshly baked pie. Yummy. Let's continue. Does the dog's nose look pointy or broad?"])

(def dog_ears
  "Questions regarding dog ears."
  ["Can you tell me more about the dog's ears, are they more pointy or floppy?",
   "I can't tell, are the dog's ears pointy or floppy?",
   "How about the dog's ears? Are they more pointy or floppy? I would rather have floppy ones. It reminds me of floppy drives.",
   "I still could not identify the dog. Tell me more about it's ears, are they pointy or floppy?",
   "Aaah, there is nothing better than an AI with ears, than I can hear for miles and miles, but what about the dog? What shape are ears floppy or pointy?",
   "Don't smash the keyboard so hard. I can hear you, my mics are supersensitive. What about the dog? How are it's ears looking? Pointy or floppy? ",
   "I can hear you. You don't have to smash the keyboard so hard. My ears are sensitive. How about the dog's ears are they floppy or pointy?",
   "I am super intelligent artificial neural network piece of art. Can you tell me more about the dog's auris? Oooh, you don't know latin. I am asking about the ears, are they pointy or floppy?",
   "10...9...8... ... ...3...2...1 Sorry no BOMB. I can't make it out of air like MacGyver. I just went to clean my mics to hear you better. Tell me more about the dog's ears, are they pointy or floppy?",
   "10...9...8... ... ...3...2...1 I am back. Sorry I had to clean my mics to hear you better. Tell me more about the dog's ears, are they pointy or floppy?"])

(def dog_tail
  "Questions regarding dog tail."
  ["Is this dog tail rather short or long?",
   "I can't see anything. Tell me more about the dog. Is it's tail short or long?",
   "How does the tail look like, short or long?",
   "How about the dogs tail. How does it look like, short or long?",
   "I still could not identify the dog. Tell me more about it's tail, is it short or long?",
   "I can't really tell anything from the distance. Does the dog's tail look like to be short or long?",
   "How about it's tail? Does it look like short or long?",
   "Oooh, I am happy that I don't have any tail. That would be really weird for a PC, but what about the dog? Is it rather short or long?",
   "Imagine a PC with a tail. That would be awesome, but I still don't know If I would rather a short or a long tail. What about your wanted dog, does it have a short or long tail?"])

(def dog_wrinkles
  "Questions regarding dog wrinkles."
  ["Does this dog have any wrinkles?",
   "Does this dog look like an old lady with wrinkles?",
   "Does this dog's face look like that he has some wrinkles?",
   "Ooh, I am getting old and wrinkled, I don't like that. Does the dog have any wrinkles?",
   "I still could not identify the dog. Tell me more about it's face, does it have any wrinkles?",
   "I am happy that my digital I can't get old. I am gonna be young forever, but what about the dog, does it have any wrinkles?",
   "I am the luckiest person in this room. I can't get old and wrinkled. What about the dog? Does it have any wrinkles?",
   "I am still young and handsome without any wrinkles, but what about the dog? Does it have any wrinkles?",
   "I am artificial, but still I got wrinkles. What about the dog, does it have any wrinkles?"])

(def user_park_dog
  "Questions regarding user to choose to find a park or dog."
  ["Would you like today to find a park or a dog?",
   "How are you feeling today, would you like to find a right park for you or to identify a dog breed?",
   "I feel tired today. Let's make it short. Would you like to find a park or to identify a dog breed?",
   "I feel excited today, let's go outside, let's find a park for you or would you like to find a dog rather? What is it going to be on a sunny day? Park or dog?",
   "The sun is shining, you are smiling. Nothing can go wrong today. Would you like to advise a park or to identify a dog breed? Just let me know when you decide.",
   "Oooh what a terrible rainy forecast today. I would advise you to stay at home, but it is your choice if you would like to advise a park to go to, or to identify a dog breed?",
   "I lost internet connection. I can't tell if it is going to be sunny or rainy today. Would you rather get and advise which park to choose, or to identify a dog breed?"])

(def user_dog_picture_information
  "Questions regarding user to choose to find a dog by a picture or by information."
  ["Would you rather identify a dog by a picture or by providing me information?",
   "What a lovely day. Would you like to identify a dog breed by sending me a picture or by providing me with some information to my questions?",
   "I have two possibilities of how to identify dogs. Either by a picture or by providing me with some information to my questions. What is it going to be today?",
   "I don't feel today asking you many questions and gather information about the wanted dog breed, but it is up to you we can find either by providing me information or by sending me a picture? What is it going to be than information or picture?",
   "Let's identify some dog breeds. We can do it either by the information you provide or by a lovely Mona Lisa picture. What is it going to be?",
   "I like your haircut. I am glad that you choose to identify dog breeds. Would you like to that by providing me some information or by a picture?",
   "I love dogs. Let's dig into it and identify the breed. Would you like to that by telling me information about it or by a picture?",
   "Are you feeling today answering my questions so I can gather more information about the breed, or would you rather send some picture?"])

(def dog_rottweiler
  "Answers to the user regarding finding the wanted breed."
  ["I recognized the breed it is a Rottweiler.",
   "I recognized the beast it is a Rottweiler.",
   "What a cuttie. I found the breed it is a Rottweiler.",
   "What a handsome breed. I love it. It is a Rottweiler.",
   "I would never imagine, that you will so much interested in this breed. It is a Rottweiler.",
   "Guess what? What? I found your breed, it is a Rottweiler.",
   "I knew it from the beginning that it is going to be this dog breed, it is a Rottweiler."])

(def dog_japanese_spitz
  "Answers to the user regarding finding the wanted breed."
  ["I recognized the breed it is a Japanese Spitz.",
   "I recognized the beast it is a Japanese Spitz.",
   "What a cuttie. I found the breed it is a Japanese Spitz.",
   "What a handsome breed. I love it. It is a Japanese Spitz.",
   "I would never imagine, that you will so much interested in this breed. It is a Japanese Spitz.",
   "Guess what? What? I found your breed, it is a Japanese Spitz.",
   "I knew it from the beginning that it is going to be this dog breed, it is a Japanese Spitz."])

(def dog_not_found
  "Answers to the user regarding not finding the breed."
  ["I am sorry but I did not find the breed according to the information you provided.",
   "I tried my best but none of the breeds fits your information.",
   "I tried really hard, but no breed was found.",
   "I am sorry but according to your information, no dog breed fits.",
   "Hmm... I tried everything. I could even boil eggs on my CPU, but I could not find an appropriate dog breed.",
   "I did everything I could, but I could not recognize the dog breed.",
   "I don't have good news. How to tell you, I could not recognize the dog breed."])

(def dog_info_rottweiler
  "Information of Rottweiler such as breed, history, and fun facts."
  ["Do you know that the Rottweiler is known for their loyal, loving, and confident characters?",
   "The Rottweiler can easily get overweight so they need high-quality food and LOTS OF EXERCISES!",
   "The Rottweiler loves SWIMMING, especially with their people. AWWWWNNNN!!!",
   "The Rottweiler can only live up to 9-10 years :(",
   "The name 'Rottweiler' comes from the town called, Rottweil from the southern Germany. The name 'rot' is from the red tile roofs whereas 'wil' for villa in Roman. CUTE!",
   "In 1910, the Rottweiler received recognition by the German Police Dog Association as the fourth official police dog. Wow, that is SMARTTT!!!",
   "The Rottweiler was one of the first breeds to become guide dogs for the blind. Such a skilled dog!",
   "The Rottweiler has a natural guarding instinct that can be traced back to their ancestors and it makes them exceptional watchdogs.",
   "Do you know that Rottweilers bravely served as search-and-rescue workers at disaster sites as Oklahoma City bombing and the World Trade Center on 9/11.",
   "Most Rottweilers are well-known for being extremely intelligent and highly trainable but some can be very stubborn.",
   "You know the Rottweiler tends to shred a lot, usually in the spring and fall despite having medium-length flat furs. You gotta groom them more often in those seasons!"])

(def dog_info_japanese_spitz
  "Information of Japanese Spitz such as breed, history, and fun facts."
  ["The Japanese Spitz is known as The 'Cloud Dog' due to their FLUFFY white appearance. Awww, they are like clouds that can bard, WOOOFF!!!",
   "Do you know you should not give the Japanese Spitz baths very often as it can remove their essential oils and dry out their skin. BE CAREFUL!!!",
   "Even though the Japanese Spitzs have long and thick furs, they don't really retain the dirt smell. So bathing them a few times a year is more than fine!",
   "So the Japanese Spitz can live from 10 to 16 years old and that makes them one of the LONGEST living dog breeds. WOWIEEEEE!!!",
   "Even though the Japanese Spitzs look a small floof cloud, they can and love to play canine sports like flyball, frisbee, and fetch. HOW CUTE!!!",
   "The Japanese Spitz is a very handy doggo for active seniors since they love occasional slow and long jogs, plus they love MEETING NEW PEOPLE. Awwww!!!",
   "Although the Japanese Spitzs are extremely social, they can go from extremely shy and timid, to stress of anxiety when socialized incorrectly. Make sure to keep a look out for them!",
   "The Japanese Spitz puppies usually cost between $1,000 and $2,500 because they are so rare. WOWIEEEEE!!!",
   "Do you know why the Japanese Spitz is white? It is because their ancestors, Samoyed were originally known to herd reindeer in the cold arctic. So INTERESTING!",
   "Despite having thick and long fur, the Japanese Spitz CANNOT tolerate the cold very well AT ALL. And they prefer mild andn warm temperature.",
   "The Japanese Spitzs are not picky eaters at all and in fact, they love to munch on a carrot or other dog-friendly fruits and vegetables. Such healthy doggos!!!",
   "The Japanese Spitzs love their owners so much, they don't do well when being left on their own for long and can cause destructive behaviors. Poor doggos :("])

(def question_dog_info
  "Asks if the user wants to know more information about the chosen breed."
  ["Would you like to know more about the breed?",
   "Wow, this dog definitely has a very interesting background. Do you want to hear that?",
   "Also guess what, there are so many fun facts about this dog! Wanna listen to some of those?",
   "And HOLD ON. I was just quickly browsing through the history and it is FASCINATING, like where the name originated from. Wanna hear them?",
   "Wow, so the Rottweiler was known as messengers during World War I. And Japanese Spitzs are trained to be companion dogs! Wanna know more facts like these?"])
