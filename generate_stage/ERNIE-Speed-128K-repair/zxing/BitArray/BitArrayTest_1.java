import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BitArrayTest {
    @Test
    public void getNextSetTest() {
        BitArray bitArray = new BitArray(32); // Initialize with a size of 32 bits
        
        // Set some bits to test the getNextSet method
        bitArray.set(0); // Set the first bit
        bitArray.set(7); // Set the eighth bit
        bitArray.set(16); // Set the sixteenth bit
        
        // Test getNextSet with different starting indices
        assertEquals(0, bitArray.getNextSet(0)); // First set bit is at index 0
        assertEquals(7, bitArray.getNextSet(1)); // Next set bit after the first one is at index 7
        assertEquals(16, bitArray.getNextSet(8)); // Next set bit after the second one is at index 16
        assertEquals(32, bitArray.getNextSet(31)); // No more set bits after index 31, so return the size of the BitArray
        assertEquals(-1, bitArray.getNextSet(Integer.MAX_VALUE)); // Test with an invalid index (out of bounds)
        
        // Test getNextSet with all bits set
        bitArray.setRange(0, 32); // Set all bits to 1
        assertEquals(0, bitArray.getNextSet(0)); // All bits are set, so it should return the size of the BitArray
    }
}