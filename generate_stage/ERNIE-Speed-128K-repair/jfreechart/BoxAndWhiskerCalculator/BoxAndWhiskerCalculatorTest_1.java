package org.jfree.data.statistics;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoxAndWhiskerCalculatorTest {
    
    @Test
    public void calculateQ1Test() {
        // Test case for calculateQ1 with odd number of values
        List<Double> oddValues = new ArrayList<>();
        oddValues.add(5.0);
        oddValues.add(7.0);
        oddValues.add(9.0);
        double expectedResult = 7.0; // Expected first quartile for odd number of values
        assertEquals(expectedResult, BoxAndWhiskerCalculator.calculateQ1(oddValues), 0.0);
        
        // Test case for calculateQ1 with even number of values
        List<Double> evenValues = new ArrayList<>();
        evenValues.add(4.0);
        evenValues.add(6.0);
        evenValues.add(8.0);
        expectedResult = 6.0; // Expected first quartile for even number of values
        assertEquals(expectedResult, BoxAndWhiskerCalculator.calculateQ1(evenValues), 0.0);
        
        // Test case with empty list
        List<Double> emptyList = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> BoxAndWhiskerCalculator.calculateQ1(emptyList)); // Expect IllegalArgumentException for empty list
        
        // Test case with null list
        assertThrows(IllegalArgumentException.class, () -> BoxAndWhiskerCalculator.calculateQ1(null)); // Expect IllegalArgumentException for null list
    }
}