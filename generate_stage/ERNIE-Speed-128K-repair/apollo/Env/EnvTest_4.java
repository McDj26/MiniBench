package com.ctrip.framework.apollo.portal.environment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnvTest {
    @Test
    public void getWellFormNameTest() {
        String envName = " test "; // Test with leading and trailing spaces
        String expectedWellFormName = "TEST"; // Upper case and trimmed name
        String actualWellFormName = Env.getWellFormName(envName);
        assertEquals(expectedWellFormName, actualWellFormName); // Assert that the well formed name is as expected
        
        envName = "PROD"; // Test for production environment special case
        expectedWellFormName = Env.PRO.name; // Expected to be mapped to PRO environment name
        actualWellFormName = Env.getWellFormName(envName);
        assertEquals(expectedWellFormName, actualWellFormName); // Assert for PRO environment mapping
        
        envName = "FWS"; // Test for FAT mapping special case
        expectedWellFormName = Env.FAT.name; // Expected to be mapped to FAT environment name
        actualWellFormName = Env.getWellFormName(envName);
        assertEquals(expectedWellFormName, actualWellFormName); // Assert for FWS to FAT mapping
        
        envName = "some other environment name"; // Test for normal case
        expectedWellFormName = envName.trim().toUpperCase(); // Well formed name should be trimmed and upper case
        actualWellFormName = Env.getWellFormName(envName);
        assertEquals(expectedWellFormName, actualWellFormName); // Assert for normal case mapping
    }
}