(ns cayenne-browse.page
  (:require [selmer.parser :refer [render-file]]
            [selmer.filters :refer [add-filter!]]))

;; switch between CDN and local resources

;; generate page layout with content

(def asset-path "")

(def template-path "")

(defn page [content-template content-data]
  (render-file
   (str "templates/" (name content-template) ".html")
   content-data))

;; General filters for all templates

(add-filter! :mapnth (fn [m n] (map #(nth % (Integer/parseInt n)) m))) 

(add-filter! :keys keys)

(add-filter! :vals vals)
