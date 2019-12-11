(ns day1-aoc.core
  (:gen-class))

(defn open-file
  [path]
  (with-open [rdr (clojure.java.io/reader path)]
    (map #(Integer/parseInt %) (reduce conj [] (line-seq rdr)))))

(defn calc-mass
  [module]
  (int (Math/floor (/ module 3))))

;; Part 1
(defn calculate-mass-part1
  [module]
  (Math/abs  (- 2 (calc-mass module))))

(reduce + (doall (map calculate-mass-part1 (open-file "day1input.txt"))))

;; Part 2
(defn calculate-mass-part2
  [module]
  (def fuel
    (if (<= (calc-mass module) 1)
      0
      (Math/abs (- 2 (calc-mass module)))))
  (if (> fuel 0)
    (+ fuel (calculate-mass-part2 fuel))
    fuel))

(reduce + (doall (map calculate-mass-part2 (open-file "day1input.txt"))))
