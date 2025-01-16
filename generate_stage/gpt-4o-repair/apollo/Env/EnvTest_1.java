package com.ctrip.framework.apollo.portal.environment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnvTest {

    @Test
    public void getWellFormNameTest() {
        // Test for blank environment name
        assertEquals("", Env.getWellFormName(""));

        // Test for an environment name with leading/trailing spaces
        assertEquals("DEV", Env.getWellFormName(" dev "));

        // Test for conversion to uppercase
        assertEquals("DEV", Env.getWellFormName("Dev"));

        // Test for production case
        assertEquals(Env.PRO.name, Env.getWellFormName(" prod "));

        // Test for special case where FWS maps to FAT
        assertEquals(Env.FAT.name, Env.getWellFormName("fws"));

        // Test for a normal environment name
        assertEquals("UAT", Env.getWellFormName("uat"));
    }
}