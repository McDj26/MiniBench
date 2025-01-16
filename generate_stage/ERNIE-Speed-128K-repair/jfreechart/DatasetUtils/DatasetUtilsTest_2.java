package org.jfree.data.general;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DatasetUtilsTest {

    @Test
    public void calculatePieDatasetTotalTest() {
        PieDataset pieDataset = createPieDataset(); // Assuming a method to create a PieDataset instance exists in the same class or another class
        double total = DatasetUtils.calculatePieDatasetTotal(pieDataset);
        assertNotNull(pieDataset);
        assertEquals(Double.valueOf(100), total); // Assuming the sum of the dataset is 100 (considering non-negative values)
    }

    private PieDataset createPieDataset() {
        // Create a PieDataset with values that sum up to 100 for the test case. This is a placeholder for your actual dataset creation logic.
        // This is just an example and should be replaced with actual data.
        PieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Apple", 50);
        dataset.setValue("Banana", 30);
        dataset.setValue("Cherry", 20); // This is a positive value, so it will be included in the total calculation
        // You can add more entries to the dataset as needed
        return dataset;
    }
}