(ns bhatkhande-editor.subs
  (:require
   [sargam.languages :refer [lang-labels]]
   [re-frame.core :as re-frame :refer [reg-sub]]))

(reg-sub
 ::lang-data
 (fn [db]
   (lang-labels (:language db))))

(reg-sub
 ::lang
 (fn [db]
   (:language db)))

(reg-sub
 ::active-panel
 (fn [db _]
   (:active-panel db)))

(reg-sub
 ::edit-props 
 (fn [db _]     
   (-> db :edit-props)))

(reg-sub
 ::raga
 :<- [::edit-props]
 (fn [edit-props _]     
   (-> edit-props :raga)))

(reg-sub
 ::x-switch
 :<- [::edit-props]
 (fn [edit-props _]     
   (-> edit-props :x-switch)))

(reg-sub
 ::error-message
 :<- [::edit-props]
 (fn [edit-props _]     
   (-> edit-props :error-message)))

(reg-sub
 ::swaramap
 (fn [db _]
   (get-in lang-labels [(:language db) :swara-labels])))

(reg-sub
 ::composition
 (fn [db _]
   (:composition db)))
