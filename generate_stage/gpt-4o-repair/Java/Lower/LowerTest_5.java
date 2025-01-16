package com.thealgorithms.strings;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LowerTest {
    
    @Test
    public void toLowerCaseTest() {
        // Test conversion of mixed case string
        assertEquals("hello world", Lower.toLowerCase("HeLLo WoRLd"));
        
        // Test conversion of all uppercase string
        assertEquals("java programming", Lower.toLowerCase("JAVA PROGRAMMING"));
        
        // Test conversion of empty string
        assertEquals("", Lower.toLowerCase(""));
        
        // Test conversion of string with no uppercase letters
        assertEquals("no change", Lower.toLowerCase("no change"));
        
        // Test conversion of string with special characters
        assertEquals("1234!@#$", Lower.toLowerCase("1234!@#$"));
        
        // Test conversion of string with a single uppercase letter
        assertEquals("a", Lower.toLowerCase("A"));
    }
}