(ns park-chatbot.dog-core
    "The chatbot library that includes all necessary functions for dog_core.clj to run."
    (:require [opennlp.nlp :as nlp]
              [park-chatbot.data :as data]
              [park-chatbot.dog-data :as ddata]
              [clojure.string :as str]))

(def tokenize
  "Initialize the pre-trained tokenizer from 'en-token.bin'."
  (nlp/make-tokenizer "src/en-token.bin"))

(defn match_dog
  "Create/Update the selected dog based on the user preferences.
  topic -> the breed information of the dog that the function searches for;
  user_preference -> string or boolean that represents the selected breed preferences;
  selected_dog -> reference to the dog breed with suitable preferences."
  [topic user_preference selected_dog counter]
  (if (= 1 counter)
    (doseq [dog ddata/dogs]
      (if (= user_preference (topic dog))
        (var-set selected_dog (conj @selected_dog dog))))
    (doseq [dog @selected_dog]
      (if (not= user_preference (topic dog))
        (var-set selected_dog (remove #{dog} @selected_dog))))))

(defn find_dog
  "Find user's preference about a dog breed, then it calls 'match_dog' function.
  dog_question_obj -> the question object (see 'dog_question_obj_vector' from dog_data.clj);
  selected_dog -> reference to the dog breed with suitable preferences."
  [dog_question_obj answer selected_dog counter]
  (let [tokens (tokenize (str/lower-case answer))]
    (doseq [word tokens]
      (if (contains? ddata/dog_preference word)
        (do
          (match_dog (:topic dog_question_obj) word selected_dog counter))
        (if (contains? data/pos_preference word)
          (do
            (match_dog (:topic dog_question_obj) true selected_dog counter))
          (if (contains? data/neg_preference word)
            (do
              (match_dog (:topic dog_question_obj) false selected_dog counter))))))))

(defn give_dog_answers
  "Give the user responses on whether the dog that matches his preference is found or not.
  selected_dog -> reference to the dog breed with suitable preferences."
  [selected_dog]
  (if (empty? @selected_dog)
     (println (rand-nth ddata/dog_not_found))
     (println (rand-nth ddata/dog_found)
       (:name (rand-nth @selected_dog) "."))))
