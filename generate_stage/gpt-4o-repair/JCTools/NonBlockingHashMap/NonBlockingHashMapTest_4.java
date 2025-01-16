package org.jctools.maps;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;
import java.util.Set;

public class NonBlockingHashMapTest {

    NonBlockingHashMap<String, Integer> map;

    @BeforeEach
    public void setUp() {
        map = new NonBlockingHashMap<>();
    }

    @Test
    public void toStringTest() {
        assertEquals("{}", map.toString(), "Expected empty map toString to be '{}'");

        map.put("one", 1);
        assertEquals("{one=1}", map.toString(), "Expected toString to reflect single entry");

        map.put("two", 2);
        map.put("three", 3);
        String result = map.toString();
        
        // Since entrySet returns a set which is unordered, we have to check for both orders
        assertTrue(result.equals("{one=1, two=2, three=3}") || result.equals("{two=2, one=1, three=3}") || 
                   result.equals("{one=1, three=3, two=2}") || result.equals("{three=3, one=1, two=2}") ||
                   result.equals("{two=2, three=3, one=1}") || result.equals("{three=3, two=2, one=1}"),
                   "Expected toString to reflect all entries in map");
    }
}