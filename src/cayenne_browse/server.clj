(ns cayenne-browse.server
  (:require [org.httpkit.server :as server]
            [selmer.middleware :refer [wrap-error-page]]
            [environ.core :refer [env]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [compojure.handler :as handler]
            [compojure.core :refer [defroutes GET context]]
            [compojure.route :as route]
            [cayenne-browse.members :as members]))

(defroutes all-routes
  (context "/members" [] members/routes)
  (route/resources "/static/")
  (route/not-found ""))

(def site
  (-> all-routes
      (wrap-defaults site-defaults)
      wrap-error-page))

(defonce server (atom nil))

(defn start []
  (let [config {:port (if (env :server-port)
                        (Integer/parseInt (env :server-port))
                        8080)
                :thread (or (env :server-threads) 24)}]
    (reset! server (server/run-server #'site config))))

(defn stop []
  (when-not (nil? @server)
    (@server :timeout 1000)
    (reset! server nil)))

(defn -main [& args]
  (start))
