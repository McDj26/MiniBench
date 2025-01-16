package com.google.zxing.common;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BitArrayTest {
    @Test
    public void getNextSetTest() {
        BitArray bitArray = new BitArray(32); // Create a BitArray with size 32
        // Set some bits
        bitArray.set(0); // Set the first bit
        bitArray.set(3); // Set the fourth bit
        bitArray.set(31); // Set the last bit (32th bit)
        assertEquals(0, bitArray.getNextSet(0), "The first set bit should be at index 0"); // Test getNextSet with starting index 0
        assertEquals(3, bitArray.getNextSet(1), "The next set bit after index 0 should be at index 3");
        assertEquals(31, bitArray.getNextSet(3), "The next set bit after index 3 should be at index 31"); // Assuming that the size of BitArray is represented in number of bits and not bytes, this will test that it wraps around correctly to the end of the array.
        assertEquals(32, bitArray.getNextSet(32), "The index should return size if no bits are set at or beyond this given index"); // Assuming that the size of BitArray is represented in number of bits and not bytes, this will test that it correctly handles the end of the array.
        assertEquals(-1, bitArray.getNextSet(33), "The index should return -1 if no bits are set at or beyond this given index (overflow condition)"); // Test a value beyond the actual size of BitArray
    }
}