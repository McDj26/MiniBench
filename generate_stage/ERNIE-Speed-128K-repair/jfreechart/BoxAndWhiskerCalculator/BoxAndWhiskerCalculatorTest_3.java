package org.jfree.data.statistics;

import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;

public class BoxAndWhiskerCalculatorTest {
    @Test
    public void calculateQ1Test() {
        // Test case for empty list
        assertThrows(IllegalArgumentException.class, () -> BoxAndWhiskerCalculator.calculateQ1(new ArrayList<>()));
        
        // Test case for list with one element
        List<Double> values = new ArrayList<>();
        values.add(1.0);
        assertEquals(Double.NaN, BoxAndWhiskerCalculator.calculateQ1(values), "Result should be Double.NaN for odd length list with one element.");
        
        // Test case for list with odd number of elements
        values = new ArrayList<>();
        values.add(0.5); // The median will be between these two values in case of odd number of elements
        values.add(1.5); // The median will be between these two values in case of odd number of elements
        Collections.sort(values); // Sorting the list before calculating Q1 as per the given Java Source Code requirement
        assertEquals(1.0, BoxAndWhiskerCalculator.calculateQ1(values), "Result should be 1.0 for odd length list.");
        
        // Test case for list with even number of elements
        values = new ArrayList<>();
        values.add(0.0); // The median will be this value in case of even number of elements and position is half of the list size minus 1
        values.add(0.5); // The median will be this value in case of even number of elements and position is half of the list size minus 1
        Collections.sort(values); // Sorting the list before calculating Q1 as per the given Java Source Code requirement
        assertEquals(0.25, BoxAndWhiskerCalculator.calculateQ1(values), "Result should be the average of middle two values for even length list.");
    }
}