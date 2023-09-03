(ns conmerge.core)

(defn print-input [file-path]
  (with-open [reader (clojure.java.io/reader file-path)]
    (doseq [line (line-seq reader)]
      (println line))))

(defn main []
  (let [file-path "src/conmerge/test.txt"]
    (print-input file-path)))

(main)
