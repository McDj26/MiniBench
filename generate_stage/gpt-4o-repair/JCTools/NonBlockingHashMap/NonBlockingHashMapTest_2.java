package org.jctools.maps;

import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class NonBlockingHashMapTest {

    @Test
    public void toStringTest() {
        // Create a NonBlockingHashMap instance
        NonBlockingHashMap<String, String> map = new NonBlockingHashMap<>();

        // Verify that an empty map returns "{}"
        assertEquals("{}", map.toString());

        // Put some test data into the map
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        // Get the string representation and verify its correctness
        String mapStr = map.toString();
        
        // Check that the map's string has the basic format,
        // but allow flexibility in order due to unspecified ordering in entrySet().
        assertTrue(mapStr.startsWith("{") && mapStr.endsWith("}"));
        assertTrue(mapStr.contains("key1=value1"));
        assertTrue(mapStr.contains("key2=value2"));
        assertTrue(mapStr.contains("key3=value3"));

        // Remove an element and verify the string representation updates correctly
        map.remove("key2");
        mapStr = map.toString();
        
        // Ensure 'key2=value2' is removed
        assertFalse(mapStr.contains("key2=value2"));
    }
}