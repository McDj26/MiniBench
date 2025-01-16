import org.junit.jupiter.api.*;
import org.jctools.maps.NonBlockingHashMap;
import static org.junit.jupiter.api.Assertions.*;

public class NonBlockingHashMapTest {
    @Test
    public void toStringTest() {
        NonBlockingHashMap<String, Integer> map = new NonBlockingHashMap<>();
        map.put("Key1", 1);
        map.put("Key2", 2);
        String expectedToString = "{Key1=1, Key2=2}"; // Expected string representation of the map
        assertEquals(expectedToString, map.toString()); // Assert that the actual toString() result matches the expected string
    }
}