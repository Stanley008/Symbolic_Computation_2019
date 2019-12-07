(defproject park_chatbot "0.1.0-SNAPSHOT"
  :description "Park_chatbot with Clojure"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [clojure-opennlp "0.5.0"]]
  :repl-options {:init-ns park-chatbot.core}
  :main park-chatbot.core)
