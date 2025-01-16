package org.jfree.data.statistics;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

public class BoxAndWhiskerCalculatorTest {

    @Test
    public void calculateQ1Test() {
        // Test with an odd number of elements
        List<Double> valuesOdd = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        double expectedQ1Odd = 1.5; // Median of the lower half: (1, 2)
        assertEquals(expectedQ1Odd, BoxAndWhiskerCalculator.calculateQ1(valuesOdd));

        // Test with an even number of elements
        List<Double> valuesEven = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);
        double expectedQ1Even = 1.5; // Median of the lower half: (1, 2)
        assertEquals(expectedQ1Even, BoxAndWhiskerCalculator.calculateQ1(valuesEven));

        // Test with a single element
        List<Double> valuesSingle = Arrays.asList(5.0);
        double expectedQ1Single = 5.0;
        assertEquals(expectedQ1Single, BoxAndWhiskerCalculator.calculateQ1(valuesSingle));

        // Test with no elements
        List<Double> valuesEmpty = Arrays.asList();
        double expectedQ1Empty = Double.NaN;
        assertEquals(expectedQ1Empty, BoxAndWhiskerCalculator.calculateQ1(valuesEmpty));

        // Test with null list
        assertThrows(IllegalArgumentException.class, () -> BoxAndWhiskerCalculator.calculateQ1(null));
    }
}