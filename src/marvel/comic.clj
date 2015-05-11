(ns marvel.comic
  (:use [marvel.core :only [api-action]]))

(defn get-comics
  "Retrieves a list of comics"
  [options]
    (api-action :get "comics" options))

(defn get-comic
  "Retrieves a comic record based on a provided ID"
  [id options]
    (api-action :get (format "comics/%s" id) options))

(defn get-comic-characters
  "Retrieves the characters for a provided comic ID"
  [id options]
    (api-action :get (format "comics/%s/characters" id) options))

(defn get-comic-creators
  "Retrieves the creators for a provided comic ID"
  [id options]
    (api-action :get (format "comics/%s/creators" id) options))

(defn get-comic-events
  "Retrieves the events for a provided comic ID"
  [id options]
    (api-action :get (format "comics/%s/events" id) options))

(defn get-comic-stories
  "Retrieves the stories for a provided comic ID"
  [id options]
    (api-action :get (format "comics/%s/stories" id) options))
