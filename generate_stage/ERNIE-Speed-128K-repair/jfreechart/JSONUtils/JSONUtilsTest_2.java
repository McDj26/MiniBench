package org.jfree.data.json;

import org.junit.jupiter.api.*;
import org.jfree.data.KeyedValues;
import org.jfree.data.KeyedValuesImpl;
import static org.junit.jupiter.api.Assertions.*;

public class JSONUtilsTest {

    @Test
    public void writeKeyedValuesTest() {
        // Create a simple KeyedValues dataset
        KeyedValues data = new KeyedValuesImpl();
        data.addValue("Key A", 1.0); // Add a single entry with key "Key A" and value 1.0
        String expectedJson = "[[\"Key A\", 1.0]]"; // Expected JSON output for this dataset
        String actualJson = JSONUtils.writeKeyedValues(data); // Call the method to test
        assertEquals(expectedJson, actualJson); // Assert that the actual JSON matches the expected output
    }
}