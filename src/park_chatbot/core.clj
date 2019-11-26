(ns park-chatbot.core
    (:require [opennlp.nlp :as nlp]
        [park-chatbot.data :as data]
        [clojure.string :as str]))

(def tokenize (nlp/make-tokenizer "src/en-token.bin"))

(defn take_user_input []
  """Take user input from CLI"""
  (let [user_input (read-line)]
    user_input))

(defn strip_punctuation [text]
  """Remove puntuation from a string"""
  (str/replace text #"[.?,;:!]" ""))

(defn find_name [sent]
  """Ask user's name"""
  (with-local-vars [name nil]
    (doseq [token sent]
      (if (= token (str/capitalize token))
        (var-set name token)
        (if (= @name nil)
          (var-set name "Visitor"))))
    @name))

(defn ask_for_nickname []
  """Ask the user whether he wants to be called by a nickname and if so, call as such"""
  (dosync
    (println (rand-nth data/nickname_ask_yes_no))
    (let [answer (take_user_input)]
      (if (not (nil? (re-find #"[yY]es" answer)))
        (do
          (println (rand-nth data/nickname_ask))
          (ref-set (:name data/user)
            (find_name (tokenize (strip_punctuation (take_user_input)))))
          (println (rand-nth data/nickname_answer) @(:name data/user) "."))
        (println (rand-nth data/nickname_end))))))

(defn find_preferences [question_obj answer]
  """Find preference from the user's answer and raise a flag (true/false) in user records"""
  (dosync
    (let [tokens (tokenize answer)]
      (doseq [word tokens]
        (if (contains? data/pos_preference word)
          (ref-set (:topic question_obj) true)
          (if (contains? data/neg_preference word)
            (ref-set (:topic question_obj) false)))))))

(defn end_conversation? []
  (dosync
    (println "Do you want to end this conversation?")
    (let [answer (take_user_input)]
      (if (not (nil? (re-find #"[yY]es" answer)))
        (ref-set (:terminate data/user) true)
        (println "As you wish master.")))))

(defn parkbot_loop []
  (with-local-vars [count 1
                    word_class {:verb nil :noun nil}
                    user_input ""
                    question_obj "Do you want to ride the bike in the park?"]
    (println @question_obj)
    (while (not @(:terminate data/user))
      (let []
        (var-set user_input (take_user_input))


        (if (= 0 (rem @count 5))
          (end_conversation?))
        (var-set count (+ @count 1))))
    (println "Ok goodbye.")))

(defn -main []
  """Main function"""
  (dosync
    (print (rand-nth data/greetings))
    (newline)
    (println (rand-nth data/name_ask))
    (ref-set (:name data/user)
      (find_name (tokenize (strip_punctuation (take_user_input)))))
    (println "Welcome" @(:name data/user))
    (ask_for_nickname)
    (println "How are you?")
    (take_user_input)
    (parkbot_loop)))
