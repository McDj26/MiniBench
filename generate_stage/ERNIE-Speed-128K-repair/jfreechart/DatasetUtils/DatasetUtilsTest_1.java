package org.jfree.data.general;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.jfree.data.general.PieDataset;
import org.jfree.data.general.StandardPieDataset;

public class DatasetUtilsTest {
    
    @Test
    public void calculatePieDatasetTotalTest() {
        // Create a PieDataset with values to calculate total
        PieDataset dataset = new StandardPieDataset();
        dataset.setValue("Apple", 50);
        dataset.setValue("Banana", 30);
        dataset.setValue("Cherry", 20);
        double total = DatasetUtils.calculatePieDatasetTotal(dataset);
        assertEquals(100, total, 0.0); // Assert that the total is correct
    }
    
    @Test
    public void calculatePieDatasetTotalWithNegativeValuesTest() {
        // Create a PieDataset with negative values to test if they are ignored
        PieDataset dataset = new StandardPieDataset();
        dataset.setValue("Apple", 50);
        dataset.setValue("Banana", -20); // Negative value should be ignored
        dataset.setValue("Cherry", 30); // Non-null value should be included in total calculation
        double total = DatasetUtils.calculatePieDatasetTotal(dataset);
        assertEquals(80, total, 0.0); // Assert that the negative value is ignored and only positive values are summed up
    }
    
    @Test
    public void calculatePieDatasetTotalWithNullValueTest() {
        // Create a PieDataset with null values to test if they are ignored correctly
        PieDataset dataset = new StandardPieDataset();
        dataset.setValue("Apple", null); // Null value should be ignored in calculation of total
        dataset.setValue("Banana", 50); // Non-null value should be included in total calculation
        double total = DatasetUtils.calculatePieDatasetTotal(dataset);
        assertEquals(50, total, 0.0); // Assert that the null value is ignored and only non-null values are summed up
    }
    
    @Test
    public void calculatePieDatasetTotalEmptyDatasetTest() {
        // Test calculatePieDatasetTotal with an empty dataset (should return 0)
        PieDataset dataset = new StandardPieDataset(); // Empty dataset with no values added to it yet
        double total = DatasetUtils.calculatePieDatasetTotal(dataset); // Call method with empty dataset
        assertEquals(0, total, 0.0); // Assert that the total is zero for an empty dataset as expected since there are no values to sum up
    }
}