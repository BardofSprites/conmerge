(ns conmerge.core
  (:require [conmerge.merging-logic :as merging]))

(defn -main [& args]
  (let [test-input "src/conmerge/test.csv"]
    (let [contacts (merging/parse-csv test-input)]
      (merging/print-contacts (rest contacts)))))
