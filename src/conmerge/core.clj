(ns conmerge.core)

(defn print-input [file-path]
  (with-open [reader (clojure.java.io/reader file-path)]
    (doseq [line (line-seq reader)]
      (println line))))

(defn parse-contact-info [file-path]
  (with-open [reader (clojure.java.io/reader file-path)]
    (let [lines (line-seq reader)
          result (reduce (fn [acc line]
                           (if (empty? line)
                             (if (empty? acc)
                               acc
                               (conj acc {}))
                             (let [last-map (peek acc)
                                   [key value] (re-matches #"\s*([^:]+):\s*(.*)" line)]
                               (conj (pop acc) (assoc last-map (keyword key) value)))))
                         [{}]
                         lines)]
      result)))

(defn -main []
  (println "Define your contact file")
  (let [file-path (read-line)
        contact-info (parse-contact-info file-path)]
    (println "Contacts: ")
    (println contact-info)))
