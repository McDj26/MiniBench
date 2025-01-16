package com.ctrip.framework.apollo.common.utils;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

class UserDTO {
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

public class BeanUtilsTest {
    
    @Test
    public void mapByKeyTest() {
        // Test with a valid list of UserDTO objects and a valid key
        List<UserDTO> userList = Arrays.asList(
                new UserDTO(1, "Alice"),
                new UserDTO(2, "Bob"),
                new UserDTO(3, "Charlie")
        );

        Map<Integer, UserDTO> result = BeanUtils.mapByKey("userId", userList);
        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals("Alice", result.get(1).getName());
        assertEquals("Bob", result.get(2).getName());
        assertEquals("Charlie", result.get(3).getName());
        
        // Test with an empty list
        userList = Collections.emptyList();
        result = BeanUtils.mapByKey("userId", userList);
        assertNotNull(result);
        assertTrue(result.isEmpty());

        // Test with a null list
        result = BeanUtils.mapByKey("userId", null);
        assertNotNull(result);
        assertTrue(result.isEmpty());

        // Test with an invalid key
        Exception exception = assertThrows(BeanUtilsException.class, () -> {
            BeanUtils.mapByKey("invalidKey", userList);
        });

        String expectedMessage = "Could not find the key";
        String actualMessage = exception.getCause().getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}