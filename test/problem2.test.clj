(ns problem2.test
  (:require [clojure.test :refer [deftest is run-tests]]
            problem2)
  (:require [clojure.data.json :as json])
  (:require [clojure.spec.alpha :as s])
            )


(def invoice (json/read-str (slurp "invoice.json")))

(deftest problem2-check-invalid-invoice
  (is (false? (s/valid? :invoice-spec/invoice invoice))))

(def new-invoice (problem2/get-maped-invoice "invoice.json"))

(deftest problem2-test
  (is (true? (s/valid? :invoice-spec/invoice new-invoice))))

(run-tests 'problem2.test)