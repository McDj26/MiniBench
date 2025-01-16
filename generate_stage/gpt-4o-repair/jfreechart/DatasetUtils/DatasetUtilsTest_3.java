package org.jfree.data.general;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.jfree.data.PieDataset;
import java.util.Arrays;
import java.util.List;

public class DatasetUtilsTest {

    @Test
    public void calculatePieDatasetTotalTest() {
        // Mock the PieDataset
        PieDataset mockDataset = mock(PieDataset.class);

        // Define the keys and the values it should return
        List<String> keys = Arrays.asList("A", "B", "C", "D");
        when(mockDataset.getKeys()).thenReturn(keys);
        when(mockDataset.getValue("A")).thenReturn(1.5);
        when(mockDataset.getValue("B")).thenReturn(-2.0); // should be ignored
        when(mockDataset.getValue("C")).thenReturn(null); // should be ignored
        when(mockDataset.getValue("D")).thenReturn(3.5);

        // Calculate the total using the method
        double result = DatasetUtils.calculatePieDatasetTotal(mockDataset);

        // Assert the expected result, ignoring negative and null values: 1.5 + 3.5 = 5.0
        assertEquals(5.0, result, 0.0001);
    }

    @Test
    public void testCalculatePieDatasetTotalWithNullDataset() {
        // Verify that an exception is thrown when a null dataset is passed
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            DatasetUtils.calculatePieDatasetTotal(null);
        });
        assertEquals("Null 'dataset' argument.", exception.getMessage());
    }

    @Test
    public void testCalculatePieDatasetTotalWithAllNegativeOrNullValues() {
        // Mock the PieDataset
        PieDataset mockDataset = mock(PieDataset.class);

        // Define the keys and the values it should return
        List<String> keys = Arrays.asList("X", "Y");
        when(mockDataset.getKeys()).thenReturn(keys);
        when(mockDataset.getValue("X")).thenReturn(-4.0); // should be ignored
        when(mockDataset.getValue("Y")).thenReturn(null); // should be ignored

        // Calculate the total using the method
        double result = DatasetUtils.calculatePieDatasetTotal(mockDataset);

        // Assert the expected result, since all values are negative or null
        assertEquals(0.0, result, 0.0001);
    }
}