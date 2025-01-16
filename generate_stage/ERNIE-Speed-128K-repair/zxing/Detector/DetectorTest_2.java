import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DetectorTest {
    @Test
    public void getMatrixCenterTest() {
        // Create a mock BitMatrix image for testing
        BitMatrix image = // ... initialize with a sample image or known image data;
        
        // Create an instance of the Detector class using the mock image
        Detector detector = new Detector(image);
        
        // Call the getMatrixCenter method and store the result
        Point center = detector.getMatrixCenter();
        
        // Test case: White rectangle is found successfully
        // Expected center coordinates (x, y) can be calculated based on the image dimensions and rectangle position
        int expectedX = /* expected X coordinate */;
        int expectedY = /* expected Y coordinate */;
        assertEquals(expectedX, center.getX(), "The X coordinate of the center should match the expected value.");
        assertEquals(expectedY, center.getY(), "The Y coordinate of the center should match the expected value.");
        
        // Test case: White rectangle is not found (exception handling)
        // You can simulate this by modifying the image data to trigger the exception in getMatrixCenter method
        // Then assert that an exception is thrown or handle the exception and assert its behavior
    }
}