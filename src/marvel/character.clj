(ns marvel.character
  (:use [marvel.core :only [api-action]]))


;(api-action :get "characters")

(defn get-characters
  "Retrieves a list of characters"
  [options]
    (api-action :get "characters" options))

(defn get-character
  "Retrieves a character record based on a provided ID"
  [id options]
    (api-action :get (format "characters/%s" id) options))

;; comics
(defn get-character-comics
  "Retrieves the comics for a provided character ID"
  [id options]
    (api-action :get (format "characters/%s/comics" id) options))

(defn get-character-events
  "Retrieves the events for a provided character ID"
  [id options]
    (api-action :get (format "characters/%s/events" id) options))


;; series
(defn get-character-series
  "Retrieves the series for a provided character ID"
  [id options]
    (api-action :get (format "characters/%s/series" id) options))

;; stories
(defn get-character-stories
  "Retrieves the stories for a provided character ID"
  [id options]
    (api-action :get (format "characters/%s/stories" id) options))
