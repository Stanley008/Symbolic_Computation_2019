(ns park-chatbot.park-core
    "The chatbot library that includes all necessary functions for park_core.clj to run."
    (:require [opennlp.nlp :as nlp]
              [park-chatbot.data :as data]
              [park-chatbot.park-data :as pdata]
              [clojure.string :as str]))

(def tokenize
  "Initialize the pre-trained tokenizer from 'en-token.bin'."
  (nlp/make-tokenizer "src/en-token.bin"))

(defn match_park
  "Create/Update the list of selected parks based on the user preference.
  topic -> the facility of the park that the function searches for;
  user_preference -> boolean that represents the park preferences of the park;
  selected_parks -> reference to the list of parks with suitable preferences."
  [topic user_preference selected_parks counter]
  (if (= 1 counter)
    (doseq [park pdata/parks]
     (if (= user_preference (topic park))
       (var-set selected_parks (conj @selected_parks park))))
    (doseq [park @selected_parks]
      (if (not= user_preference (topic park))
        (var-set selected_parks (remove #{park} @selected_parks))))))

(defn find_park
  "Find user's preference about a park facility and updates the facility preference
  values in the user record with true/false. Then it calls 'match_park' function;
  park_question_obj -> the question object (see 'park_question_objects' from data.clj);
  selected_parks -> reference to the list of parks with suitable preferences."
  [park_question_obj answer selected_parks counter]
  (let [tokens (tokenize (str/lower-case answer))]
    (doseq [word tokens]
      (if (contains? data/pos_preference word)
        (do
          (ref-set ((:topic park_question_obj) data/user) true)
          (match_park (:topic park_question_obj) true selected_parks counter))
        (if (contains? data/neg_preference word)
          (do
            (ref-set ((:topic park_question_obj) data/user) false)
            (match_park (:topic park_question_obj) false selected_parks counter)))))))

(defn give_park_answers
  "Give the user responses on whether the park that matches his preference is found or not.
  selected_parks -> reference to the list of parks with suitable preferences."
  [selected_parks]
  (if (empty? @selected_parks)
    (println (rand-nth pdata/park_not_found))
    (println (rand-nth pdata/park_found)
      (:name (rand-nth @selected_parks) "."))))
