package org.jfree.data.statistics;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class BoxAndWhiskerCalculatorTest {

    @Test
    public void calculateQ1Test() {
        List<Double> values = new ArrayList<>();
        values.add(1.0);
        values.add(2.0);
        values.add(3.0);
        values.add(4.0);
        values.add(5.0); // Test case with odd number of values
        assertEquals(3.0, BoxAndWhiskerCalculator.calculateQ1(values), 0.0); // Test odd number of values for first quartile calculation
        
        values = new ArrayList<>(); // Reset values list for next test case
        values.add(null); // Invalid input list containing null should result in an IllegalArgumentException being thrown (if implemented in Args class)
        assertThrows(IllegalArgumentException.class, () -> BoxAndWhiskerCalculator.calculateQ1(values)); // Test with null value in list throws exception
        
        values = new ArrayList<>(); // Reset values list for next test case
        values = Collections.<Double>singletonList(Double.NaN); // Test case with single value of NaN should result in an undefined result if Args is not implemented to handle NaN cases in its check
        assertTrue(Double.isNaN(BoxAndWhiskerCalculator.calculateQ1(values))); // Test with NaN value in list results in NaN output
    }
}