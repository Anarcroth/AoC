(ns aoc-day4
  (:gen-class))

(defn are-same-adjecent
  [passwd]
  (re-find #"(00|11|22|33|44|55|66|77|88|99)" passwd))

(defn is-inc
  [passwd i]
  (if (>= (inc i) (count passwd))
    true
    (do
      (def a (nth passwd i))
      (def b (nth passwd (inc i)))
      (if (<= (Integer/parseInt a) (Integer/parseInt b))
        (is-inc passwd (inc i))
        false))))

(defn is-maybe-passwd
  [passwd]
  (if
      (and (are-same-adjecent (str passwd))
           (is-inc (clojure.string/split (str passwd) #"") 0))
    true
    false))

(defn passwd-range
  [lower upper]
  (count (filter true? (map is-maybe-passwd (take (- upper lower) (iterate inc lower))))))

(passwd-range 359282 820401)
