package com.ctrip.framework.apollo.portal.environment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnvTest {
    @Test
    public void getWellFormNameTest() {
        String envName = "  DEV  "; // Test with leading and trailing spaces
        String expectedWellFormName = "DEV"; // Trimmed and upper case
        String actualWellFormName = Env.getWellFormName(envName);
        assertEquals(expectedWellFormName, actualWellFormName, "The well-formed name should be 'DEV'");
        
        envName = "PROD"; // Test for the special case of production
        expectedWellFormName = Env.PRO.name; // It should return the well-formed name of the PRO environment
        actualWellFormName = Env.getWellFormName(envName);
        assertEquals(expectedWellFormName, actualWellFormName, "The well-formed name for 'PROD' should be mapped to PRO");
        
        envName = "FWS"; // Test for the special case of FWS mapping to FAT
        expectedWellFormName = Env.FAT.name; // It should return the well-formed name of the FAT environment
        actualWellFormName = Env.getWellFormName(envName);
        assertEquals(expectedWellFormName, actualWellFormName, "The well-formed name for 'FWS' should be mapped to FAT");
        
        envName = "randomstring"; // Test for a regular case that does not have any special mapping
        expectedWellFormName = envName.trim().toUpperCase(); // Trimmed and upper case
        actualWellFormName = Env.getWellFormName(envName);
        assertEquals(expectedWellFormName, actualWellFormName, "The well-formed name for a regular string should be trimmed and upper case");
        
        envName = ""; // Test for an empty string
        actualWellFormName = Env.getWellFormName(envName);
        assertTrue(actualWellFormName.isEmpty(), "The well-formed name for an empty string should be an empty string");
    }
}