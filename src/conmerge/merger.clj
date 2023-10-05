(ns conmerge.merger
  (:require [conmerge.parser :as parser]))
  
(defn merge-contacts-files [contact-file-1 contact-file-2]
  (let [contact1 (parser/process-csv contact-file-1)
        contact2 (parser/process-csv contact-file-2)]
    
    (defn merge-contact [contact1 contact2]
      (merge-with
        (fn [v1 v2]
          (if (= v1 v2)
            v1
            (println "Conflict detected. Choose a value:" v1 " or " v2)))
        contact1
        contact2))
    ))
