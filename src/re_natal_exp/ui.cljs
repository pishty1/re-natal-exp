(ns re-natal-exp.ui
  (:require [reagent.core :as r]))


(def ReactNative (js/require "react-native"))
(def maps (js/require "react-native-maps"))
(def map-view (r/adapt-react-class maps))
(def app-registry (.-AppRegistry ReactNative))
(def text (r/adapt-react-class (.-Text ReactNative)))
(def view (r/adapt-react-class (.-View ReactNative)))
(def image (r/adapt-react-class (.-Image ReactNative)))
(def touchable-highlight (r/adapt-react-class (.-TouchableHighlight ReactNative)))
(def logo-img (js/require "./images/cljs.png"))


(def map-style
  {:height 400
   :width 400
   :justifyContent "flex-end"
   :alignItems "center"})

(def map-co
  {:latitude 51.78825
   :longitude 1.9324
   :latitudeDelta 6.0922
   :longitudeDelta 6.0421})
