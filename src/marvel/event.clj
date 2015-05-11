(ns marvel.event
  (:use [marvel.core :only [api-action]]))

;;GET /v1/public/events Fetches lists of events.
;;GET /v1/public/events/{eventId} Fetches a single event by id.
;;GET /v1/public/events/{eventId}/characters Fetches lists of characters filtered by an event id.
;;GET /v1/public/events/{eventId}/comics Fetches lists of comics filtered by an event id.
;;GET /v1/public/events/{eventId}/creators Fetches lists of creators filtered by an event id.
;;GET /v1/public/events/{eventId}/series Fetches lists of series filtered by an event id.
;;GET /v1/public/events/{eventId}/stories Fetches lists of stories filtered by an event id.
