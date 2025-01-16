package com.ctrip.framework.apollo.portal.environment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnvTest {
    @Test
    public void getWellFormNameTest() {
        String envName = " env name  "; // test with leading and trailing spaces
        String expectedTrimmedName = "envName"; // expected result after trim
        String actualTrimmedName = Env.getWellFormName(envName); // getWellFormName should trim spaces and convert to uppercase
        assertEquals(expectedTrimmedName, actualTrimmedName); // assert expected and actual are equal
        assertEquals("PRO", Env.getWellFormName("PROD")); // assert special case for PROD is handled correctly
        assertEquals("FAT", Env.getWellFormName("FWS")); // assert special case for FWS is handled correctly
        assertNotEquals("FWS", Env.getWellFormName("FAT")); // assert that FAT is not mapped to FWS
        assertEquals("", Env.getWellFormName("")); // assert an empty string is returned for an empty input
    }
}