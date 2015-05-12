(ns marvel.event
  (:use [marvel.core :only [api-action]]))

(defn get-events
  "Retrieves a list of events"
  [& options]
    (let [opts (or options {})]
      (api-action :get "events" opts)))

(defn get-event-by-id
  "Retrieves an event record based on a provided ID"
  [id & options]
    (let [opts (or options {})]
      (api-action :get (format "event/%s" id) opts)))

(defn get-event-characters
  "Retrieves the characters associated with a provided event ID"
  [id & options]
    (let [opts (or options {})]
      (api-action :get (format "event/%s/characters" id) opts)))

(defn get-event-comics
  "Retrieves the comics associated with a provided event ID"
  [id & options]
    (let [opts (or options {})]
      (api-action :get (format "event/%s/comics" id) opts)))

(defn get-event-characters
  "Retrieves the creators associated for a provided event ID"
  [id & options]
    (let [opts (or options {})]
      (api-action :get (format "event/%s/creators" id) opts)))

(defn get-event-series
  "Retrieves the series associated with a provided event ID"
  [id & options]
    (let [opts (or options {})]
      (api-action :get (format "event/%s/series" id) opts)))

(defn get-event-stories
  "Retrieves the stories associated with a provided event ID"
  [id & options]
    (let [opts (or options {})]
      (api-action :get (format "event/%s/characters" id) opts)))
