import org.junit.jupiter.api.*;
import org.jctools.maps.NonBlockingHashMap;
import java.util.*;

public class NonBlockingHashMapTest {
    private NonBlockingHashMap<String, Integer> map;

    @BeforeEach
    public void setUp() {
        map = new NonBlockingHashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
    }

    @Test
    public void toStringTest() {
        String expectedToStringResult = "{One=1, Two=2, Three=3}"; // Expected result for toString method with current map contents
        String actualToStringResult = map.toString(); // Call toString method on the map
        assertEquals(expectedToStringResult, actualToStringResult); // Assert that the expected result matches the actual result from toString method
    }
}