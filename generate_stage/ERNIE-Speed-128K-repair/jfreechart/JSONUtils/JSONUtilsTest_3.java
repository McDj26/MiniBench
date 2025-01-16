package org.jfree.data.json;

import org.junit.jupiter.api.*;
import org.jfree.data.KeyedValues;
import org.jfree.data.KeyedValuesImpl;
import static org.junit.jupiter.api.Assertions.*;

public class JSONUtilsTest {
    @Test
    public void writeKeyedValuesTest() {
        // Prepare the data
        KeyedValues data = new KeyedValuesImpl();
        data.addValue("Key A", 1.0);
        data.addValue("Key B", 2.0);
        data.addValue("Key C", 3.0);
        
        // Call the method to test
        String jsonString = JSONUtils.writeKeyedValues(data);
        
        // Assert the results
        assertNotNull(jsonString, "The JSON string should not be null");
        assertTrue(jsonString.startsWith("[["), "The JSON string should start with [[");
        assertTrue(jsonString.endsWith("]]"), "The JSON string should end with ]]");
        assertTrue(jsonString.contains("{\"Key A\":1}"), "The JSON string should contain \"Key A\":1");
        assertTrue(jsonString.contains("{\"Key B\":2}"), "The JSON string should contain \"Key B\":2");
        assertTrue(jsonString.contains("{\"Key C\":3}"), "The JSON string should contain \"Key C\":3");
    }
}