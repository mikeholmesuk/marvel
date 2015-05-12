(ns marvel.comic
  (:use [marvel.core :only [api-action]]))

(defn get-comics
  "Retrieves a list of comics"
  [& options]
    (let [opts (or options {})]
      (api-action :get "comics" opts)))

(defn get-comic-by-id
  "Retrieves a comic record based on a provided ID"
  [id & options]
    (let [opts (or options {})]
      (api-action :get (format "comics/%s" id) opts)))

(defn get-comic-characters
  "Retrieves the characters for a provided comic ID"
  [id & options]
    (let [opts (or options {})]
      (api-action :get (format "comics/%s/characters" id) opts)))

(defn get-comic-creators
  "Retrieves the creators for a provided comic ID"
  [id & options]
    (let [opts (or options {})]
      (api-action :get (format "comics/%s/creators" id) opts)))

(defn get-comic-events
  "Retrieves the events for a provided comic ID"
  [id & options]
    (let [opts (or options {})]
      (api-action :get (format "comics/%s/events" id) opts)))

(defn get-comic-stories
  "Retrieves the stories for a provided comic ID"
  [id & options]
    (let [opts (or options {})]
      (api-action :get (format "comics/%s/stories" id) opts)))
