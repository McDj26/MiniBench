package org.jfree.data.json;

import org.junit.jupiter.api.*;
import org.jfree.data.KeyedValues;
import org.jfree.data.KeyedValuesImpl;
import static org.junit.jupiter.api.Assertions.*;

public class JSONUtilsTest {
    @Test
    public void writeKeyedValuesTest() {
        // Create a sample KeyedValues dataset
        KeyedValues data = new KeyedValuesImpl();
        data.addValue("Key A", 1.0);
        data.addValue("Key B", 2.0);
        data.addValue("Key C", 3.0);
        
        // Call the method to test and assert the result
        String jsonString = JSONUtils.writeKeyedValues(data);
        assertNotNull(jsonString); // Ensure the result is not null
        assertTrue(jsonString.contains("[\"Key A\", 1.0], [\"Key B\", 2.0], [\"Key C\", 3.0]")); // Assert the content of the JSON string matches the expected format
    }
}