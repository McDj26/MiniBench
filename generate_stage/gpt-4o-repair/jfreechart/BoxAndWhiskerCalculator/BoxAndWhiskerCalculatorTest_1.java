package org.jfree.data.statistics;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

public class BoxAndWhiskerCalculatorTest {

    @Test
    public void calculateQ1Test() {
        // Test with an odd number of elements
        List<Double> values1 = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        double expectedQ1_1 = 2.0; // Q1 is the median of {1.0, 2.0}
        double actualQ1_1 = BoxAndWhiskerCalculator.calculateQ1(values1);
        assertEquals(expectedQ1_1, actualQ1_1, 0.0001);

        // Test with an even number of elements
        List<Double> values2 = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);
        double expectedQ1_2 = 2.5; // Q1 is the median of {1.0, 2.0, 3.0}
        double actualQ1_2 = BoxAndWhiskerCalculator.calculateQ1(values2);
        assertEquals(expectedQ1_2, actualQ1_2, 0.0001);

        // Test with a single element
        List<Double> values3 = Collections.singletonList(2.0);
        double expectedQ1_3 = 2.0; // Q1 is the median of the single element
        double actualQ1_3 = BoxAndWhiskerCalculator.calculateQ1(values3);
        assertEquals(expectedQ1_3, actualQ1_3, 0.0001);

        // Test with an empty list
        List<Double> values4 = Collections.emptyList();
        double expectedQ1_4 = Double.NaN; // Q1 is undefined for an empty list
        double actualQ1_4 = BoxAndWhiskerCalculator.calculateQ1(values4);
        assertTrue(Double.isNaN(actualQ1_4));
    }
}