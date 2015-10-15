(ns cliprange.core
  (:require
   [clojure.tools.cli :refer [parse-opts]]
   [clojure.set :refer [difference]]
   [cliptools.generate :refer [ip-list]]
   [cliptools.validate :refer [ip-range-str?]]
   [csprint.print :refer [prn-seql-fl]]
   )
  (:gen-class))


(def cli-options
  [
   ["-r" "--range RANGE-STR" "Specify an IP-range like this \"x-y\" where x<y."
    :validate[ip-range-str? "Not a valid IP-range."]
    ]
   [
    "-h" "--help" "Show help"
    ]
   ])

; split this out?
(defn req-opts [result & required]
  (let [{:keys [errors options summary]} result

        help? (:help options)
        errors? (not (empty? errors))

        differences (map name (difference (set required) (set (keys options))))
        reformat #(str
                   (re-find (re-pattern (str #"-.,\s+" "--" % #_#".+")) summary)
                   ": required option missing")
        missing (vec (map #(reformat %) differences))

        missing-req-opts? (not (empty? differences))
        ]
    (cond
     help? (vector summary)
     errors? errors
     missing-req-opts? missing
     :else nil)))

(defn -main
  "Entry point"
  [& args]
  (let [result (parse-opts args cli-options)
        errors? (req-opts result :range)
        options (:options result)
        rng-str (:range options)
        ]
    (if errors?
      (prn-seql-fl errors?)
      (prn-seql-fl (ip-list rng-str)))))
