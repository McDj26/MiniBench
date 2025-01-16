package com.thealgorithms.strings;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LowerTest {

    @Test
    public void toLowerCaseTest() {
        // Test with an all-uppercase string
        assertEquals("hello world", Lower.toLowerCase("HELLO WORLD"));

        // Test with a mixed-case string
        assertEquals("java programming", Lower.toLowerCase("JaVa PrOgRaMmInG"));

        // Test with an all-lowercase string
        assertEquals("testing", Lower.toLowerCase("testing"));

        // Test with an empty string
        assertEquals("", Lower.toLowerCase(""));

        // Test with a string that includes numbers and symbols
        assertEquals("123 and symbols!@#", Lower.toLowerCase("123 And Symbols!@#"));

        // Test with a null string, expecting no change handling required
        assertThrows(NullPointerException.class, () -> {
            Lower.toLowerCase(null);
        });
    }
}