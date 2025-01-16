import org.jfree.data.general.PieDataset;
import org.jfree.data.general.StandardPieDataset;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DatasetUtilsTest {
    
    @Test
    public void calculatePieDatasetTotalTest() {
        // Create a PieDataset with some data
        PieDataset dataset = new StandardPieDataset();
        dataset.setValue("Apple", 50);
        dataset.setValue("Banana", 70);
        dataset.setValue("Cherry", 30);
        dataset.setValue("Orange", 60);
        dataset.setValue("Grape", 80); // Positive value
        dataset.setValue("Negative", -20); // Negative value is ignored in the calculation
        dataset.setValue(null, null); // Null value is also ignored
        double total = DatasetUtils.calculatePieDatasetTotal(dataset);
        assertEquals(doubleValue(210), total); // The sum of Apple, Banana, Cherry, Orange, and Grape values is 210
    }
}