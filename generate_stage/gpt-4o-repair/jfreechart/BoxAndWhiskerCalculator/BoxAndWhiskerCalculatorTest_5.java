package org.jfree.data.statistics;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

public class BoxAndWhiskerCalculatorTest {

    @Test
    public void calculateQ1Test() {
        // Test with an odd number of elements.
        List<Double> oddList = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        double result1 = BoxAndWhiskerCalculator.calculateQ1(oddList);
        assertEquals(1.5, result1, 0.001);

        // Test with an even number of elements.
        List<Double> evenList = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);
        double result2 = BoxAndWhiskerCalculator.calculateQ1(evenList);
        assertEquals(1.5, result2, 0.001);

        // Test with empty list
        List<Double> emptyList = Arrays.asList();
        double result3 = BoxAndWhiskerCalculator.calculateQ1(emptyList);
        assertTrue(Double.isNaN(result3));

        // Test with list containing null values should raise an error
        List<Double> nullList = Arrays.asList(1.0, null, 3.0, 4.0);
        assertThrows(IllegalArgumentException.class, () -> {
            BoxAndWhiskerCalculator.calculateQ1(nullList);
        });
    }
}