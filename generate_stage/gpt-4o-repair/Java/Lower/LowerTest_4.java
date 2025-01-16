package com.thealgorithms.strings;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LowerTest {

    @Test
    public void toLowerCaseTest() {
        // Test with a normal string with uppercase letters
        assertEquals("hello world", Lower.toLowerCase("Hello World"));
        
        // Test with string already in lowercase
        assertEquals("hello world", Lower.toLowerCase("hello world"));
        
        // Test with empty string
        assertEquals("", Lower.toLowerCase(""));
        
        // Test with mixed case string
        assertEquals("java programming", Lower.toLowerCase("JaVa ProGrAmMiNg"));
        
        // Test with a string that contains numbers and special characters
        assertEquals("1234!@# lower", Lower.toLowerCase("1234!@# LOWER"));
        
        // Test with null input (this requires modifying the method to handle nulls if not yet handled)
        assertThrows(NullPointerException.class, () -> {
            Lower.toLowerCase(null);
        });
    }
}