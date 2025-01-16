package com.google.zxing.common;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BitArrayTest {
    @Test
    public void getNextSetTest() {
        BitArray bitArray;
        int nextSetIndex;
        int expectedIndex;
        int from;
        int size;
        boolean[] testCases = {
            // Test case 1: empty BitArray
            true, // Expect size to be returned since no bits are set
            // Test case 2: BitArray with one bit set at the beginning
            false, // Expect index of the set bit to be returned
            // Test case 3: BitArray with one bit set at the end
            false, // Expect index of the set bit to be returned
            // Test case 4: BitArray with bits set in between (no consecutive bits set)
            false, // Expect index of the first set bit after 'from' to be returned
            // Test case 5: BitArray with consecutive bits set (multiple consecutive bits starting from 'from')
            true  // Expect size to be returned since no bits are set at or beyond 'from' index
        };
        size = testCases.length * 3 + 2; // Adjust size based on test cases (add some more bits for convenience)
        bitArray = new BitArray(size); // Initialize a BitArray with a sufficient size for testing
        for (int i = 0; i < size; i++) { // Set bits based on test cases for testing getNextSet() method
            if (testCases[i / 3]) { // If true, set the bit at current index (i/3 * 3) to 1
                bitArray.set(i / 3 * 3);
            } else if ((i % 3 == 1) && (i / 3 != size / 3)) { // Set bits in between (not consecutive) if needed
                bitArray.set(i);
            } else if ((i % 3 == 0) && (i < size - 2)) { // Set consecutive bits starting from index 0 if needed
                bitArray.setBulk(i, (size - i - 1) * 8); // Setting number of consecutive bits equal to 'size - i - 1' multiplied by 'number of bits in a byte' (8)
            } else { // Do nothing for other cases to maintain the BitArray in an unset state for testing purposes
                continue; // Skip the remaining cases to avoid unnecessary settings
            }
        }
        for (int testIndex = 0; testIndex < testCases.length; testIndex++) { // Test each scenario from the testCases array
            from = testIndex * 3; // Adjust the starting index based on the test case index (to match the bit setting logic above)
            nextSetIndex = bitArray.getNextSet(from); // Call getNextSet() method to get the index of the next set bit from the given index 'from'
            expectedIndex = testIndex * 3; // Expected index should match the index where we set the bit in our test cases above (0, 3, or 6)
            assertEquals(expectedIndex, nextSetIndex); // Assert that the expected index matches the actual index returned by getNextSet() method
        }
    }
}