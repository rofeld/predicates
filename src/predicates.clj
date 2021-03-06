(ns predicates)
(defn sum-f [f g x]

  (+ (f x)(g x))
  )


(defn less-than [n]
  (fn [k] (< k n))
  )

(defn equal-to [n]
(fn [k] (== k n))

  )

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x))

  )

(defn pred-and [pred1 pred2]

  (fn [x]
     (and (pred1 x) (pred2 x))
  )
)


(defn pred-or [pred1 pred2]
  (fn [x]
     (or (pred1 x) (pred2 x))
  )
)

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
;(== (count (clojure.string/trim string)) 0)
  (every? whitespace? string)
  )

(defn has-award? [book award]
(contains? (book :awards) award)
  )

(defn HAS-ALL-THE-AWARDS? [book awards]
  ;(every? (:awards book) awards)
(if (empty? awards)
  (empty? awards)

(let [y (map (fn [x] (has-award? book x) ) awards)]
  (apply = y)
  )))

(defn my-some [pred a-seq]
(if (nil? (some pred a-seq))
(boolean false)
(some pred a-seq)
  )
)

(defn my-every? [pred a-seq]
(if (empty? a-seq)
  (empty? a-seq)
  (apply = (map pred a-seq))
  ))

(defn prime? [n]
(let [optimus (fn [x] (= (mod n x) 0))]
(not (some optimus (range 2 n)))))
;^^
