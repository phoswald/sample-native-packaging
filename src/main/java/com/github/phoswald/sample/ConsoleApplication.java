package com.github.phoswald.sample;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Stream;

public class ConsoleApplication {

    public static void main(String[] args) {
        new ConsoleApplication().run(args);
    }

    private void run(String[] args) {
        System.out.println("Current time : " + ZonedDateTime.now().format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
        System.out.println("Command line arguments:");
        Stream.of(args) //
                .forEach(this::printValue);
        System.out.println("Environment variables (starting with 'APP_'):");
        System.getenv().entrySet().stream() //
                .filter(e -> e.getKey().startsWith("APP_")) //
                .sorted(Comparator.comparing(e -> e.getKey())) //
                .forEach(this::printEntry);
        System.out.println("System properties (starting with 'app.'):");
        System.getProperties().entrySet().stream() //
                .filter(e -> (e.getKey() instanceof String) &&  ((String) e.getKey()).startsWith("app.")) //
                .sorted(Comparator.comparing(e -> e.getKey().toString())) //
                .forEach(this::printEntry);
    }

    private void printValue(String value) {
        System.out.println("  - " + value);
    }

    private void printEntry(Map.Entry<?, ?> entry) {
        System.out.println("  " + entry.getKey() + ": " + entry.getValue());
    }
}
