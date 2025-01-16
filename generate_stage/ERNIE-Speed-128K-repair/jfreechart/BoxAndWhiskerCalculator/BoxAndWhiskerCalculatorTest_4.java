package org.jfree.data.statistics;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class BoxAndWhiskerCalculatorTest {

    @Test
    public void calculateQ1Test() {
        List<Double> values = new ArrayList<>();
        values.add(5); // Adding some numbers in ascending order
        values.add(10);
        values.add(15);
        values.add(20);
        values.add(25);
        double expectedResult = 12.5; // Expected first quartile value for this list
        double actualResult = BoxAndWhiskerCalculator.calculateQ1(values);
        assertEquals(expectedResult, actualResult, "The first quartile is not calculated correctly.");
    }
    
    // Test case for an odd number of values in the list
    @Test
    public void calculateQ1OddNumberTest() {
        List<Double> values = new ArrayList<>();
        values.add(5); // Adding some numbers in ascending order with an odd number of values
        values.add(10);
        values.add(15);
        double expectedResult = 10; // Expected first quartile value for this list since it has an odd number of elements
        double actualResult = BoxAndWhiskerCalculator.calculateQ1(values);
        assertEquals(expectedResult, actualResult, "The first quartile is not calculated correctly for odd number of values.");
    }
    
    // Test case with an empty list of values to check the behavior when the list is empty
    @Test
    public void calculateQ1EmptyListTest() {
        List<Double> values = new ArrayList<>(); // Empty list of values
        assertThrows(IllegalArgumentException.class, () -> BoxAndWhiskerCalculator.calculateQ1(values), "Should throw IllegalArgumentException for empty list.");
    }
    
    // Test case with null list to check the behavior when the input is null
    @Test
    public void calculateQ1NullListTest() {
        assertThrows(IllegalArgumentException.class, () -> BoxAndWhiskerCalculator.calculateQ1(null), "Should throw IllegalArgumentException for null list.");
    }
}