package com.google.zxing.common;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BitArrayTest {

    @Test
    public void getNextSetTest() {
        int size = 64;
        BitArray bitArray = new BitArray(size);

        // Initial state: all bits are unset (0)
        assertEquals(size, bitArray.getNextSet(0));

        // Set some bits and test again
        bitArray.set(2);
        assertEquals(2, bitArray.getNextSet(0));

        bitArray.set(32);
        assertEquals(2, bitArray.getNextSet(0));  // first set bit is still at index 2
        assertEquals(32, bitArray.getNextSet(3)); // first set bit after index 3

        bitArray.set(60);
        assertEquals(60, bitArray.getNextSet(33)); // first set bit after index 33

        // Test from a starting index beyond any set bit
        assertEquals(size, bitArray.getNextSet(61));
    }
}