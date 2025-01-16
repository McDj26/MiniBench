package com.ctrip.framework.apollo.portal.environment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnvTest {
    @Test
    public void getWellFormNameTest() {
        // Case for blank input
        String blankEnvName = "";
        String result = Env.getWellFormName(blankEnvName);
        assertTrue(result.isEmpty()); // Expecting an empty string for blank input

        // Case for null input
        String nullEnvName = null;
        assertThrows(NullPointerException.class, () -> Env.getWellFormName(nullEnvName)); // Expecting NullPointerException for null input

        // Case for normal input with leading/trailing spaces and non-uppercase characters
        String spacedEnvName = " dev ";
        String expectedNormalEnvName = "DEV"; // Trimmed and converted to uppercase
        String resultNormalEnvName = Env.getWellFormName(spacedEnvName);
        assertEquals(expectedNormalEnvName, resultNormalEnvName); // Expecting the trimmed and uppercased version of the input string

        // Case for PRO environment name
        String proEnvName = "PROD"; // PRO is a special case in the method, it should be mapped to Env.PRO name which is not PROD itself
        String expectedProEnvName = Env.PRO.name; // The actual name of PRO environment in the Env class
        String resultProEnvName = Env.getWellFormName(proEnvName);
        assertEquals(expectedProEnvName, resultProEnvName); // Expecting the well-formed name to be the actual name of PRO environment in the Env class

        // Case for FWS which should be mapped to FAT environment in the code logic
        String fwsEnvName = "FWS"; // FWS is another special case that should be mapped to FAT environment name in the code logic
        String expectedFatEnvName = Env.FAT.name; // The actual name of FAT environment in the Env class
        String resultFwsEnvName = Env.getWellFormName(fwsEnvName);
        assertEquals(expectedFatEnvName, resultFwsEnvName); // Expecting the well-formed name to be the actual name of FAT environment in the Env class after FWS is mapped to FAT by the code logic
    }
}