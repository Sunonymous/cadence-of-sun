(ns cadence-of-sun.core
  (:require
   [reagent.dom :as rdom]
   [re-frame.core :as re-frame]
   [cadence-of-sun.events :as events]
   [cadence-of-sun.views :as views]
   [cadence-of-sun.config :as config]
   ))


(defn dev-setup []
  (when config/debug?
    (println "dev mode")))

(defn ^:dev/after-load mount-root []
  (re-frame/clear-subscription-cache!)
  (let [root-el (.getElementById js/document "app")]
    (rdom/unmount-component-at-node root-el)
    (rdom/render [views/main-panel] root-el)))

(defn init []
  (re-frame/dispatch-sync [::events/initialize-db])
  (dev-setup)
  (mount-root))
