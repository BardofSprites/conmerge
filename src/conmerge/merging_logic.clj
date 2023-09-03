(ns conmerge.merging-logic
  (:require [clojure.data.csv :as csv]
            [clojure.java.io :as io]))

(defn parse-csv [csv-file]
  (with-open [rdr (io/reader csv-file)]
    (doall (csv/read-csv rdr))))

(defn print-contacts [contacts]
  (doseq [contact contacts]
    (println "Contact Map:" contact)
    (println "Name:" (get contact :Name))
    (println)))
