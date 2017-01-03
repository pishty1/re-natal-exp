(ns re-natal-exp.android.core
  (:require [reagent.core :as r :refer [atom]]
            ;[re-frame.core :refer [subscribe dispatch dispatch-sync]]
            ;[re-natal-exp.handlers]
            ;[re-natal-exp.subs]
            [re-natal-exp.shared.main :as main]))

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
  (let [];;greeting (subscribe [:get-greeting])
    (main/main-comp)))

(defn init []
  ;(dispatch-sync [:initialize-db])
  (.registerComponent app-registry "ReNatalExp" #(r/reactify-component app-root)))
