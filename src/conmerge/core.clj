(ns conmerge.core
  (:require [conmerge.parser :as parser]
            [conmerge.merger :as merger]))
(defn -main []
  (let [csv-file "src/conmerge/test.csv"
        contacts (parser/process-csv csv-file)]
    (println "Number of contacts:" (count contacts))
    (doseq [contact contacts]
      (println "Contact:")
      (doseq [[key value] contact]
        (println (str key value))))))
