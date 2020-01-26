(defproject park_chatbot "2.0.0"
  :description "Park chatbot which choose appropriate parks based on user's
                preferences and with dog breed recognition feature included"
  :url "https://stanley008.github.io/Symbolic_Computation_2019/"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [clojure-opennlp "0.5.0"]
                 [thinktopic/cortex "0.9.22"]
                 [net.mikera/imagez "0.12.0"]
                 [thinktopic/think.image "0.4.16"]]
  :repl-options {:init-ns park-chatbot.core}
  :main park-chatbot.core)
