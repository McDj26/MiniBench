package org.jfree.data.json;

import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.KeyedValues;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JSONUtilsTest {

    @Test
    public void writeKeyedValuesTest() {
        // Creating a DefaultKeyedValues instance to mock KeyedValues
        KeyedValues data = new DefaultKeyedValues();
        data.addValue("Key A", 1.0);
        data.addValue("Key B", 2.0);

        // Expected JSON format output
        String expectedJson = "[[\"Key A\",1.0],[\"Key B\",2.0]]";

        // Invoke the method to test
        String resultJson = JSONUtils.writeKeyedValues(data);

        // Assert that the output is as expected
        assertEquals(expectedJson, resultJson);
    }
}