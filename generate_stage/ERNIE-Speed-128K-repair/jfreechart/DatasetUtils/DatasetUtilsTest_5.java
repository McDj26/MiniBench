@Test
public void calculatePieDatasetTotalTest() {
    // Prepare a PieDataset for testing
    PieDataset pieDataset = new DefaultPieDataset();
    pieDataset.setValue("Item1", 25.5);
    pieDataset.setValue("Item2", 4);
    pieDataset.setValue("Item3", null); // Should be ignored
    pieDataset.setValue("Item4", 3); // Should be included in total
    pieDataset.setValue("Item5", -2); // Should be ignored due to negative value
    assertNotNull(pieDataset);
    assertNotEquals(0, DatasetUtils.calculatePieDatasetTotal(pieDataset)); // should be > 0
    assertEquals(32.5, DatasetUtils.calculatePieDatasetTotal(pieDataset), 0.0); // rounding issue in computation can occur
}