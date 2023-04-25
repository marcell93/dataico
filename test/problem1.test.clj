(ns problem1.test
  (:require [clojure.test :refer [deftest is run-tests]]
            problem1))


(def invoice (clojure.edn/read-string (slurp "invoice.edn")))

(def filtered-invoices (problem1/get-filtered-invoices (invoice :invoice/items)))

(def filtered-id ((first filtered-invoices) :invoice-item/id))

(def first-invoice-id ((first (invoice :invoice/items)) :invoice-item/id))

(deftest problem1-test
  (is (= first-invoice-id filtered-id)))

(run-tests 'problem1.test)