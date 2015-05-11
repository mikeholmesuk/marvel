(ns marvel.core
  (:require [clj-http.client :as http]
            [cheshire.core :as json]
            [cemerick.url :as url]
            [pandect.core :as pan])
    (:import java.net.URLEncoder))

; Set up auth variables here
(def marvel-host (atom "gateway.marvel.com/"))
(def public-api-token (atom nil))
(def private-api-key (atom nil))

(defn init
  "Takes an auth token or an auth token and an end-point URL (uses the default if not provided) and sets them for the application"
  ([public-token private-key]
    (reset! public-api-token public-token)
    (reset! private-api-key private-key))
  ([public-token private-key host]
    (reset! public-api-token public-token)
    (reset! private-api-key private-key)
    (reset! marvel-host host)))

(defn format-url
  "Create a marvel URL for requesting data"
  [path params]
    (let [current-timestamp (System/currentTimeMillis)
          md5-hash (pan/md5 (str current-timestamp @private-api-key @public-api-token))]
      (-> (url/url (str "http://" @marvel-host))
          (merge {:port 80
                  :path (str "/v1/public/" path)
                  :query (merge {:ts current-timestamp
                                 :apikey @public-api-token
                                 :hash md5-hash} params)})
          str)))

(defn parse-request-body
  "Parses a request body and returns JSON as a map"
  [request]
  (let [body (:body request)]
    (when body (json/parse-string body true))))

;; Execute request
(defn make-request
  "Makes the HTTP request to the target URL"
  [method path params & body]
  (let [req {:url (format-url path params)
             :method method
             :content-type :json}
        req (if (#{:post :put :delete} method) (assoc req :body (json/generate-string (first body))) req)]
    req))

(defn api-action
  "Makes a call-out to the Marvel API"
  ([method path] (api-action method path nil nil))
  ([method path params] (api-action method path params nil))
  ([method path params body] (parse-request-body (http/request (make-request method path params body)))))

;(defn resource-action
;  "Makes a call for a provided resource URL"
;  ([method resource-url params] ()))
