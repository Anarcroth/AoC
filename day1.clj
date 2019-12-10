(ns day1-aoc.core
  (:gen-class))

(defn open-file
  [path]
  (with-open [rdr (clojure.java.io/reader path)]
    (map #(Integer/parseInt %) (reduce conj [] (line-seq rdr)))))

(defn calculate-mass
  [module]
  (Math/abs  (- 2 (int (Math/floor (/ module 3))))))

(reduce + (doall (map calculate-mass (open-file "day1input.txt"))))
