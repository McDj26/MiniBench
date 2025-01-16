package org.jfree.data.json;

import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.KeyedValues;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JSONUtilsTest {

    @Test
    public void writeKeyedValuesTest() {
        // Create an instance of KeyedValues with some test data
        DefaultKeyedValues values = new DefaultKeyedValues();
        values.addValue("Key A", 1.0);
        values.addValue("Key B", 2.0);

        // Convert the data to JSON format
        String jsonResult = JSONUtils.writeKeyedValues(values);

        // Expected JSON format string result
        String expectedJson = "[[\"Key A\", 1.0], [\"Key B\", 2.0]]";

        // Assert to check if the generated json string matches the expected format
        assertEquals(expectedJson, jsonResult);
    }

    @Test
    public void writeKeyedValuesWithNullDataTest() {
        // This will test passing null to the method, which should result in an exception
        assertThrows(IllegalArgumentException.class, () -> {
            JSONUtils.writeKeyedValues(null);
        });
    }
}