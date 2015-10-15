(defproject cliprange "1.0.0"
  :description "CLojure IP RANGE: Application for creating a list of IPs from a range"
  :url "https://github.com/dxlr8r/cliprange"
  :license {:name "Modified BSD license"
            :url "https://github.com/dxlr8r/cliprange/blob/master/LICENSE"}
  :main cliprange.core
  :aot [cliprange.core]
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/tools.cli "0.3.1"]
                 [no.ifixit/cliptools "1.0.0"]
                 [no.ifixit/csprint "1.0.0"]
                 ])
