package com.thealgorithms.strings;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LowerTest {

    @Test
    public void toLowerCaseTest() {
        // Test with a string that contains uppercase letters
        assertEquals("hello world", Lower.toLowerCase("Hello World"));
        
        // Test with a string that is already in lowercase
        assertEquals("java", Lower.toLowerCase("java"));
        
        // Test with a string that has mixed case
        assertEquals("unittesting", Lower.toLowerCase("uNiTtEstInG"));
        
        // Test with a string that contains numbers and special characters
        assertEquals("123!@#abc", Lower.toLowerCase("123!@#ABC"));
        
        // Test with an empty string
        assertEquals("", Lower.toLowerCase(""));
        
        // Test with a string that contains only uppercase letters
        assertEquals("lowercase", Lower.toLowerCase("LOWERCASE"));
        
        // Test with a string that contains only non-alpha characters
        assertEquals("!@#$%", Lower.toLowerCase("!@#$%"));
    }
}