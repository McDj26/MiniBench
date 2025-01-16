package com.ctrip.framework.apollo.common.utils;

import com.ctrip.framework.apollo.common.exception.BeanUtilsException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BeanUtilsTest {

    static class UserDTO {
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
        userList.add(new UserDTO(3, "Charlie"));

        // Test mapByKey
        Map<Integer, UserDTO> userIdToUser = BeanUtils.mapByKey("userId", userList);

        // Validate the results
        assertNotNull(userIdToUser);
        assertEquals(3, userIdToUser.size());
        assertEquals("Alice", userIdToUser.get(1).getName());
        assertEquals("Bob", userIdToUser.get(2).getName());
        assertEquals("Charlie", userIdToUser.get(3).getName());

        // Test empty list input
        List<UserDTO> emptyList = new ArrayList<>();
        Map<Integer, UserDTO> emptyMap = BeanUtils.mapByKey("userId", emptyList);
        assertNotNull(emptyMap);
        assertTrue(emptyMap.isEmpty());

        // Test error conditions, e.g., invalid key
        Exception exception = assertThrows(BeanUtilsException.class, () -> {
            BeanUtils.mapByKey("invalidKey", userList);
        });
        assertTrue(exception.getCause() instanceof IllegalArgumentException);
        assertEquals("Could not find the key", exception.getCause().getMessage());
    }
}