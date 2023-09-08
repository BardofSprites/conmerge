(ns conmerge.core)

(defn parse-contact-info [file-path]
  (try
    (with-open [reader (clojure.java.io/reader file-path)]
      (->> (line-seq reader)
           (reduce (fn [acc line]
                     (if (empty? line)
                       (conj acc {})
                       (let [[_ key value] (re-matches #"\s*([^:]+):\s*(.*)" line)]
                         (conj (update-in acc [key] (constantly value)) key value))))
                 [])
           (drop-last 1)))
    (catch Exception err
      (println (str "Error: " (.getMessage err)))
      nil)))

(defn -main []
  (println "Define your contact file")
  (let [file-path (read-line)
        contact-info (parse-contact-info file-path)]
    (println "Contacts: ")
    (println contact-info)))
