package org.jctools.maps;

import org.junit.jupiter.api.*;
import java.util.AbstractMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class NonBlockingHashMapTest {

    @Test
    public void toStringTest() {
        NonBlockingHashMap<String, String> map = new NonBlockingHashMap<>();
        
        // Test for empty map
        assertEquals("{}", map.toString());

        // Test with one entry
        map.put("key1", "value1");
        assertEquals("{key1=value1}", map.toString());

        // Test with multiple entries
        map.put("key2", "value2");
        map.put("key3", "value3");
        String result = map.toString();
        // Since the order is not guaranteed, we check the length and presence of keys and values
        assertTrue(result.startsWith("{") && result.endsWith("}"));
        assertTrue(result.contains("key1=value1"));
        assertTrue(result.contains("key2=value2"));
        assertTrue(result.contains("key3=value3"));
        
        // Check that entries are separated by comma and space
        assertTrue(result.contains(", "));

        // Edge case test: adding map to itself
        map.put("self", map);
        result = map.toString();
        assertTrue(result.contains("self=(this Map)"));
    }
}