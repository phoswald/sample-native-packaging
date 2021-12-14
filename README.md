
# sample-native-packaging

Experiments with jlink, jpackage, and more

## Maven

~~~
$ mvn clean verify

$ export APP_FOO=BAR
$ export APP_BAR=BAZ

$ java \
  -cp target/sample-native-packaging.jar \
  -Dapp.foo=BAR \
  -Dapp.bar=BAZ \
  com.github.phoswald.sample.ConsoleApplication foo bar

$ java \
  -p target/sample-native-packaging.jar \
  -Dapp.foo=BAR \
  -Dapp.bar=BAZ \
  -m com.github.phoswald.sample/com.github.phoswald.sample.ConsoleApplication foo bar

$ java -cp target/sample-native-packaging.jar \
  com.github.phoswald.sample.SwingApplication

$ java \
  -p target/sample-native-packaging.jar \
  -m com.github.phoswald.sample/com.github.phoswald.sample.SwingApplication
~~~

## jlink

- See [jlink](https://docs.oracle.com/en/java/javase/17/docs/specs/man/jlink.html)

~~~
$ jlink \
  -p target/sample-native-packaging.jar \
  --add-modules com.github.phoswald.sample \
  --output target/jre \
  --strip-debug --no-man-pages --no-header-files

$ target/jre/bin/java \
  -Dapp.foo=BAR \
  -Dapp.bar=BAZ \
  -m com.github.phoswald.sample/com.github.phoswald.sample.ConsoleApplication foo bar

$ target/jre/bin/java \
  -m com.github.phoswald.sample/com.github.phoswald.sample.SwingApplication
~~~

The resulting modules are stored in `target/jre/release` (along with the JRE version) and 
returned by `target/jre/bin/java --list-modules`.

## jpackage

- See [jpackage](https://docs.oracle.com/en/java/javase/17/docs/specs/man/jpackage.html)

~~~
$ jpackage \
  -d target/package -n sample-console \
  -p target/sample-native-packaging.jar \
  -m com.github.phoswald.sample/com.github.phoswald.sample.ConsoleApplication \
  -t app-image \
  --java-options "-Dapp.foo=bar -Dapp.bar=BAZ"

$ jpackage \
  -d target/package -n sample-swing \
  -p target/sample-native-packaging.jar \
  -m com.github.phoswald.sample/com.github.phoswald.sample.SwingApplication \
  -t app-image

$ ./target/package/sample-console/bin/sample-console foo bar
$ ./target/package/sample-swing/bin/sample-swing
~~~

By default (if `-t app-image` is not specified), an installable package (`*.deb` on Ubuntu) is created.

The ouput of `jlink` can be used by specifing `--runtime-image target/jre` and omitting `-p ...`.
