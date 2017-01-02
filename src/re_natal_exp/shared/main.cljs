(ns re-natal-exp.shared.main
  (:require [reagent.core :as r]
            [re-natal-exp.ui :as ui]))


(defn main-comp []
  (fn []
    [ui/map-view {:initial-region ui/map-co
                  :style ui/map-style}]))
