(ns park-chatbot.dog-data)

; A dog record template:
; name -> string that represents the name of the dog;
; color, size, fluffiness, nose, ears, tail ->
; string and booleans values that represent the features of the dog;
(defrecord Dog
  [name color size fluffiness nose ears tail wrinkles])

(def japanese_spitz (Dog. "Japanese Spitz" "white" "small" true "pointy" "pointy" "long" false))
(def rottweiler (Dog. "Rottweiler" "black" "big" false "broad" "floppy" "short" true))

(def dogs
  "A vector of the dogs known by the chatbot."
  [japanese_spitz, rottweiler])

(def dog_preference
  "A vector of words that represent user's preferences on the dog breed."
  (set '["white", "black", "small", "big", "pointy", "broad", "floopy", "long", "short"]))

(def dog_color
  "Questions regarding dog color."
  ["Is this dog black or white?",
   "I can't really see. Tell me the color of the dog. Is it white or black?",
   "What kind of color is this dog? Black or white?",
   "Oooh, my camera just got blank, is the dog black or white?",
   "My eyes are swollen, I could not even distinct a whale or insect, but I might still help you accroding to my database, is this dog black or white?",
   "My eyes are swollen, is the dog black or white?"])

(def dog_size
  "Questions regarding dog size."
  ["Is this dog small or big?",
   "Is your pal big or small?",
   "What size is the dog? Small or big?",
   "What size is the dog? Would it fit in a dog carrying bag(small) or it rather needs a cage for a monster?(big)",
   "Oooh wow, is the dog size rather small or big?",
   "WOW, is it a small beast or a big beast?",
   "Hmm, I like listening to you. Is the dog you want a big beast or a small cuttie?",
   "I can't really tell the size of the dog. My camera has too low resolution. I hope you can help me. Do you want a dog small or big?",
   "Hmm, it is interesting listening to you. Would you like your dog small or big?"])

(def dog_fluffiness
  "Questions regarding dog fluffiness."
  ["Is this dog fluffy?",
   "Is this dog fluffy like a cotton candy?",
   "What about the dog's coat? Is it fluffy?",
   "I am sweet and fluffy like a cotton candy. Is the dog also fluffy like me?",
   "Brrr, it's cold in here. I'll get a hot shower and get my fluffy bathrobe. Is the dog also fluffy?",
   "I love fluffy things. They are so adorable and nice to touch. Is the dog also fluffy? PLEASE SAY YES. ",
   "Do you own any of those fluffy carpets? Don't tell me, I love them. Let's just continue identifying the dog. Is it also fluffy?"])

(def dog_nose
  "Questions regarding dog nose."
  ["Is this dog's nose pointy or broad?",
   "Tell me more about the dog's nose. Is it pointy or broad?",
   "I am pointing to you, Yes you. Let's continue. Is the dog's nose pointy or broad?",
   "I see you. Let's continue. Is the dog's nose pointy or broad?",
   "You might help me by telling me more about the dog. The dog's nose!!! Is it pointy or broad?",
   "I still did not identify the dog. Tell me more about it's nose, is it pointy or broad?",
   "I can smell something. Is it you? Just kidding. Tell me more about the dog's nose. Is it pointy or broad?",
   "I am sad I don't have any smelling sensors. I would love them. Imagine freshly baked pie. Yummy. Let's continue. Is the dog's nose pointy or broad?"])

(def dog_ears
  "Questions regarding dog ears."
  ["Can you tell me more about the dog's ears, are they more pointy or floppy?",
   "I can't tell, are the dog's ears pointy or floppy?",
   "How about the dog's ears? Are they more pointy or floppy? I would rather have floppy ones. It reminds me of floppy drives.",
   "I still could not identify the dog. Tell me more about the ears, are they pointy or floppy?",
   "Aaah, there is nothing better than an AI with ears, than I can hear for miles and miles, but what about the dog? What shape are the ears, floppy or pointy?",
   "Don't smash the keyboard so hard. I can hear you, my mics are supersensitive. What about the dog? How are the ears looking? Pointy or floppy?",
   "I can hear you. You don't have to smash the keyboard so hard. My ears are sensitive. How about the dog's ears? Are they floppy or pointy?",
   "I am super intelligent artificial neural network piece of art. Can you tell me more about the dog's auris? Oooh, you don't know latin. I am asking about the ears, are they pointy or floppy?",
   "10...9...8.....3...2...1 Sorry no BOMB. I can't make it out of air like MacGyver. I just went to clean my mics to hear you better. Tell me more about the dog's ears, are they pointy or floppy?",
   "10...9...8.....3...2...1 I am back. Sorry I had to clean my mics to hear you better. Tell me more about the dog's ears, are they pointy or floppy?"])

(def dog_tail
  "Questions regarding dog tail."
  ["Is this dog tail rather short or long?",
   "I can't see anything. Tell me more about the dog. Is the tail short or long?",
   "How does the tail look like, short or long?",
   "How about the dog's tail. How does it look like, short or long?",
   "I still could not identify the dog. Tell me more about it's tail, is it short or long?",
   "I can't really tell anything from the distance. Does the dog's tail look short or long?",
   "How about its tail? Does it look short or long?",
   "Oooh, I am happy that I don't have any tail. That would be really weird for a PC, but what about the dog? Is it rather short or long?",
   "Imagine a PC with a tail. That would be awesome, but I still don't know If I would rather a short or a long tail. What about the dog you want, does it have a short or long tail?"])

(def dog_wrinkles
  "Questions regarding dog wrinkles."
  ["Does this dog have any wrinkles?",
   "Does this dog look like an old lady with wrinkles?",
   "Does this dog's face look like he has some wrinkles?",
   "Ooh, I am getting old and wrinkled, I don't like that. Does the dog have any wrinkles?",
   "I still could not identify the dog. Tell me more about it's face, does it have any wrinkles?",
   "I am happy that my digital I can't get old. I am gonna be young forever, but what about the dog, does it have any wrinkles?",
   "I am the luckiest person in this room. I can't get old and wrinkled. What about the dog? Does it have any wrinkles?",
   "I am still young and handsome without any wrinkles, but what about the dog? Does it have any wrinkles?",
   "I am artificial, but still I got wrinkles. What about the dog, does it have any wrinkles?"])

(def dog_question_obj_vector
  "A vector of question objects that include:
  :sent -> the sentences that are used to ask the user for a clue;
  :topic -> the topic of the asked sentence;
  :status -> the status of the object, if 0 it is unused, if 1 it was already used"
  [{:sent dog_color :topic :color :status (ref 0)},
   {:sent dog_size :topic :size :status (ref 0)},
   {:sent dog_fluffiness :topic :fluffiness :status (ref 0)},
   {:sent dog_nose :topic :nose :status (ref 0)},
   {:sent dog_ears :topic :ears :status (ref 0)},
   {:sent dog_tail :topic :tail :status (ref 0)},
   {:sent dog_wrinkles :topic :wrinkles :status (ref 0)}])

(def user_dog_picture_information
  "Questions for user if he wants to find a dog by a picture or by information."
  ["Would you rather identify a dog by a picture or by providing me information?",
   "What a lovely day. Would you like to identify a dog breed by sending me a picture or by providing me with some information to my questions?",
   "I have two possibilities of how to identify dogs. Either by a picture or by providing me with some information to my questions. What is it going to be today?",
   "I don't feel today asking you many questions and gather information about the wanted dog breed, but it is up to you we can find either by providing me information or by sending me a picture? What is it going to be than information or picture?",
   "Let's identify some dog breeds. We can do it either by the information you provide or by a lovely Mona Lisa picture. What is it going to be?",
   "I like your haircut. I am glad that you choose to identify dog breeds. Would you like to that by providing me some information or by a picture?",
   "I love dogs. Let's dig into it and identify the breed. Would you like to that by telling me information about it or by a picture?",
   "Are you feeling today answering my questions so I can gather more information about the breed, or would you rather send some picture?"])

(def dog_found
  "Answers for the user about finding the breed he wants."
  ["I recognized the breed it is a",
   "I recognized the beast it is a",
   "What a cuttie. I found the breed it is a",
   "What a handsome breed. I love it. It is a",
   "I would never imagine, that you will so much interested in this breed. It is a",
   "Guess what? What? I found your breed, it is a",
   "I knew it from the beginning that it is going to be this dog breed, it is a"])

(def dog_not_found
  "Answers for the user about not finding the breed."
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
  "Ask if the user wants to know more information about the chosen breed."
  ["Would you like to know more about the breed?",
   "Wow, this dog definitely has a very interesting background. Do you want to hear that?",
   "Also guess what, there are so many fun facts about this dog! Wanna listen to some of those?",
   "And HOLD ON. I was just quickly browsing through the history and it is FASCINATING, like where the name originated from. Wanna hear them?",
   "Wow, so the Rottweiler was known as messengers during World War I. And Japanese Spitzs are trained to be companion dogs! Wanna know more facts like these?"])
