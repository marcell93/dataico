(ns invoice-item.test
  (:require [clojure.test :refer [deftest is run-tests]]
            invoice-item)
  )

(defn rand-int-min-max
  "max here is inclusive"
  [min max]
  (+ min (rand-int max)))

(def invoice-item1 {:invoice-item/precise-quantity 0, :invoice-item/precise-price (rand-int-min-max 1 20), :invoice-item/discount-rate (rand-int-min-max 1 20)})
(def invoice-item2 {:invoice-item/precise-quantity (rand-int-min-max 1 20), :invoice-item/precise-price 0, :invoice-item/discount-rate (rand-int-min-max 1 20)})
(def invoice-item3 {:invoice-item/precise-quantity 2, :invoice-item/precise-price 2, :invoice-item/discount-rate 0})
(def invoice-item4 {:invoice-item/precise-quantity 10, :invoice-item/precise-price 2, :invoice-item/discount-rate 10})
(def invoice-item5 {:invoice-item/precise-quantity nil, :invoice-item/precise-price (rand-int-min-max 1 20), :invoice-item/discount-rate (rand-int-min-max 1 20)})

(deftest subtotal-with-quantity-zero
  (is (= 0.0 (invoice-item/subtotal invoice-item1))))

(deftest subtotal-with-price-zero
  (is (= 0.0 (invoice-item/subtotal invoice-item2))))

(deftest subtotal-with-rate-zero
  (is (= 4.0 (invoice-item/subtotal invoice-item3))))

(deftest subtotal-with-all-data
  (is (= 18.0 (invoice-item/subtotal invoice-item4))))

(deftest subtotal-with-some-nil-value
  (is (thrown? java.lang.NullPointerException (invoice-item/subtotal invoice-item5))))


(run-tests 'invoice-item.test)