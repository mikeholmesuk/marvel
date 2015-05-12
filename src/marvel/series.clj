(ns marvel.series
  (:use [marvel.core :only [api-action]]))

(defn get-series
  "Retrieves a list of series"
  [& [options]]
    (let [opts (or options {})]
      (api-action :get "series" opts)))

(defn get-serie-by-id
  "Retrieves an series record based on a provided ID"
  [id & [options]]
    (let [opts (or options {})]
      (api-action :get (format "series/%s" id) opts)))

(defn get-series-characters
  "Retrieves the characters associated with a provided series ID"
  [id & [options]]
    (let [opts (or options {})]
      (api-action :get (format "series/%s/characters" id) opts)))

(defn get-series-comics
  "Retrieves the comics associated with a provided series ID"
  [id & [options]]
    (let [opts (or options {})]
      (api-action :get (format "series/%s/comics" id) opts)))

(defn get-series-creators
  "Retrieves the creators associated with a provided series ID"
  [id & [options]]
    (let [opts (or options {})]
      (api-action :get (format "series/%s/creators" id) opts)))

(defn get-series-events
  "Retrieves the events associated with a provided series ID"
  [id & [options]]
    (let [opts (or options {})]
      (api-action :get (format "series/%s/events" id) opts)))

(defn get-series-comics
  "Retrieves the comics associated with a provided series ID"
  [id & [options]]
    (let [opts (or options {})]
      (api-action :get (format "series/%s/comics" id) opts)))

(use 'marvel.core)




(get-series {:limit 1})


