(ns marvel.series
  (:use [marvel.core :only [api-action]]))

;;GET/v1/public/series Fetches lists of series.
;;GET /v1/public/series/{seriesId} Fetches a single comic series by id.
;;GET /v1/public/series/{seriesId}/characters Fetches lists of characters filtered by a series id.
;;GET /v1/public/series/{seriesId}/comics Fetches lists of comics filtered by a series id.
;;GET /v1/public/series/{seriesId}/creators Fetches lists of creators filtered by a series id.
;;GET /v1/public/series/{seriesId}/events Fetches lists of events filtered by a series id.
;;GET /v1/public/series/{seriesId}/stories Fetches lists of stories filtered by a series id.
