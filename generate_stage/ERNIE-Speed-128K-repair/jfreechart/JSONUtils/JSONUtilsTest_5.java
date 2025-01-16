package org.jfree.data.json;

import org.junit.jupiter.api.*;
import org.jfree.data.KeyedValues;
import org.jfree.data.KeyedValuesImpl;
import static org.junit.jupiter.api.Assertions.*;

public class JSONUtilsTest {

    @Test
    public void writeKeyedValuesTest() {
        // Arrange
        KeyedValues data = new KeyedValuesImpl();
        data.addValue("Key A", 1.0);
        data.addValue("Key B", 2.0);
        String expectedJSON = "[\"Key A\", 1.0, \"Key B\", 2.0]"; // Expected JSON format for the data
        String actualJSON = JSONUtils.writeKeyedValues(data); // Call the method to test
        assertNotNull(actualJSON); // Assert that the result is not null
        assertFalse(actualJSON.isEmpty()); // Assert that the result is not empty
        assertTrue(actualJSON.contains("[\"Key A\", 1.0, \"Key B\", 2.0]")); // Assert that the JSON format is correct with both keys and values
        assertEquals(expectedJSON, actualJSON); // Assert that the actual JSON matches the expected JSON format for the data
    }
}