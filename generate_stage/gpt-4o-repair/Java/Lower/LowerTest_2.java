package com.thealgorithms.strings;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LowerTest {

    @Test
    public void toLowerCaseTest() {
        assertEquals("hello world", Lower.toLowerCase("Hello World"));
        assertEquals("java programming", Lower.toLowerCase("JAVA Programming"));
        assertEquals("test string with numbers 1234", Lower.toLowerCase("Test String With Numbers 1234"));
        assertEquals("another example!", Lower.toLowerCase("Another Example!"));
        assertEquals("", Lower.toLowerCase(""));
        assertEquals("123456", Lower.toLowerCase("123456"));
        assertEquals("mixed 1, 2, 3", Lower.toLowerCase("Mixed 1, 2, 3"));
        assertEquals("symbols ~!@#$%", Lower.toLowerCase("Symbols ~!@#$%"));
    }
}