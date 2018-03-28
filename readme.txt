$ rm -rf target

$ javac --module-source-path src/modules --module com.example -d target/modules src/modules/com.example/com/example/Test.java
$ java --module-path target/modules --module com.example/com.example.Test

$ jlink --module-path target/modules --add-modules com.example --output target/jre
$ target/jre/bin/java --module com.example/com.example.Test
$ target/jre/bin/java --list-modules

