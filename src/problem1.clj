(ns problem1)

(defn get-filtered-invoices [invoices]
  (->> invoices
       (filter
        (fn [i]
          (and
           (and
            (and
             (i :taxable/taxes)
             (->> some
                  (i :taxable/taxes)
                  (fn [t]
                    (and (= (t :tax/category) :iva) (= (t :tax/rate) 19)))))
            (i :retentionable/retentions))
           (->> some
                (i :retentionable/retentions)
                (fn [r]
                  (and (= (r :retention/category) :ret_fuente) (= (r :retention/rate) 1)))))))))
