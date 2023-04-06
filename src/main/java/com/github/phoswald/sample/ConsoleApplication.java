package com.github.phoswald.sample;

import java.io.PrintStream;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Stream;

public class ConsoleApplication {

    private final PrintStream out;

    ConsoleApplication(PrintStream out) {
        this.out = out;
    }

    public static void main(String[] args) {
        new ConsoleApplication(System.out).run(args);
    }

    void run(String[] args) {
        out.println("Current time: " + ZonedDateTime.now().format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
        out.println("Command line arguments:");
        Stream.of(args) //
                .forEach(this::printValue);
        out.println("Environment variables (starting with 'APP_'):");
        System.getenv().entrySet().stream() //
                .filter(e -> e.getKey().startsWith("APP_")) //
                .sorted(Comparator.comparing(e -> e.getKey())) //
                .forEach(this::printEntry);
        out.println("System properties (starting with 'app.'):");
        System.getProperties().entrySet().stream() //
                .filter(e -> (e.getKey() instanceof String) &&  ((String) e.getKey()).startsWith("app.")) //
                .sorted(Comparator.comparing(e -> e.getKey().toString())) //
                .forEach(this::printEntry);
    }

    private void printValue(String value) {
        out.println("  - " + value);
    }

    private void printEntry(Map.Entry<?, ?> entry) {
        out.println("  " + entry.getKey() + ": " + entry.getValue());
    }
}
