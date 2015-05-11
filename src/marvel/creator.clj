(ns marvel.creator
  (:use [marvel.core :only [api-action]]))

(defn get-creators
  "Retrieves a list of creators"
  [options]
    (api-action :get "creators" options))

(defn get-creators
  "Retrieves a creator record based on a provided ID"
  [id options]
    (api-action :get (format "creators/%s" id) options))

(defn get-creator-comics
  "Retrieves the comics for a provided character ID"
  [id options]
    (api-action :get (format "creators/%s/comics" id) options))

(defn get-creator-events
  "Retrieves the events for a provided creator ID"
  [id options]
    (api-action :get (format "creators/%s/events" id) options))

(defn get-creator-series
  "Retrieves the series for a provided creator ID"
  [id options]
    (api-action :get (format "creators/%s/series" id) options))

(defn get-creator-stories
  "Retrieves the stories for a provided character ID"
  [id options]
    (api-action :get (format "creators/%s/stories" id) options))
