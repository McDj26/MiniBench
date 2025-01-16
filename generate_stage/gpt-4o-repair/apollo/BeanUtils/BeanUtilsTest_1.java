package com.ctrip.framework.apollo.common.utils;

import com.ctrip.framework.apollo.common.exception.BeanUtilsException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        List<UserDTO> userList = new ArrayList<>();
        userList.add(new UserDTO(1, "Alice"));
        userList.add(new UserDTO(2, "Bob"));
        userList.add(new UserDTO(3, "Carol"));

        // Test normal case
        Map<Integer, UserDTO> userMap = BeanUtils.mapByKey("userId", userList);
        assertEquals(3, userMap.size());
        assertEquals("Alice", userMap.get(1).getName());
        assertEquals("Bob", userMap.get(2).getName());
        assertEquals("Carol", userMap.get(3).getName());

        // Test empty list
        List<UserDTO> emptyList = new ArrayList<>();
        Map<Integer, UserDTO> emptyMap = BeanUtils.mapByKey("userId", emptyList);
        assertTrue(emptyMap.isEmpty());

        // Test invalid key
        Exception exception = assertThrows(BeanUtilsException.class, () -> {
            BeanUtils.mapByKey("invalidKey", userList);
        });
        assertEquals("Could not find the key", exception.getCause().getMessage());

        // Test null list
        Map<Integer, UserDTO> nullMap = BeanUtils.mapByKey("userId", null);
        assertTrue(nullMap.isEmpty());
    }
}