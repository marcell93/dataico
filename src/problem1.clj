(ns problem1)

(defmacro xor
  ([] nil)
  ([a] a)
  ([a b]
   `(let [a# ~a
          b# ~b]
      (if a#
        (if b# false true)
        (if b# true false)))))

(defn get-filtered-invoices [invoices]
  (defn invoice-filter [i] (xor (some (fn [t] (and (= (:tax/category t) :iva) (= (:tax/rate t) 19))) (:taxable/taxes i))
                                (some (fn [r] (and (= (:retention/category r) :ret_fuente) (= (:retention/rate r) 1))) (:retentionable/retentions i))))
  (->> invoices (filter invoice-filter)))