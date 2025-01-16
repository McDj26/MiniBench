package org.jfree.data.general;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class SeriesTest {
    
    @Test
    public void equalsTest() {
        Series series1 = new Series("Key1");
        Series series2 = new Series("Key2");
        Series series3 = new Series("Key1", "Description"); // Different key but same description
        Series series4 = new Series("Key1"); // Same key as series1
        Series series5 = new Series("Key1", null); // Different description but same key as series1
        Series series6 = new Series("Key1", "Description"); // Same key and description as series3 but different instances
        
        // Testing equality with null
        assertFalse(series1.equals(null));
        assertFalse(series2.equals(null));
        assertFalse(series3.equals(null));
        assertFalse(series4.equals(null)); // Assuming equals method considers instance reference too
        assertFalse(series5.equals(null)); // Assuming equals method considers instance reference too
        assertFalse(series6.equals(null)); // Assuming equals method considers instance reference too
        
        // Testing equality with other objects of different types
        assertFalse(series1.equals("String")); // Not an instance of Series
        assertFalse(series2.equals("String")); // Not an instance of Series
        assertFalse(series3.equals("String")); // Not an instance of Series, different key too
        assertFalse(series4.equals("String")); // Not an instance of Series, assumes keys matter in equals comparison
        assertFalse(series5.equals("String")); // Not an instance of Series, assumes keys matter in equals comparison despite different description
        assertFalse(series6.equals("String")); // Not an instance of Series, different instances with different keys but same description, assumes keys matter in equals comparison as per provided logic of equals method implementation (whether this assumption is correct or not depends on actual implementation)
        assertFalse(series4.equals(new Object())); // Not an instance of Series, assumes keys matter in equals comparison as per provided logic of equals method implementation (whether this assumption is correct or not depends on actual implementation)
        assertTrue(series4.equals(series5)); // Testing with an object that has different description but same key, assuming equals method considers both key and description in comparison (whether this assumption is correct or not depends on actual implementation)
        assertTrue(series4.equals(series6)); // Testing with an object that has same key and description but different instances, assuming equals method considers both key and description in comparison as per provided logic of equals method implementation (whether this assumption is correct or not depends on actual implementation) 
    }
}