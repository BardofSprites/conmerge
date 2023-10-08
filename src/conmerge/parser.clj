(ns conmerge.parser
  (:require [clojure.data.csv :as csv]
            [clojure.java.io :as io]))

(defrecord contact [first-name last-name phone-number email address])

(defn parse-csv [file-path]
  (try
    (println (str "Parsing CSV file: " file-path))
    (let [csv-data (->> file-path
                        (io/reader)
                        (csv/read-csv))]
      (println "Parsed CSV data:")
      (doseq [row csv-data]
        (println row))
      csv-data)
    (catch Exception err
      (println (str "Error: " (.getMessage err)))
      (throw err))))

(defn process-csv [file-path]
  (let [csv-data (parse-csv file-path)]
    (let [header (map keyword (first csv-data))
          data (rest csv-data)]
      (mapv (fn [row]
              (apply ->contact row))
            data))))
