package com.ctrip.framework.apollo.portal.environment;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class EnvTest {

    @Test
    public void getWellFormNameTest() {
        // Test with blank input
        assertEquals("", Env.getWellFormName(""));

        // Test with null input
        assertEquals("", Env.getWellFormName(null));
        
        // Test trimming and uppercasing
        assertEquals("DEV", Env.getWellFormName(" dev "));
        assertEquals("PROD", Env.getWellFormName("prod"));
        
        // Special case tests
        // "prod" should be converted to the name of Env.PRO
        assertEquals(Env.PRO.name, Env.getWellFormName("prod"));
        // "fws" should be converted to the name of Env.FAT
        assertEquals(Env.FAT.name, Env.getWellFormName("fws"));

        // Test input that results in regular uppercase output
        assertEquals("UAT", Env.getWellFormName(" uat "));
    }
}