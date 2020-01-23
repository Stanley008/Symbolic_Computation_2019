(ns park-chatbot.data
  "The chatbot library that includes all necessary data for the cahtbot to function.")

; A user record template:
; name -> string that represents the name of the user;
; wc, restaurant, cafe, bicycle_paths, skating, sports_ground, playground, dogs ->
; boolean values that represent the preferences of the user;
; terminate -> boolean that shows if a user want to end the conversation.
(defrecord User
  [name wc restaurant cafe bicycle_paths skating sports_ground playground dogs terminate])

(def user
  (User. (ref nil) (ref nil) (ref nil) (ref nil) (ref nil) (ref nil) (ref nil) (ref nil) (ref nil) (ref false)))

(def pos_preference
  "A vector of words that represent a positive opinion."
  (set '["yes", "like", "love", "enjoy", "true", "yeah", "great", "ok", "mind",
         "y", "maybe", "nice", "lovely", "amazing", "awesome", "sure", "why not"]))

(def neg_preference
  "A vector of words that represent a negative opinion."
  (set '["no", "not", "don't", "don", "false", "nah", "never", "n", "idk"]))

(def name_words
  "A vector of words that are used by the user when giving names."
  (set '["i", "am", "my", "name", "is", "this", "it", "is", "people", "call", "me", "they", "called"]))

(def greetings
  "A vector of sentences that are used for greeting the user."
  ["Hello, I am Parkbot. I am the most advanced park information bot and I am here to help you. Hello, I am Parkbot.",
   "I am here to serve your needs.",
   "Hi, I am Parkbot. I am here today to help you to find the best park just for you.",
   "Welcome, I am Parkbot. I am here to help you to find the best park just for you.",
   "Hi, I am Parkbot. It’s a pleasure to meet you. I am here to help you.",
   "Hey there, I am Parkbot. I am an advanced interficial park information bot and I am here to help you to find the most suitable park just for you.",
   "Good day. I am the most advanced interfacial park information bot. My name is Parkbot.",
   "Howdy, my name is Parkbot. I am here to help you.",
   "Great to see you. My name is Parkbot. I am advanced park information bot and I am here to help you.",
   "Nice to see you. I am a Parkbot living in Prague. I would like to help you to find the right park just for you.",
   "Look who it is! It’s me, Parkbot and I am here today to help you."])

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
   "WOW, you are the first one. What is your nickname?",
   "Positive answer, nice… I was just wondering, if you can type your nickname here? That’s my only input. Thank you."])

(def nickname_answer
  "A vector of sentences that are used after the user tells his/her nickname."
  ["Than I will call you",
   "It is your choice, I will call you",
   "Your choice, I will call you",
   "I like it. I will call you",
   "Oh wow what a nice nickname, I will call you",
   "Never heard this nickname, I shall call you",
   "Did you type it correctly? I am just kidding, It is your nickname. I am gonna call you",
   "Any mistake in your nickname? Just kidding, I am gonna call you",
   "This is the first time I hear this. I love it",
   "OK, as you wish",
   "Great, I am gonna make your wish come true"])

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

(def user_no_question
  "User do not ask questions."
  ["Please don't ask questions when a question is already asked. My resources are limited.",
   "Be kind and don't ask questions. I am gonna ask everything.",
   "My resources are limited, I will ask you everything I need. Don't reply with questions.",
   "I am going to ask you everything in next few steps. You don't need to ask anything. Let me do my job.",
   "You don't need to ask anything from now on. I will take care of your needs.",
   "You don't need to ask anything from now on. I will handle park options and take care of your needs."
   "No worries. I am here and I will ask you every question I need to find you the best option just for you."])

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
  "Replies when the user want to continue the conversation."
  ["As you wish master."
   "Ok then, let's continue our conversation."
   "Let's talk more then."
   "I'm also fine with that."])

(def user_park_dog
  "Questions regarding user to choose to find a park or dog."
  ["Would you like today to find a park or a dog?",
   "How are you feeling today, would you like to find a right park for you or identify a dog breed?",
   "I feel tired today. Let's make it short. Would you like to find a park or identify a dog breed?",
   "I feel excited today, let's go outside, let's find a park for you or would you rather like to find a dog? What is it going to be on a sunny day? Park or dog?",
   "The sun is shining, you are smiling. Nothing can go wrong today. Would you like to choose a park or to learn a dog breed? Just let me know when you decide.",
   "Oooh what a terrible rainy forecast today. I would advise you to stay at home, but it is your choice if you would like to choose a park to go to, or a dog breed?",
   "I lost internet connection. I can't tell if it is going to be sunny or rainy today. Would you rather get a park recommendation, or identify a dog breed?"])
