package org.jfree.data.json;

import org.jfree.data.KeyedValues;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

public class JSONUtilsTest {

    @Test
    public void writeKeyedValuesTest() {
        // Create a mock implementation of the KeyedValues interface
        KeyedValues data = new KeyedValues() {
            @Override
            public int getItemCount() {
                return 2;
            }
            
            @Override
            public Number getValue(int index) {
                return index == 0 ? 1.0 : 2.0;
            }
            
            @Override
            public Comparable getKey(int index) {
                return index == 0 ? "Key A" : "Key B";
            }

            @Override
            public int getIndex(Comparable key) {
                return key.equals("Key A") ? 0 : 1;
            }

            @Override
            public List getKeys() {
                return Arrays.asList("Key A", "Key B");
            }

            @Override
            public Number getValue(Comparable key) {
                return key.equals("Key A") ? 1.0 : 2.0;
            }
        };

        // Call the method under test
        String jsonOutput = JSONUtils.writeKeyedValues(data);

        // Assert that the output is as expected
        assertEquals("[[\"Key A\", 1.0], [\"Key B\", 2.0]]", jsonOutput);
    }
}