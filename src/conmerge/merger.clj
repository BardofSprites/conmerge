(ns conmerge.merger
  (:require [conmerge.parser :as parser]))

;; (defn merge-contact [contact1 contact2]
;;   (merge-with
;;     (fn [v1 v2]
;;       (if (= v1 v2)
;;         v1
;;         (println "Conflict detected. Choose a value:" v1 " or " v2)))
;;     contact1
;;     contact2))

;; (defn merge-contacts-files [contact-file-1 contact-file-2]
;;   (let [contact1 (parser/process-csv contact-file-1)
;;         contact2 (parser/process-csv contact-file-2)]
;;     (mapv (fn [c1]
;;             (let [matching-c2 (first (filter #(= (:email %) (:email c1)) contact2))]
;;               (if matching-c2
;;                 (merge-contact c1 matching-c2)
;;                 c1)))
;;           contact1)))

