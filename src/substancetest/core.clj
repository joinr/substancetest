(ns substancetest.core
  (:require [seesaw.core :as s]
            [seesaw.icon :as i]
            #_[sanersubstance.core :as substance])
  (:import #_[org.pushingpixels.substance.api SubstanceLookAndFeel]
           [org.pushingpixels.substance.api.skin #_GraphiteSkin SubstanceGraphiteLookAndFeel]
           [javax.swing UIManager]))

(defn set-theme-by-string!  []
  (s/invoke-now ;;substance should complain since we're not on EDT
   (s/native!) ;;not sure if necessary anymore, leftover just in case.
   ;;still work with old substance?
   (UIManager/setLookAndFeel "org.pushingpixels.substance.api.skin.SubstanceGraphiteLookAndFeel")
   ))

(defn set-theme-by-skin! []
  (s/invoke-now ;;substance should complain since we're not on EDT
  (s/native!) ;;not sure if necessary anymore, leftover just in case.
   ;;still work with old substance?
  (UIManager/setLookAndFeel (SubstanceGraphiteLookAndFeel.))))

(defn show-frame []
  (s/invoke-now ;;substance will complain like crazy if we're not on the EDT.
   (-> (s/frame :title "Hello",
                :content "Hello, Seesaw",
                :on-close :dispose)
       s/pack!
       s/show!)))


;;old
(comment
  (defn set-theme8!  []
    (s/invoke-now
     (s/native!)
     (SubstanceLookAndFeel/setSkin (GraphiteSkin.))
     (substance/enforce-event-dispatch)))
  )
