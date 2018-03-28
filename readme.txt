$ rm -rf target
$ javac --module-source-path src/modules --module com.example -d target/modules src/modules/com.example/com/example/Test.java
$ java --module-path target/modules --module com.example/com.example.Test

