(defproject lein-zeroconf "0.1.0"
  :description "lein repl hook to register in zeroconf"
  :url "http://github.com/piranha/lein-zeroconf"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :eval-in-leiningen true
  :dependencies [[eu.cassiel/clojure-zeroconf "1.1.0"
                  :exclusions [org.clojure/clojure]]])
