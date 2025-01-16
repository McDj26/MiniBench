import org.jfree.data.general.DatasetUtils;
import org.jfree.data.general.PieDataset;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.List;

public class DatasetUtilsTest {

    @Test
    public void calculatePieDatasetTotalTest() {
        // Create a mock PieDataset
        PieDataset dataset = Mockito.mock(PieDataset.class);
        
        // Mock the getKeys method to return a list of keys
        List<Comparable> keys = Arrays.asList("A", "B", "C", "D");
        Mockito.when(dataset.getKeys()).thenReturn(keys);
        
        // Mock the getValue method to return values for each key
        Mockito.when(dataset.getValue("A")).thenReturn(10.0);
        Mockito.when(dataset.getValue("B")).thenReturn(-5.0); // negative value
        Mockito.when(dataset.getValue("C")).thenReturn(null);  // null value
        Mockito.when(dataset.getValue("D")).thenReturn(15.0);
        
        // Calculate the total using the method
        double result = DatasetUtils.calculatePieDatasetTotal(dataset);
        
        // Verify the result is the sum of positive values only
        assertEquals(25.0, result, 0.0001);
        
        // Test with all null values
        Mockito.when(dataset.getValue("A")).thenReturn(null);
        Mockito.when(dataset.getValue("B")).thenReturn(null);
        Mockito.when(dataset.getValue("C")).thenReturn(null);
        Mockito.when(dataset.getValue("D")).thenReturn(null);
        
        result = DatasetUtils.calculatePieDatasetTotal(dataset);
        
        // Verify the result is 0.0
        assertEquals(0.0, result, 0.0001);
        
        // Test with all positive values
        Mockito.when(dataset.getValue("A")).thenReturn(5.0);
        Mockito.when(dataset.getValue("B")).thenReturn(15.0);
        Mockito.when(dataset.getValue("C")).thenReturn(10.0);
        Mockito.when(dataset.getValue("D")).thenReturn(20.0);
        
        result = DatasetUtils.calculatePieDatasetTotal(dataset);
        
        // Verify the result is the sum of all values
        assertEquals(50.0, result, 0.0001);
    }
}