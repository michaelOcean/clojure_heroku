(ns demo.web
  (:use ring.adapter.jetty))

(defn handler [req]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body "<p> Clojure is fun! </p>
         <script src='http://widgets.twimg.com/j/2/widget.js'></script>
<script>
new TWTR.Widget({
  version: 2,
  type: 'profile',
  rpp: 4,
  interval: 6000,
  width: 250,
  height: 300,
  theme: {
    shell: {
      background: '#432e6b',
      color: '#ffffff'
    },
    tweets: {
      background: '#170421',
      color: '#ccc6cc',
      links: '#8d6fab'
    }
  },
  features: {
    scrollbar: false,
    loop: false,
    live: false,
    hashtags: true,
    timestamp: true,
    avatars: false,
    behavior: 'all'
  }
}).render().setUser('michaelOceanChu').start();
</script>"})

(def app
  (-> #'handler))

(defn -main []
  (let [port (Integer/parseInt (System/getenv "PORT"))]
    (run-jetty app {:port port})))