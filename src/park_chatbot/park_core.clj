(ns park-chatbot.park
    "The chatbot library that includes all necessary functions for park.clj to run."
    (:require [park-chatbot.data :as data]
              [park-chatbot.park-data :as pdata]
              [clojure.string :as str]))

(defn match_park
  "Creates/Updates the list of selected parks based on the user preference.
  topic -> the facility of the park that the function searches for;
  user_preference -> boolean, represents wether the user want that facility included;
  selected_parks -> reference to the list of parks with suitable preferences."
  [topic user_preference selected_parks counter
   (if (= 1 counter)
     (doseq [park pdata/parks]
       (if (= user_preference (topic park))
         (var-set selected_parks (conj @selected_parks park)))
      (doseq [park @selected_parks]
        (if (not= user_preference (topic park))
          (var-set selected_parks (remove #{park} @selected_parks))))))])

(defn find_park
  "Finds user's preference about a park facility and updates the facility preference
  values in the user record with true/false. Then it calls 'match_park' function.
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
