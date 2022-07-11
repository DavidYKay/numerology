(ns numerology.epicycle
  (:import [java.time LocalDate]))

(def year-tags {1 :new-beginning
                2 :love-and-friends
                3 :creative-intelligence
                4 :challenging-year
                5 :change-transformation
                6 :family
                7 :inner-student
                8 :reap-rewards
                9 :closure})

(defn current-year []
  (-> (LocalDate/now)
      (.getYear)))

(defn sum-digits [n]
  (let [sum (->> n
                 (str)
                 (map str)
                 (map read-string)
                 (reduce +))]
    (if (> sum 9)
      (sum-digits sum)
      sum)))

(defn show-epicycle [bm bd by]
  (for [year (range by (+ (current-year) 5))]
    (let [sum (sum-digits (+ bm bd year))]
      [year sum (get year-tags sum)])))

(current-year)
(sum-digits 1061987)

(show-epicycle 10 6 1987)


;; 1 - new beginnings. "what do I want to accomplish?" embrace change. New relationships.
;; 2 - Love, deepening of relationships. New friends & connections. Like-minded souls. Form the basis of support. Accept help & guidance. Asked to be peacemaker in dispute. Be patient. Look for middle ground.
;; 3 - Creative intelligence at peak. New ideas and insights. Outlets for self-expression. Communicate feelings in open and authentic way. Let your feelings be known. Make time for your gifts.
;; 4 - More challenging year. Working harder than usual. Not getting recognition/positive results you deserve. This is a time for patience. Opportunity to build a foundation of stability / security. Pay attention to the details. Too many small mistakes can derail you. Best approach: move forward with consistency, organization.
;; 5 - Change, transformation. Conflicting events and emotions. Opportunity to inject spontaneity. Opportunites for growth/expansion.
;; 6 - Reconnect with family. Deepen those bonds. Great year for marriage. Tend to home. Confront unsaid things. Do undone things.
;; 7 - Good time to explore personal dev and education. Strong intuition. Good time to pass on info. Great time to reflect. Connect with inner student.
;; 8 - Hard work starts to pay off. Attract opportunities for success, other material rewards. Most people won't recognize them. Opportunity often disguised as adversity. Use your intuition to weigh your options. Act strategically. Career advancement.
;; 9 - Completion and closure. Feeling of coming full-circle. Leave behind all the things you don't want to take with you. Anything started this year unlikely to carry forward. Use this year to take care of loose ends and prepare for next cycle. Leave behind what does not serve you. Take stock of your progress.
