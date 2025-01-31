(ns predicates)

(defn sum-f [f g x]
      (+ (f x) (g x)))

(defn less-than [n]
      (fn [k] (< k n)))

(defn equal-to [n]
      (fn [k] (== k n)))

(defn set->predicate [a-set]
      (fn [elem] (contains? a-set elem)))

(defn pred-and [pred1 pred2]
      (fn [x] (and (pred1 x) (pred2 x))))


(defn pred-or [pred1 pred2]
      (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
      (every? whitespace? string))

(defn has-award? [book award]
      (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
      (every? (fn [award] (has-award? book award)) awards))

(defn my-some? [pred a-seq]
      ((complement every?) (complement pred) a-seq))

(defn my-some [pred a-seq]
      (first (map pred (filter pred a-seq))))


(defn my-every? [pred a-seq]
      ;(= a-seq (filter pred a-seq)))
      (empty? (filter (complement pred) a-seq)))

(defn prime? [n]
      (not-any? (fn [m] (== 0 (mod n m))) (range 2 n)))