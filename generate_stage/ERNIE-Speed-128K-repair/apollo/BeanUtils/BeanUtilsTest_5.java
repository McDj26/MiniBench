package com.ctrip.framework.apollo.common.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.*;

public class BeanUtilsTest {
    @Test
    public void mapByKeyTest() {
        // Arrange
        List<UserDTO> userDTOList = new ArrayList<>();
        UserDTO userDTO1 = new UserDTO();
        userDTO1.setId(1); // Assuming UserDTO has an id field
        userDTO1.setName("Alice"); // Assuming UserDTO has a name field
        userDTOList.add(userDTO1);
        UserDTO userDTO2 = new UserDTO(); // Add another user with different id and name
        userDTOList.add(userDTO2); // Assuming the second user has different id and name
        Map<Integer, UserDTO> userIdToUserMap = BeanUtils.mapByKey("id", userDTOList); // Use id as key for mapping
        int expectedSize = 2; // Expecting two entries in the map
        Integer expectedUserId = 1; // Assuming the first user's id is 1
        Integer userIdForLookup = expectedUserId; // Will use this variable to retrieve the user from the map later
        String expectedUserName = "Alice"; // Assuming the first user's name is Alice
        UserDTO expectedUser; // Expected user object for comparison after retrieving from map
        UserDTO actualUser; // Actual user object retrieved from the map
        // Act & Assert
        Assertions.assertNotNull(userIdToUserMap); // Map should not be null
        Assertions.assertEquals(expectedSize, userIdToUserMap.size()); // Map size should be equal to the number of users in the list
        Assertions.assertTrue(userIdToUserMap.containsKey(userIdForLookup)); // Map should contain the expected user id as key
        expectedUser = userIdToUserMap.get(userIdForLookup); // Get the expected user object from the map using id as key
        Assertions.assertNotNull(expectedUser); // Expected user object should not be null
        Assertions.assertEquals(expectedUserName, expectedUser.getName()); // Assert that the name in the retrieved user object is correct
    }
}