(ns marvel.creator
  (:use [marvel.core :only [api-action]]))

(defn get-creators
  "Retrieves a list of creators"
  [& options]
    (let [opts (or options {})]
      (api-action :get "creators" opts))

(defn get-creator-by-id
  "Retrieves a creator record based on a provided ID"
  [id & options]
    (let [opts (or options {})]
      (api-action :get (format "creators/%s" id) opts)))

(defn get-creator-comics
  "Retrieves the comics for a provided character ID"
  [id & options]
    (let [opts (or options {})]
      (api-action :get (format "creators/%s/comics" id) opts)))

(defn get-creator-events
  "Retrieves the events for a provided creator ID"
  [id & options]
    (let [opts (or options {})]
      (api-action :get (format "creators/%s/events" id) opts)))

(defn get-creator-series
  "Retrieves the series for a provided creator ID"
  [id & options]
    (let [opts (or options {})]
      (api-action :get (format "creators/%s/series" id) opts)))

(defn get-creator-stories
  "Retrieves the stories for a provided character ID"
  [id & options]
    (let [opts (or options{})]
      (api-action :get (format "creators/%s/stories" id) opts)))
