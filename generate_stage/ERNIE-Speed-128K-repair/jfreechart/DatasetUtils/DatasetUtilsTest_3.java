package org.jfree.data.general;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DatasetUtilsTest {

    @Test
    public void calculatePieDatasetTotalTest() {
        // Example PieDataset
        PieDataset pieDataset = new DefaultPieDataset();
        pieDataset.setValue("A", 23); // add series A with value 23
        pieDataset.setValue("B", 45); // add series B with value 45
        pieDataset.setValue("C", null); // add series C with null value
        pieDataset.setValue("D", 30); // add series D with value 30
        pieDataset.setValue("E", new Double(Double.NaN)); // add series E with NaN value
        pieDataset.setValue("F", 0); // add series F with value 0 (should not be included in total)
        pieDataset.setValue("G", new Double(Integer.MAX_VALUE); // add series G with maximum positive value
        double total = DatasetUtils.calculatePieDatasetTotal(pieDataset); // should calculate the sum of all positive non-null values, ignoring NaN and negative values
        assertEquals(98, total, 0.0); // expected result is sum of A, B, D and G values, ignoring C, E and F values
    }
}