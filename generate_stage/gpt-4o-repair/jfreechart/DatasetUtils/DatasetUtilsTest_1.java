package org.jfree.data.general;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.jfree.data.DefaultPieDataset;
import org.jfree.data.KeyedValues;
import org.jfree.data.general.PieDataset;

public class DatasetUtilsTest {

    @Test
    public void calculatePieDatasetTotalTest() {
        // Create a mock PieDataset
        PieDataset dataset = mock(PieDataset.class);

        // Mock the keys
        List<Comparable> keys = List.of("A", "B", "C", "D");
        when(dataset.getKeys()).thenReturn(keys);

        // Mock the values
        when(dataset.getValue("A")).thenReturn(1.0);
        when(dataset.getValue("B")).thenReturn(null);
        when(dataset.getValue("C")).thenReturn(-5.0);
        when(dataset.getValue("D")).thenReturn(2.0);

        // Calculate the total
        double total = DatasetUtils.calculatePieDatasetTotal(dataset);

        // Check that the total is correct
        assertEquals(3.0, total, 0.0001);

        // Edge case: dataset with no keys
        PieDataset emptyDataset = mock(PieDataset.class);
        when(emptyDataset.getKeys()).thenReturn(List.of());
        double emptyDatasetTotal = DatasetUtils.calculatePieDatasetTotal(emptyDataset);
        assertEquals(0.0, emptyDatasetTotal, 0.0001);

        // Edge case: dataset with all negative or null values
        PieDataset negativeDataset = mock(PieDataset.class);
        List<Comparable> negativeKeys = List.of("X", "Y");
        when(negativeDataset.getKeys()).thenReturn(negativeKeys);
        when(negativeDataset.getValue("X")).thenReturn(-3.0);
        when(negativeDataset.getValue("Y")).thenReturn(null);
        double negativeDatasetTotal = DatasetUtils.calculatePieDatasetTotal(negativeDataset);
        assertEquals(0.0, negativeDatasetTotal, 0.0001);
    }
}