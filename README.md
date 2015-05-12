# marvel

A simple Clojure project wrapping the Marvel Developer API. The API is available [here](http://developer.marvel.com). You will need to have set up an account and have created a public and private API key to use this library.

## Usage

Usage of the library is intentionally simple. Before you can do so however you must initialise the environment with your authentication keys. The following will setup your authentication pieces for the API:

<pre><code>(use 'marvel.core)
(init "YOUR_PUBLIC_KEY_HERE" "YOUR_PRIVATE_KEY_HERE")</code></pre>

This will set up the environment for first use. After that each area of the API has an equivalent supporting namespace used to access the Marvel universe data. The following namespaces are available (in addition to `marvel.core` we've seen alaready):

* `marvel.characters`
* `marvel.comic`
* `marvel.creator`
* `marvel.event`
* `marvel.series`
* `marvel.story`

Each of these namespaces has a function to retrieve a list of the associated data-type using the `get-[type]s` format. So a list of characters can be retrieved easily:

<pre><code>(use 'marvel.character)
(get-characters) ;; Returns a list of characters (20 by default)</pre></code>

*Note - all calls return the full Marvel data load which may be more than you want. You can get the actual results by pulling from data.results on the returned dataset.*

This function is the same format for all namespaces so you can use `(get-comics)`, `(get-creators)`, `(get-stories)` etc. On top of this you can provide whatever options you want to the API using a map of options. For example, to increase the limit to 50 returned results and the offset to the 2nd page you could provide the following:

<pre><code>(use 'marvel.character)
(get-characters {:limit 50 :offset 1}) ;; Limit of 50 and offset to 2nd page (zero based)</pre></code>

The API allows for pulling back an individual character from this end-point so if you wanted to get back the results for Spider-Man then you can just do the following:

<pre><code>(use 'marvel.character)
(get-characters {:name "Spider-Man"})</pre></code>

Once you know a character/ comic/ story/ creator/ event id, you can retrieve that by just calling the explicit `get-[type]-by-id` function. For example, to get a specific comic run the following:

<pre><code>(use 'marvel.comic)
(get-comic-by-id 123456)</pre></code>

And then under each of these data-types there are a number of mechanisms to filter the data down. So to get the events that a character is involved in just run `(get-character-events 123456)` providing the character id. To get the creators of a given comic just use `(get-comic-creators 123456)` passing in the comic id. Of course, any data can be filtered by passing in a map containing any of the values that the Marvel API accepts. So to return a list of characters within a story, but only those within a defined list of comics you can run `(get-story-characters {:comics [123, 456, 789]})`.

Finally, when you get the data back you will notice that there are a number of 'resourceURI' values which again point back to the Marvel API. These resources define the full URIs of the data being requested and as such can be pulled directly through the `resource-action` function in the core namespace. An example of this is as follows:

<pre><code>(use 'marvel.core)
(resource-action "http://gateway.marvel.com/v1/public/comics/43495") ;; A spider-man comic URI</pre></code>

Calling this function means you can pass in a resource URI and it will handle all your authentication gubbins that you need to provide to actually get the data back.

Enjoy!

## TODOs

The following is a (non-exhaustive) list of things that I will add if/ when I get time. Feel free to request something if you're using this or would like to:

* Package and provide via clojars (only if people want to use it outside of just copying the library into your project)
* Proper error handling
* Make it easier to understand the possible paramater types without having to go directly to the API documantation (haven't really thought how I'd do this - meh)
* Provide convenient mechanisms to return all records within a given set. Currently MArvel limit you to a max of 100 results per call (possibly using core.async?)
* Maybe return data explicitly as maps where it makes sense, rather than the somewhat inconvenient vectors at the moment
* Unit & Integration testing (I did it all on the REPL I promise!)

## License

Copyright © 2015 Mike Holmes

Distributed under the GPL v3 Licence.
