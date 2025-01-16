package com.ctrip.framework.apollo.common.utils;

import com.ctrip.framework.apollo.common.exception.BeanUtilsException;
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
        // Prepare test data
        List<UserDTO> userList = new ArrayList<>();
        userList.add(new UserDTO(1, "Alice"));
        userList.add(new UserDTO(2, "Bob"));
        userList.add(new UserDTO(3, "Charlie"));
        
        // Expected map
        Map<Integer, UserDTO> expectedMap = new HashMap<>();
        expectedMap.put(1, new UserDTO(1, "Alice"));
        expectedMap.put(2, new UserDTO(2, "Bob"));
        expectedMap.put(3, new UserDTO(3, "Charlie"));

        // Execute the method
        Map<Integer, UserDTO> actualMap = BeanUtils.mapByKey("userId", userList);

        // Assert the map is correct
        assertEquals(expectedMap.size(), actualMap.size());

        for (Map.Entry<Integer, UserDTO> entry : expectedMap.entrySet()) {
            assertTrue(actualMap.containsKey(entry.getKey()));
            assertEquals(entry.getValue().getName(), actualMap.get(entry.getKey()).getName());
        }

        // Test with an empty list
        List<UserDTO> emptyList = Collections.emptyList();
        Map<Integer, UserDTO> emptyMap = BeanUtils.mapByKey("userId", emptyList);
        assertTrue(emptyMap.isEmpty());

        // Test with non-existing key
        Exception exception = assertThrows(BeanUtilsException.class, () ->
                BeanUtils.mapByKey("nonExistingKey", userList));
        assertEquals("com.ctrip.framework.apollo.common.exception.BeanUtilsException", exception.getClass().getName());
    }
}