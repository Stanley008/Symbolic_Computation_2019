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
  (with-local-vars [name nil]
    (doseq [token sent]
      (if (= token (str/capitalize token))
        (var-set name token)
        (if (= @name nil)
          (var-set name "Visitor"))))
    @name))

(defn ask_for_nickname []
  (dosync
    (println "Do you want me to call you by a nickname?")
    (let [answer (take_user_input)]
      (if (not (nil? (re-find #"[yY]es" answer)))
        (do
          (println "What nickname would you like?")
          (ref-set (:name data/user)
            (find_name (tokenize (strip_punctuation (take_user_input)))))
          (println "Then I will call you" @(:name data/user)))
        (println "As you wish master.")))))

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
