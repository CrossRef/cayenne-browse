(ns cayenne-browse.members
  (:require [cayenne-browse.api :as api]
            [cayenne-browse.page :refer [page]]
            [compojure.core :refer [defroutes GET]]
            [selmer.filters :refer [add-filter!]]
            [clojure.string :as str]))

;; features yes / no, percentage      - grid of gauges
;; year by year publication breakdown - time series
;; list of journals                   - table
;; list of funding sources            - table
;; list of ORCIDs                     - table
;; list of licenses                   - table
;; breakdown by content type          - pie chart
;; info
;; - prefixes
;; - update policies
;; - name
;; - address
;; - total DOIs

(defn member-logo-url [member-name]
  (let [domain-guess (-> member-name
                         (str/split #" ")
                         first
                         str/lower-case
                         (str/replace #"[^a-z0-9]" "")
                         (str ".com"))]
    (str "https://logo.clearbit.com/" domain-guess)))

(defn members []
  ())

(defn orcid-profile [orcid] orcid)

(defn member-journals [id]
  ())

(defn member-funding-sources [id]
  ())

(defn member-orcids [id]
  ())

(defn member-licenses [id]
  ())

(defn member [id]
  (-> {}
      (assoc :member (api/member id))
      (assoc :types (api/works-breakdown :type-name "*"
                                         {:filter {:member id}}))
      (assoc :updates (api/works-breakdown :update-type "*"
                                           {:filter {:member id}}))))

(defroutes routes
  (GET "/" []
       (page :members {}))
  (GET "/search/:terms" [terms]
       (page :member-search-results
             {:member-results (->> (api/members {:query terms})
                                   (take 10))}))
  (GET "/:id" [id]
       (page :member (member id))))

(add-filter! :member-logo-url member-logo-url)
