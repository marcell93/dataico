(ns problem1.test
  (:require [clojure.test :refer [deftest is run-tests]]
            problem1))


(def invoice (clojure.edn/read-string (slurp "invoice.edn")))

(def filtered-invoices (problem1/get-filtered-invoices (invoice :invoice/items)))

(def filtered-ids (map #(:invoice-item/id %) filtered-invoices))

(deftest problem1-test
  (is (= filtered-ids ["ii3" "ii4"])))

(run-tests 'problem1.test)