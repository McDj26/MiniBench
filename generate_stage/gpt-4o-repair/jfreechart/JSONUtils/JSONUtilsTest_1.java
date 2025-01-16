package org.jfree.data.json;

import org.jfree.data.KeyedValues;
import org.jfree.data.DefaultKeyedValues;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JSONUtilsTest {

    @Test
    public void writeKeyedValuesTest() {
        // Create a DefaultKeyedValues instance and populate it with some sample data
        DefaultKeyedValues data = new DefaultKeyedValues();
        data.addValue("Key A", 1.0);
        data.addValue("Key B", 2.0);
        
        // Expected JSON output
        String expectedJson = "[[\"Key A\",1.0],[\"Key B\",2.0]]";
        
        // Call the method to test
        String jsonResult = JSONUtils.writeKeyedValues(data);
        
        // Assert that the generated JSON matches the expected output
        assertEquals(expectedJson, jsonResult);
    }

    @Test
    public void writeKeyedValuesTest_NullData() {
        // Verify that a null argument causes an IllegalArgumentException
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            JSONUtils.writeKeyedValues(null);
        });

        // Assert that the exception message is as expected
        String expectedMessage = "Null 'data' argument.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}