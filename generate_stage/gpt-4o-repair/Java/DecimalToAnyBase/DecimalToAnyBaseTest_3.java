package com.thealgorithms.conversions;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DecimalToAnyBaseTest {

    @Test
    public void convertToAnyBaseTest() {
        // Test conversion to binary (base 2)
        assertEquals("1010", DecimalToAnyBase.convertToAnyBase(10, 2), "Failed to convert 10 to binary");

        // Test conversion to octal (base 8)
        assertEquals("12", DecimalToAnyBase.convertToAnyBase(10, 8), "Failed to convert 10 to octal");

        // Test conversion to decimal (base 10) - should return the number itself
        assertEquals("10", DecimalToAnyBase.convertToAnyBase(10, 10), "Failed to convert 10 to base 10");

        // Test conversion to hexadecimal (base 16)
        assertEquals("A", DecimalToAnyBase.convertToAnyBase(10, 16), "Failed to convert 10 to hexadecimal");

        // Test edge case: conversion of 0 to any base should return "0"
        assertEquals("0", DecimalToAnyBase.convertToAnyBase(0, 2), "Failed to convert 0 to base 2");
        assertEquals("0", DecimalToAnyBase.convertToAnyBase(0, 10), "Failed to convert 0 to base 10");

        // Test base case: conversion of 1 to any base should return "1"
        assertEquals("1", DecimalToAnyBase.convertToAnyBase(1, 2), "Failed to convert 1 to base 2");
        assertEquals("1", DecimalToAnyBase.convertToAnyBase(1, 10), "Failed to convert 1 to base 10");

        // Test conversion with a larger number
        assertEquals("FF", DecimalToAnyBase.convertToAnyBase(255, 16), "Failed to convert 255 to hexadecimal");
    }
}