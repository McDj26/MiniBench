import com.thealgorithms.backtracking.ArrayCombination;
import org.junit.jupiter.api.*;
import java.util.List;
import java.util.TreeSet;
import static org.junit.jupiter.api.Assertions.*;

package com.thealgorithms.backtracking;

public class ArrayCombinationTest {
    @Test
    public void combinationTest() {
        // Test for basic functionality with valid input
        int n = 5;
        int k = 3;
        List<TreeSet<Integer>> combinations = ArrayCombination.combination(n, k);
        assertNotNull(combinations); // Assert that the result is not null
        assertFalse(combinations.isEmpty()); // Assert that the list is not empty
        assertTrue(combinations.size() == (n-k+1), "The number of combinations should be equal to n-k+1"); // Assert the size of the list is correct
        // Iterate over the combinations and perform further assertions if needed
        for (TreeSet<Integer> combination : combinations) {
            assertTrue(combination.size() == k, "Each combination should have size k");
            // Additional assertions can be done here if needed, for example checking if all elements are in order or unique
        }
        
        // Test for edge cases and exceptions
        assertNull(ArrayCombination.combination(0, k)); // Assert null return when n <= 0
        // Other edge case tests can be added if needed
    }
}