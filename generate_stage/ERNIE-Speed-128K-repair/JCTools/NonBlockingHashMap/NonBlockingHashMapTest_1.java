package org.jctools.maps;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NonBlockingHashMapTest {

    @Test
    public void toStringTest() {
        NonBlockingHashMap<String, Integer> map = new NonBlockingHashMap<>();
        // Insert some entries into the map
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("Four", 4);
        assertEquals("{}", map.toString()); // Empty map should return "{}"
        assertEquals("{Four=4, One=1, Two=2, Three=3}", map.toString()); // Non-empty map with entries in order
        map.clear(); // Clear the map
        assertEquals("{}", map.toString()); // After clearing, map should again return "{}"
    }
}