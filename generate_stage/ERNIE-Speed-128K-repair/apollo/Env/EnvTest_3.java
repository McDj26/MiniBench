package com.ctrip.framework.apollo.portal.environment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnvTest {
    @Test
    public void getWellFormNameTest() {
        String envName = " "; // test case for empty string
        String expectedResult = ""; // expected result should be an empty string for an empty input
        String actualResult = Env.getWellFormName(envName);
        assertEquals(expectedResult, actualResult, "Expected an empty string for empty input");
        
        envName = ""; // test case for blank string
        expectedResult = ""; // expected result should be an empty string for a blank input
        actualResult = Env.getWellFormName(envName);
        assertEquals(expectedResult, actualResult, "Expected an empty string for blank input");
        
        envName = "production "; // test case for trimmed production with extra space
        expectedResult = Env.PRO.name; // expected result should be the exact name of production environment after trim and upper case conversion
        actualResult = Env.getWellFormName(envName);
        assertEquals(expectedResult, actualResult, "Expected PRO as output for trimmed production input");
        
        envName = "FAT "; // test case for trimmed FAT with extra space
        expectedResult = "FAT"; // expected result should be the name without space and in upper case after trimmed
        actualResult = Env.getWellFormName(envName);
        assertEquals(expectedResult, actualResult, "Expected FAT as output for trimmed FAT input");
        
        envName = "FWS"; // test case for FWS which should map to FAT
        expectedResult = "FAT"; // expected result should be FAT because of the mapping logic in the code
        actualResult = Env.getWellFormName(envName);
        assertEquals(expectedResult, actualResult, "Expected FAT as output for FWS input");
        
        // Test case for other valid environments that are not mapped or have special cases defined in the code should return the input trimmed and upper case as is
        envName = "LOCAL"; // test case for any other valid environment without special cases
        expectedResult = "LOCAL"; // expected result should be LOCAL after trim and upper case conversion since it's not a special case defined in the code
        actualResult = Env.getWellFormName(envName);
        assertEquals(expectedResult, actualResult, "Expected LOCAL as output for non-special case input");
    }
}