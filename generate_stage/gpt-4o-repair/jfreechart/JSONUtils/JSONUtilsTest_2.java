package org.jfree.data.json;

import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.KeyedValues;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JSONUtilsTest {

    @Test
    public void writeKeyedValuesTest() {
        // Arrange: create an instance of KeyedValues and add some test data
        KeyedValues data = new DefaultKeyedValues();
        data.addValue("Key A", 1.0);
        data.addValue("Key B", 2.0);

        // Act: call the method under test
        String json = JSONUtils.writeKeyedValues(data);
        
        // Assert: verify the expected outcome
        assertEquals("[[\"Key A\",1.0],[\"Key B\",2.0]]", json);
        
        // Edge case: testing with empty KeyedValues
        KeyedValues emptyData = new DefaultKeyedValues();
        String emptyJson = JSONUtils.writeKeyedValues(emptyData);
        assertEquals("[]", emptyJson);

        // Assert that a null data input throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            JSONUtils.writeKeyedValues(null);
        });
    }
}