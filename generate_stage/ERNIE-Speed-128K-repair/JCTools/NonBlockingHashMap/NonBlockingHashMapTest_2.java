package org.jctools.maps;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NonBlockingHashMapTest {

    @Test
    public void toStringTest() {
        NonBlockingHashMap<String, Integer> map = new NonBlockingHashMap<>();
        map.put("Key1", 1);
        map.put("Key2", 2);
        map.put("Key3", 3);
        String expected = "{Key1=1, Key2=2, Key3=3}";
        String actual = map.toString();
        assertEquals(expected, actual); // Assert that the toString representation matches the expected format
    }
}