package org.jfree.data.general;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.jfree.data.general.PieDataset;

import java.util.Arrays;

public class DatasetUtilsTest {

    @Test
    public void calculatePieDatasetTotalTest() {
        PieDataset mockDataset = mock(PieDataset.class);
        
        when(mockDataset.getKeys()).thenReturn(Arrays.asList("A", "B", "C", "D", null));
        when(mockDataset.getValue("A")).thenReturn(5.0);
        when(mockDataset.getValue("B")).thenReturn(-3.0);  // Negative value should be ignored
        when(mockDataset.getValue("C")).thenReturn(2.5);
        when(mockDataset.getValue("D")).thenReturn(null);  // Null value should be ignored
        when(mockDataset.getValue(null)).thenReturn(10.0);  // This null key should be ignored entirely

        double total = DatasetUtils.calculatePieDatasetTotal(mockDataset);
        
        assertEquals(7.5, total, 0.0001);
    }
}