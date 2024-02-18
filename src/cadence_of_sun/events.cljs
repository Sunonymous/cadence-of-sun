(ns cadence-of-sun.events
  (:require
   [re-frame.core :as re-frame]
   [cadence-of-sun.db :as db]
   ))

(re-frame/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))
