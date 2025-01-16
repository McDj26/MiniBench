package org.jfree.data.statistics;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

public class BoxAndWhiskerCalculatorTest {

    @Test
    public void calculateQ1Test() {
        // Test with a list of numbers in ascending order with an odd number of elements
        List<Double> values1 = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        double q1_1 = BoxAndWhiskerCalculator.calculateQ1(values1);
        assertEquals(1.5, q1_1, 0.001, "Q1 calculation for odd number of elements is incorrect");

        // Test with a list of numbers in ascending order with an even number of elements
        List<Double> values2 = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);
        double q1_2 = BoxAndWhiskerCalculator.calculateQ1(values2);
        assertEquals(2.0, q1_2, 0.001, "Q1 calculation for even number of elements is incorrect");

        // Test with a single element
        List<Double> values3 = Arrays.asList(1.0);
        double q1_3 = BoxAndWhiskerCalculator.calculateQ1(values3);
        assertEquals(1.0, q1_3, 0.001, "Q1 calculation for a single element is incorrect");

        // Test with an empty list
        List<Double> values4 = Arrays.asList();
        double q1_4 = BoxAndWhiskerCalculator.calculateQ1(values4);
        assertTrue(Double.isNaN(q1_4), "Q1 calculation for an empty list should return NaN");

        // Test with null input
        List<Double> values5 = null;
        assertThrows(IllegalArgumentException.class, () -> {
            BoxAndWhiskerCalculator.calculateQ1(values5);
        }, "Q1 calculation should throw IllegalArgumentException for null input");
    }
}