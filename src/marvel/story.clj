(ns marvel.series
  (:use [marvel.core :only [api-action]]))

;;GET/v1/public/stories Fetches lists of stories.
;;GET /v1/public/stories/{storyId} Fetches a single comic story by id.
;;GET /v1/public/stories/{storyId}/characters Fetches lists of characters filtered by a story id.
;;GET /v1/public/stories/{storyId}/comics Fetches lists of comics filtered by a story id.
;;GET /v1/public/stories/{storyId}/creators Fetches lists of creators filtered by a story id.
;;GET /v1/public/stories/{storyId}/events Fetches lists of events filtered by a story id.
;;GET /v1/public/stories/{storyId}/series
