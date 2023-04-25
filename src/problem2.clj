(ns problem2
  (:require [invoice-spec])
  (:require [clojure.spec.alpha :as s])
  (:require [clojure.spec.gen.alpha :as gen])
  (:require [clojure.data.json :as json]))

(defn get-maped-invoice [json-file]
  (def invoice-from-file (json/read-str (slurp json-file)))
  (def generated-invoice (gen/generate (s/gen :invoice-spec/invoice)))
  (merge generated-invoice invoice-from-file))
