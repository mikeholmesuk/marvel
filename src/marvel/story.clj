(ns marvel.story
  (:use [marvel.core :only [api-action]]))

(defn get-stories
  "Retrieves a list of stories"
  [& [options]]
    (let [opts (or options {})]
      (api-action :get "stories" opts)))

(defn get-story-by-id
  "Retrieves a story record based on a provided ID"
  [id & [options]]
    (let [opts (or options {})]
      (api-action :get (format "stories/%s" id) opts)))

(defn get-story-characters
  "Retrieves the characters associated with a provided story ID"
  [id & [options]]
    (let [opts (or options {})]
      (api-action :get (format "stories/%s/characters" id) opts)))

(defn get-story-comics
  "Retrieves the comics associated with a provided story ID"
  [id & [options]]
    (let [opts (or options {})]
      (api-action :get (format "stories/%s/comics" id) opts)))

(defn get-story-creators
  "Retrieves the creators associated with a provided story ID"
  [id & [options]]
    (let [opts (or options {})]
      (api-action :get (format "stories/%s/creators" id) opts)))

(defn get-story-events
  "Retrieves the events associated with a provided story ID"
  [id & [options]]
    (let [opts (or options {})]
      (api-action :get (format "stories/%s/events" id) opts)))

(defn get-story-comics
  "Retrieves the comics associated with a provided story ID"
  [id & [options]]
    (let [opts (or options {})]
      (api-action :get (format "stories/%s/comics" id) opts)))
