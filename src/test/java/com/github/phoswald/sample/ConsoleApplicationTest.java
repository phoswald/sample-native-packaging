package com.github.phoswald.sample;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;

class ConsoleApplicationTest {

    @Test
    void toString_valid_success() {
        var buffer = new ByteArrayOutputStream();
        var testee = new ConsoleApplication(new PrintStream(buffer));
        testee.run(new String[] { "SampleArgument" });
        String result = buffer.toString(StandardCharsets.UTF_8);
        assertThat(result, containsString("Current time: 20"));
        assertThat(result, containsString("SampleArgument"));
    }
}
