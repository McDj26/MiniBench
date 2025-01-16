package com.google.zxing.common;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BitArrayTest {

    @Test
    public void getNextSetTest() {
        // Create a BitArray with a specific size
        BitArray bitArray = new BitArray(64);

        // Initially, all bits are unset, so getNextSet should return the size if looking for a set bit
        assertEquals(64, bitArray.getNextSet(0), "No bits are set; expecting size");

        // Set some bits in the array
        bitArray.set(10);
        bitArray.set(20);
        bitArray.set(63);

        // Test getting the next set bit from various starting indexes
        assertEquals(10, bitArray.getNextSet(0), "Next set bit from index 0 should be 10");
        assertEquals(10, bitArray.getNextSet(10), "Next set bit from index 10 should be 10");
        assertEquals(20, bitArray.getNextSet(11), "Next set bit from index 11 should be 20");
        assertEquals(20, bitArray.getNextSet(19), "Next set bit from index 19 should be 20");
        assertEquals(63, bitArray.getNextSet(21), "Next set bit from index 21 should be 63");
        assertEquals(64, bitArray.getNextSet(64), "No bits are set from index 64 forward; expecting size");

        // Check for beyond the current size
        assertEquals(64, bitArray.getNextSet(65), "When from is beyond the size, return should be size");
    }
}