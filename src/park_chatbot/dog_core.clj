(ns park-chatbot.dog
    "The chatbot library that includes all necessary functions for dog.clj to run."
    (:require [park-chatbot.data :as data]
              [clojure.string :as str]))

(defn match_dog
  "Creates/Updates the selected dog based on the user preference.
  topic -> the breed information of the dog that the function searches for;
  user_preference -> boolean, represents wether the user wants that facility included;
  selected_dog -> reference to the dog breed with suitable preferences."
  [topic user_preference selected_dog counter
   (if (= 1 counter)
     (doseq [dog data/dogs]
       (if (= user_preference (topic dog))
         (var-set selected_dog (conj @selected_dog dog)))))])

(defn find_dog
  "Finds user's preference about a dog breed, then it calls 'match_dog' function.
  dog_question_obj -> the question object (see 'dog_question_objects' from data.clj);
  selected_dog -> reference to the dog breed with suitable preferences."
  [dog_question_obj answer selected_dog counter]
  (let [tokens (tokenize (str/lower-case answer))]
    (doseq [word tokens]
      (if (contains? data/dog_preference word)
        (do
          (match_dog (:topic dog_question_obj) word selected_dog counter))
        (if (contains? data/pos_preference word)
          (do
            (match_dog (:topic dog_question_obj) true selected_dog counter))
          (if (contains? data/neg_preference word)
            (do
              (match_dog (:topic dog_question_obj) false selected_dog counter))))))))
