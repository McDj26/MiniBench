package org.jctools.maps;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NonBlockingHashMapTest {

    @Test
    public void toStringTest() {
        NonBlockingHashMap<String, Integer> map = new NonBlockingHashMap<>();
        // Test the toString method with an empty map
        assertEquals("{}", map.toString());
        
        // Insert some entries into the map
        map.put("Key1", 1);
        map.put("Key2", 2);
        map.put("Key3", 3);
        
        // Test the toString method with a map containing entries
        assertEquals("{Key1=1, Key2=2, Key3=3}", map.toString());
        
        // Perform more complex tests with different types of keys and values
        // to ensure toString method handles them correctly
        map.put(new Object(), null); // test null value
        map.put("self reference key", map); // test self reference in key or value
        String complexKey = new StringBuilder().append("complex").append(System.currentTimeMillis()).toString(); // some complex key
        map.put(complexKey, complexKey); // test complex key and value that are equal to each other
        assertEquals("{Key1=1, Key2=2, Key3=3, null=null, self reference key=<this Map>, " + complexKey + "=" + complexKey + "}", map.toString()); // should reflect the added entries correctly with their types and values
    }
}