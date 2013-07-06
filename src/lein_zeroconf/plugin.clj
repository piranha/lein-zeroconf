(ns lein-zeroconf.plugin
  (:require [robert.hooke :refer [add-hook]]
            [clojure.tools.nrepl.server]
            [cassiel.zeroconf.server :as s]))

(def zeroserver (atom nil))

(defn start-server [port]
  (reset! zeroserver (s/server :type "_nrepl._tcp.local."
                               :name (str "nREPL-" port)
                               :port port
                               :text "A nREPL server"))
  (doto (Thread. #(s/open @zeroserver))
    (.setDaemon true)
    (.start)))

(defn shutdown-server []
  (when @zeroserver
    (s/close @zeroserver)))

(defn server-hook [f & args]
  (let [server (apply f args)
        port (-> @server :ss .getLocalPort)]
    (start-server port)
    server))

(defn hooks []
  (add-hook #'clojure.tools.nrepl.server/start-server #'server-hook)
  (.addShutdownHook (Runtime/getRuntime) (Thread. shutdown-server)))
