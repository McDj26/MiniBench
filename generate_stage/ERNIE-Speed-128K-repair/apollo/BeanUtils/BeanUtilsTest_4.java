package com.ctrip.framework.apollo.common.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class BeanUtilsTest {
    @Test
    public void mapByKeyTest() {
        // Arrange: Prepare for test data and configurations
        class TestDTO {
            private int userId; // Assume this is the key field for mapping
            private String name; // Other field in DTO
            // Getters and setters are omitted for brevity
        }
        List<TestDTO> testDTOList = new ArrayList<>();
        testDTOList.add(new TestDTO(1, "Alice")); // Add some test data to the list
        testDTOList.add(new TestDTO(2, "Bob"));
        Map<Integer, TestDTO> expectedMap = new HashMap<>(); // Expected map for comparison
        expectedMap.put(1, testDTOList.get(0)); // Populate the expected map with test data
        expectedMap.put(2, testDTOList.get(1));
        String key = "userId"; // The key field to be used for mapping
        BeanUtils beanUtils = new BeanUtils(); // Instance of BeanUtils class
        
        // Act: Perform the action to be tested by calling the method mapByKey with given parameters
        Map<Integer, TestDTO> actualMap = beanUtils.mapByKey(key, testDTOList); 
        
        // Assert: Compare the actual result with expected result
        assertEquals(expectedMap, actualMap); // Assert that the actual map is equal to the expected map
    }
}