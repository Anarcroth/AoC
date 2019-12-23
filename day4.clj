(ns aoc-day4
  (:gen-class))

(defn are-same-adjecent
  [passwd]
  (re-find #"(00|11|22|33|44|55|66|77|88|99)" passwd))

(defn is-increasing
  [passwd]
  (for [[a b] (partition 2 passwd)]
    (if (< (Integer/parseInt a) (Integer/parseInt b))
      false
      true)))

(defn is-maybe-passwd
  [passwd]
  (if
      (and (are-same-adjecent (str passwd))
           (is-increasing (clojure.string/split (str passwd) #"")))
    true
    false))

(defn passwd-range
  [lower upper]
  (count (filter true? (map is-maybe-passwd (take (- upper lower) (iterate inc lower))))))

(passwd-range 359282 820401)
