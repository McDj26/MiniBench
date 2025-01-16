package com.google.zxing.common;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BitArrayTest {

    @Test
    public void getNextSetTest() {
        // Setup a bit array with size of 64 bits (2 integers)
        BitArray bitArray = new BitArray(64);

        // Initially all bits are unset, so getNextSet should return the size if inspected from any index
        assertEquals(64, bitArray.getNextSet(0), "No bits are set, should return size");
        assertEquals(64, bitArray.getNextSet(32), "No bits are set, should return size");
        
        // Set a bit and test
        bitArray.set(10);
        assertEquals(10, bitArray.getNextSet(0), "Bit 10 is set, should return 10");
        assertEquals(10, bitArray.getNextSet(5), "Bits after 5, first set bit is 10");

        // Set another bit and test
        bitArray.set(35);
        assertEquals(10, bitArray.getNextSet(0), "First set bit is 10");
        assertEquals(35, bitArray.getNextSet(11), "Bits after 11, next set bit is 35");

        // Test when starting from beyond the last set bit
        assertEquals(64, bitArray.getNextSet(36), "No more set bits after 35, should return size");

        // Test when starting index is beyond array size
        assertEquals(64, bitArray.getNextSet(64), "Start beyond size, should return size");
    }
}