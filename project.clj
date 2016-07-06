(defproject crossref/cayenne-browse "0.1.0"
  :description ""
  :url "http://browse.crossref.org"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/data.json "0.2.6"]
                 [ring/ring-defaults "0.2.1"]
                 [compojure "1.5.1"]
                 [http-kit "2.1.18"]
                 [selmer "1.0.7"]
                 [environ "1.0.3"]
                 [slingshot "0.12.2"]]
  :main ^:skip-aot cayenne-browse.server
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
