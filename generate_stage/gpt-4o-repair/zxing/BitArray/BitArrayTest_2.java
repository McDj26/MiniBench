package com.google.zxing.common;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BitArrayTest {

    @Test
    public void getNextSetTest() {
        // Scenario 1: No bits are set
        BitArray bitArray = new BitArray(64);
        assertEquals(64, bitArray.getNextSet(0), "Expected 64 because no bits are set in an empty array.");

        // Scenario 2: Bits are set after a certain index
        bitArray.set(10);
        assertEquals(10, bitArray.getNextSet(0), "Expected index 10 to be the first set bit.");

        // Scenario 3: Starting search after first set bit
        assertEquals(10, bitArray.getNextSet(5), "Expected index 10 as it's the first set bit after index 5.");

        // Scenario 4: Starting search exactly at a set bit index
        assertEquals(10, bitArray.getNextSet(10), "Expected index 10 due to starting at a set bit.");

        // Scenario 5: Multiple set bits
        bitArray.set(20);
        bitArray.set(30);
        assertEquals(20, bitArray.getNextSet(11), "Expected index 20 as the next set bit after index 11.");
        assertEquals(30, bitArray.getNextSet(21), "Expected index 30 as the next set bit after index 21.");

        // Scenario 6: Index beyond size
        assertEquals(64, bitArray.getNextSet(64), "Expected size index since searching beyond set size.");
    }
}