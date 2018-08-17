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

(defn auth-map
  "Creates the authorisation elements required to connect with the Marvel API (returns a map)"
  []
    (let [current-timestamp (System/currentTimeMillis)
          md5-hash (pan/md5 (str current-timestamp @private-api-key @public-api-token))]
      {:ts current-timestamp :hash md5-hash :apikey @public-api-token}))

(defn format-api-url
  "Create a marvel URL for requesting data"
  [path params]
    (-> (url/url (str "http://" @marvel-host))
        (merge {:port 80
                :path (str "/v1/public/" path)
                :query (merge (auth-map) params)})
        str))

(defn format-resource-url
  "Create a url for retrieving resource URI data"
  [resource-path params]
    (-> (url/url resource-path)
        (merge {:port 80
                :query (merge (auth-map) params)})
        str))

(defn parse-request-body
  "Parses a request body and returns JSON as a map"
  [request]
  (let [body (:body request)]
    (when body (json/parse-string body true))))

;; Execute request
(defn make-request
  "Makes the HTTP request to the target URL"
  [method path params & body]
  (let [req {:url (format-api-url path params)
             :method method
             :content-type :json}
        req (if (#{:post :put :delete} method) (assoc req :body (json/generate-string (first body))) req)]
    req))

(defn api-action
  "Makes a call-out to the Marvel API"
  ([method path] (api-action method path nil nil))
  ([method path params] (api-action method path params nil))
  ([method path params body] (parse-request-body (http/request (make-request method path params body)))))

(defn resource-action
  "Makes a call out to the Marvel API for Resource URIs"
  [resource-path & options]
    (let [opts (or options {})
          req {:url (format-resource-url resource-path opts)
               :method :get
               :content-type :json}]
      (parse-request-body (http/request req))))
