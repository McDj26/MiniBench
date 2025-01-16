package com.ctrip.framework.apollo.portal.environment;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class EnvTest {

    @Test
    public void getWellFormNameTest() {
        // Test with null or blank input
        assertEquals("", Env.getWellFormName(null), "Expected output for null input is an empty string");
        assertEquals("", Env.getWellFormName(""), "Expected output for blank input is an empty string");
        assertEquals("", Env.getWellFormName("   "), "Expected output for spaces input is an empty string");

        // Test trimming and converting to upper case
        assertEquals("DEVELOPMENT", Env.getWellFormName("  Development "), "Expected output for '  Development ' is 'DEVELOPMENT'");

        // Test special case mapping for "PROD"
        assertEquals(Env.PRO.name, Env.getWellFormName("prod"), "Expected output for 'prod' is the name of Env.PRO");

        // Test special case mapping for "FWS"
        assertEquals(Env.FAT.name, Env.getWellFormName("FWS"), "Expected output for 'FWS' is the name of Env.FAT");

        // Test normal upper case input
        assertEquals("STAGING", Env.getWellFormName("STAGING"), "Expected output for 'STAGING' is 'STAGING'");
    }
}