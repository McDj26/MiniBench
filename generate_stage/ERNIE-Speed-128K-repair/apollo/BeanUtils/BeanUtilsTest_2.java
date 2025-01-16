package com.ctrip.framework.apollo.common.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.*;

class BeanUtilsTest {
    @Test
    public void mapByKeyTest() {
        // Arrange
        class UserDTO {
            private int userId; // This is the key we are going to use for mapping
            private String name;
            // Getters and setters are omitted for brevity
        }
        List<UserDTO> userList = new ArrayList<>();
        userList.add(new UserDTO(1, "Alice")); // Add some dummy data to the list
        userList.add(new UserDTO(2, "Bob"));
        userList.add(new UserDTO(3, "Charlie"));
        Map<Integer, UserDTO> expectedMap = new HashMap<>(); // Expected result map for comparison later
        expectedMap.put(1, userList.get(0)); // Populate the expected map with proper key-value pairs
        expectedMap.put(2, userList.get(1));
        expectedMap.put(3, userList.get(2));
        String key = "userId"; // The key to be used for mapping
        BeanUtils beanUtils = new BeanUtils(); // Instantiate the BeanUtils class to test the method
        Map<Integer, UserDTO> actualMap = beanUtils.mapByKey(key, userList); // Perform the actual mapping operation
        // Assert
        Assertions.assertNotNull(actualMap); // Ensure that the result map is not null
        Assertions.assertEquals(expectedMap, actualMap); // Ensure that the actual map matches the expected map in size and content
    }
}