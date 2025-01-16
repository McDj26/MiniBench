package org.jfree.data.general;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import java.util.Arrays;

public class DatasetUtilsTest {

    @Test
    public void calculatePieDatasetTotalTest() {
        // Create mock of PieDataset
        PieDataset dataset = Mockito.mock(PieDataset.class);

        // Define behavior of getKeys and getValue methods
        Mockito.when(dataset.getKeys()).thenReturn(Arrays.asList("A", "B", "C", "D"));
        Mockito.when(dataset.getValue("A")).thenReturn(10.0);
        Mockito.when(dataset.getValue("B")).thenReturn(null);
        Mockito.when(dataset.getValue("C")).thenReturn(-5.0);
        Mockito.when(dataset.getValue("D")).thenReturn(15.0);

        // Call the method under test
        double total = DatasetUtils.calculatePieDatasetTotal(dataset);

        // Assert the expected total is the sum of non-null, non-negative values
        assertEquals(25.0, total, 0.0001, "The total should be the sum of non-null, non-negative values.");
    }
}