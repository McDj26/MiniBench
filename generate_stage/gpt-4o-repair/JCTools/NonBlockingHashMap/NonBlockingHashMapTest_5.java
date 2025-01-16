package org.jctools.maps;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.AbstractMap;
import java.util.Map;

public class NonBlockingHashMapTest {

    @Test
    public void toStringTest() {
        NonBlockingHashMap<String, String> map = new NonBlockingHashMap<>();
        
        // Test with empty map
        assertEquals("{}", map.toString(), "Empty map should return {}");

        // Test with one key-value pair
        map.put("key1", "value1");
        assertEquals("{key1=value1}", map.toString(), "Single pair map should return {key1=value1}");
        
        // Test with multiple key-value pairs
        map.put("key2", "value2");
        map.put("key3", "value3");
        String result = map.toString();
        assertTrue(
            result.contains("{key1=value1, key2=value2, key3=value3}") || 
            result.contains("{key1=value1, key3=value3, key2=value2}") ||
            result.contains("{key2=value2, key1=value1, key3=value3}") ||
            result.contains("{key2=value2, key3=value3, key1=value1}") ||
            result.contains("{key3=value3, key1=value1, key2=value2}") ||
            result.contains("{key3=value3, key2=value2, key1=value1}"),
            "Multi pair map should contain all key-value pairs"
        );

        // Test with special conditions like self-reference, if applicable
        map.put("self", map.toString());
        String selfResult = map.toString();
        assertTrue(
            selfResult.contains("(this Map)"),
            "Map containing itself as a value should print '(this Map)'"
        );
    }
}