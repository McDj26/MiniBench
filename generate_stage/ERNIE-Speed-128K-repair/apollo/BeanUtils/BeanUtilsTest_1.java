package com.ctrip.framework.apollo.common.utils;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions;
import java.util.*;

public class BeanUtilsTest {
    @Test
    public void mapByKeyTest() {
        // Prepare a list of UserDTO objects with different userIds
        class UserDTO {
            private int userId;
            private String name;
            // getter and setter methods
            public int getUserId() { return userId; }
            public void setUserId(int userId) { this.userId = userId; }
            public String getName() { return name; }
            public void setName(String name) { this.name = name; }
        }
        List<UserDTO> userList = new ArrayList<>();
        userList.add(new UserDTO()); // Assume the UserDTO is correctly instantiated with proper fields set
        userList.add(new UserDTO()); // Add more instances to the list if needed
        Map<Integer, UserDTO> userIdToUserMap = BeanUtils.mapByKey("userId", userList); // call the method with key "userId"
        assertNotNull(userIdToUserMap); // Assert that the map is not null
        assertFalse(userIdToUserMap.isEmpty()); // Assert that the map is not empty
        for (Map.Entry<Integer, UserDTO> entry : userIdToUserMap.entrySet()) { // Iterate through the map entries to verify results
            UserDTO user = entry.getValue();
            assertEquals(entry.getKey(), user.getUserId()); // Verify that the key in the map is the same as the userId in the UserDTO object
        }
    }
}