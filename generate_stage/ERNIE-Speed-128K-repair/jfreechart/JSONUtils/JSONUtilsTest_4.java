package org.jfree.data.json;

import org.junit.jupiter.api.*;
import org.jfree.data.KeyedValues;
import org.jfree.data.general.PieDataset;
import org.junit.Assert;
import static org.junit.Assert.*;
import java.util.*;

public class JSONUtilsTest {
    @Test
    public void writeKeyedValuesTest() {
        // Arrange
        KeyedValues data = new PieDataset(); // Assuming PieDataset is a subclass of KeyedValues with keys and values set correctly
        Map<String, Double> valuesMap = new HashMap<>(); // Assuming this is the data structure for the PieDataset's values
        valuesMap.put("Key A", 1.0); // Assuming these are valid key-value pairs for the dataset
        valuesMap.put("Key B", 2.0);
        data.addValues(valuesMap); // Assuming this is the correct way to add values to PieDataset or KeyedValues
        String expectedJson = "[\"Key A\", 1.0], [\"Key B\", 2.0]"; // Expected JSON format based on the provided example format
        String expectedResult = "[" + expectedJson + "]"; // Expect the entire dataset to be wrapped in a JSON array for proper format
        String actualResult = JSONUtils.writeKeyedValues(data); // Call the method to test
        System.out.println("Actual result: " + actualResult); // Used for debug only
        System.out.println("Expected result: " + expectedResult); // Used for debug only
        // Assert
        assertNotNull(actualResult); // Ensure the result is not null
        assertTrue(actualResult.contains("[\"Key A\", 1")); // Assert that the JSON contains at least one key-value pair (partial match)
        assertTrue(actualResult.contains(", [\"")); // Assert that the format is as expected, with a comma separating key-value pairs and wrapping in square brackets
        assertEquals(expectedResult, actualResult); // Assert that the actual result matches the expected result (which should be formatted as specified in the documentation)
    }
}