(ns marvel.character
  (:use [marvel.core :only [api-action]]))

(defn get-characters
  "Retrieves a list of characters"
  [& options]
    (let [opts (or options {})]
      (api-action :get "characters" opts)))

(defn get-character-by-id
  "Retrieves a character record based on a provided ID"
  [id & options]
    (let [opts (or options {})]
      (api-action :get (format "characters/%s" id) opts)))

(defn get-character-comics
  "Retrieves the comics for a provided character ID"
  [id & options]
    (let [opts (or options {})]
      (api-action :get (format "characters/%s/comics" id) opts)))

(defn get-character-events
  "Retrieves the events for a provided character ID"
  [id & options]
    (let [opts (or options {})]
      (api-action :get (format "characters/%s/events" id) opts)))

(defn get-character-series
  "Retrieves the series for a provided character ID"
  [id & options]
    (let [opts (or options {})]
      (api-action :get (format "characters/%s/series" id) opts)))

;; stories
(defn get-character-stories
  "Retrieves the stories for a provided character ID"
  [id & options]
    (let [opts (or options {})]
      (api-action :get (format "characters/%s/stories" id) options)))
