import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.Point;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DetectorTest {
    @Test
    public void getMatrixCenterTest() {
        // Create a mock BitMatrix image
        BitMatrix image = new BitMatrix(100, 100); // Assuming the image size is 100x100
        // Set the image data as per your requirements (e.g., with a white rectangle in the center)
        // ... (Set the image data) ...
        
        // Create an instance of the Detector class using the mock image
        Detector detector = new Detector(image);
        
        // Call getMatrixCenter method and assert that a Point is returned
        Point centerPoint = detector.getMatrixCenter();
        assertNotNull(centerPoint);
        
        // Assert that the coordinates of the returned Point are within the expected range
        int centerX = centerPoint.getX();
        int centerY = centerPoint.getY();
        assertTrue(centerX >= 0 && centerX < image.getWidth());
        assertTrue(centerY >= 0 && centerY < image.getHeight());
        
        // You can further add assertions based on the specific behavior of getMatrixCenter method
        // For example, if you expect a specific center point or want to check the results against known values
    }
}