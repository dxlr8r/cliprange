# cliprange

CLojure IP RANGE: Application for creating a list of IPs from a range

## Usage

### Getting started:

#### Installation

This application requires the [cliptools](https://github.com/dxlr8r/cliptools) library. After installing cliptools cd into the cliprange source and execute: `lein clean; lein uberjar`

#### Running
* Jar: will output IPs as a list seperated by a newline, example:
  * `java -jar target/cliprange-*.jar -r 192.168.1.1-192.168.1.10`, returns all IPs in range seperated by a newline
* Functions: this project is an application wrapper for cliptools, so use that instead. But if you really would want to, example:
  * `(require '[cliprange.core :refer [-main] :rename {-main ip-list}])`
  * `(ip-list "-r" "192.168.1.1-192.168.1.10")`

## License

Copyright © 2015 Simen Strange Øya

Distributed under the Modified BSD license
