
(def invoice (clojure.edn/read-string (slurp "invoice.edn")))

(defn get-invoices [invoices] 
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
              (and (= (r :retention/category) :ret_fuente) (= (r :retention/rate) 1)))))))
       ))

(println (get-invoices (invoice :invoice/items)))
