package com.ctrip.framework.apollo.portal.environment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnvTest {

    @Test
    public void getWellFormNameTest() {
        // Test with null input
        assertEquals("", Env.getWellFormName(null), "Expected blank for null input");

        // Test with blank input
        assertEquals("", Env.getWellFormName(" "), "Expected blank for blank input");

        // Test with normal input
        assertEquals("DEV", Env.getWellFormName("dev"), "Expected 'DEV' for 'dev' input");

        // Test ensuring trimming
        assertEquals("PROD", Env.getWellFormName("  prod  "), "Expected 'PROD' for '  prod  ' input");

        // Test with special case 'PROD'
        assertEquals(Env.PRO.name, Env.getWellFormName("prod"), "Expected Env.PRO.name for 'prod' input");

        // Test special case mapping 'FWS' to 'FAT'
        assertEquals(Env.FAT.name, Env.getWellFormName("FWS"), "Expected Env.FAT.name for 'FWS' input");
        
        // Test with upper-casing
        assertEquals("UAT", Env.getWellFormName("uat"), "Expected 'UAT' for 'uat' input");
    }
}