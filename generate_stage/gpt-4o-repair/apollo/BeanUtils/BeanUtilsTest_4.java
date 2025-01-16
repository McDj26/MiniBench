package com.ctrip.framework.apollo.common.utils;

import com.ctrip.framework.apollo.common.exception.BeanUtilsException;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class BeanUtilsTest {

    public static class UserDTO {
        private Integer userId;
        private String name;

        public UserDTO(Integer userId, String name) {
            this.userId = userId;
            this.name = name;
        }
        
        public Integer getUserId() {
            return userId;
        }

        public String getName() {
            return name;
        }
    }

    @Test
    public void mapByKeyTest() {
        // Prepare test data
        UserDTO user1 = new UserDTO(1, "Alice");
        UserDTO user2 = new UserDTO(2, "Bob");
        List<UserDTO> userList = Arrays.asList(user1, user2);

        // Test valid mapping
        Map<Integer, UserDTO> result = BeanUtils.mapByKey("userId", userList);
        assertNotNull(result, "Resulting map should not be null");
        assertEquals(2, result.size(), "Map size should be 2");
        assertEquals(user1, result.get(1), "User with ID 1 should be Alice");
        assertEquals(user2, result.get(2), "User with ID 2 should be Bob");

        // Test empty list
        List<UserDTO> emptyList = Collections.emptyList();
        Map<Integer, UserDTO> emptyResult = BeanUtils.mapByKey("userId", emptyList);
        assertNotNull(emptyResult, "Resulting map should not be null");
        assertTrue(emptyResult.isEmpty(), "Resulting map should be empty");

        // Test key not found
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            BeanUtils.mapByKey("nonExistentKey", userList);
        });
        assertEquals("Could not find the key", exception.getMessage(), "Exception message should be 'Could not find the key'");

        // Test that BeanUtilsException is thrown for inaccessible fields
        try {
            // Private inner class to induce an access exception
            class PrivateUserDTO {
                private Integer userId;
                PrivateUserDTO(Integer userId) { this.userId = userId; }
            }
            List<PrivateUserDTO> privateUserList = Collections.singletonList(new PrivateUserDTO(3));

            BeanUtils.mapByKey("userId", privateUserList);
            fail("Expected BeanUtilsException due to inaccessible field");
        } catch (BeanUtilsException e) {
            // Expected exception
        }
    }
}