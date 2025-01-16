package com.ctrip.framework.apollo.common.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class BeanUtilsTest {
    @Test
    public void mapByKeyTest() {
        // Arrange
        class UserDTO {
            private int userId; // User DTO's property
            // constructor, getters and setters omitted for brevity
        }
        List<UserDTO> userList = new ArrayList<>(); // Assume this list is populated with UserDTO instances
        Map<Integer, UserDTO> expectedMap = new HashMap<>(); // Expected map to store userId as key and UserDTO as value
        // Populate the list and map with test data
        //...
        String key = "userId"; // Property name to map by
        BeanUtils beanUtils = new BeanUtils(); // Instantiate BeanUtils if necessary (though not required for this method)
        Map<Integer, UserDTO> actualMap = null; // Variable to store the actual result map

        // Act
        actualMap = beanUtils.mapByKey(key, userList); // Call the method to test

        // Assert
        assertNotNull(actualMap); // Assert that the map is not null
        assertEquals(expectedMap.size(), actualMap.size()); // Assert that the size of the map is as expected
        for (Map.Entry<Integer, UserDTO> entry : actualMap.entrySet()) { // Iterate through the map entries
            Integer userId = entry.getKey(); // Get the key from the entry
            UserDTO userDTO = entry.getValue(); // Get the value (UserDTO) from the entry
            assertTrue(expectedMap.containsKey(userId)); // Assert that the userId exists in the expected map as a key
            assertSame(expectedMap.get(userId), userDTO); // Assert that the UserDTO in actual map matches that in expected map for the given userId
        }
    }
}