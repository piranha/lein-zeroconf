# lein-zeroconf

A Leiningen plugin to register your running nREPL process in Zeroconf.

## Usage

Edit your `~/.lein/profiles.clj` and put that in `[:user :plugins]`:

```
[lein-zeroconf "0.1.0"]
```

Now every time you run `lein repl`, a Zeroconf registration will be done.

## License

Copyright © 2013 Alexander Solovyov

Distributed under the Eclipse Public License, the same as Clojure.
