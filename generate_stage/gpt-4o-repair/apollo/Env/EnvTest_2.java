package com.ctrip.framework.apollo.portal.environment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnvTest {

    @Test
    public void getWellFormNameTest() {
        // Test with normal environment name
        assertEquals("DEV", Env.getWellFormName(" dev "));

        // Test with production environment name using a typo
        assertEquals(Env.PRO.name, Env.getWellFormName("prod"));

        // Test mapping special cases FWS to FAT
        assertEquals(Env.FAT.name, Env.getWellFormName("fws"));

        // Test with an empty string
        assertEquals("", Env.getWellFormName(""));

        // Test with a blank string
        assertEquals("", Env.getWellFormName("   "));

        // Test with null
        assertEquals("", Env.getWellFormName(null));

        // Test with uppercase environment name
        assertEquals("UAT", Env.getWellFormName("UAT"));

        // Test with mixed case environment name
        assertEquals("LPT", Env.getWellFormName("LpT"));
    }
}