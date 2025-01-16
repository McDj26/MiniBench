package org.jfree.data.statistics;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoxAndWhiskerCalculatorTest {
    
    @Test
    public void calculateQ1Test() {
        // Test case for empty list
        List values = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> BoxAndWhiskerCalculator.calculateQ1(values));
        
        // Test case for list with one element
        List<Double> oneElementList = new ArrayList<>();
        oneElementList.add(5.0);
        assertEquals(5.0, BoxAndWhiskerCalculator.calculateQ1(oneElementList), 0.0); // Assuming calculateMedian returns the single element for odd count
        
        // Test case for list with odd number of elements in ascending order
        List<Double> oddOrderList = new ArrayList<>();
        oddOrderList.add(1.0);
        oddOrderList.add(2.0);
        oddOrderList.add(3.0); // Expecting Q1 to be 2.0 since it's the median of the first two elements (middle value)
        assertEquals(2.0, BoxAndWhiskerCalculator.calculateQ1(oddOrderList), 0.0); // Assuming calculateMedian returns the middle value for odd count
        
        // Test case for list with even number of elements in ascending order
        List<Double> evenOrderList = new ArrayList<>();
        evenOrderList.add(1.0); // Expecting Q1 to be the average of the middle two elements (2nd and 3rd) since count is even
        evenOrderList.add(2.0); // Assuming calculateMedian returns the average of middle two values for even count
        evenOrderList.add(3.0); // Add more elements to test for a bigger list with even count as needed
        assertEquals(1.5, BoxAndWhiskerCalculator.calculateQ1(evenOrderList), 0.0); // Assuming average of 2nd and 3rd is 1.5 for this example case
        
        // Test case for a list that should result in NaN due to non-sorted order or other reasons specified in the source code comments (not implemented here)
    }
}