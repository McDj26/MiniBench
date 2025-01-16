package org.jctools.maps;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;
import java.util.AbstractMap;

public class NonBlockingHashMapTest {
    @Test
    public void toStringTest() {
        NonBlockingHashMap<String, String> map = new NonBlockingHashMap<>();
        assertEquals("{}", map.toString(), "Empty map should be represented as '{}'");

        map.put("key1", "value1");
        assertEquals("{key1=value1}", map.toString(), "Single entry map should be represented correctly");

        map.put("key2", "value2");
        String representation = map.toString();
        boolean validRepresentation = representation.equals("{key1=value1, key2=value2}") || 
                                      representation.equals("{key2=value2, key1=value1}");
        assertTrue(validRepresentation, "The map with two entries should be correctly represented with the entries separated by ', '");
    }
}