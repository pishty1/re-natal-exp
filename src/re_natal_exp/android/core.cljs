(ns re-natal-exp.android.core
  (:require [reagent.core :as r :refer [atom]]
            [re-frame.core :refer [subscribe dispatch dispatch-sync]]
            [re-natal-exp.handlers]
            [re-natal-exp.subs]))

(set! js/window.React (js/require "react"))
(def ReactNative (js/require "react-native"))
(def maps (js/require "react-native-maps"))
(def map-view (r/adapt-react-class maps))
(def app-registry (.-AppRegistry ReactNative))
(def text (r/adapt-react-class (.-Text ReactNative)))
(def view (r/adapt-react-class (.-View ReactNative)))
(def image (r/adapt-react-class (.-Image ReactNative)))
(def touchable-highlight (r/adapt-react-class (.-TouchableHighlight ReactNative)))

(def logo-img (js/require "./images/cljs.png"))

(defn alert [title]
  (.alert (.-Alert ReactNative) title))

(defn app-root []
  (let [greeting (subscribe [:get-greeting])]
    (fn []
      [map-view
       {:initial-region
        {:latitude 37.78825
         :longitude -122.4324
         :latitudeDelta 0.0922
         :longitudeDelta 0.0421}
        :style 
        {:height 400
         :width 400
         :justifyContent "flex-end"
         :alignItems "center"}}]     
      )))

(defn init []
  (dispatch-sync [:initialize-db])
  (.registerComponent app-registry "ReNatalExp" #(r/reactify-component app-root)))
