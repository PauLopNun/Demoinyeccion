package com.exampleinyection.demoinyeccion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DemoinyeccionApplicationUnitTests {

    @Test
    void devProfileShouldReturnDevMessage() {
        ConfiguracionExterna config = new ConfigExternaEnUnleashDev();
        assertEquals("Mensaje desde el perfil DEV", config.getLastRecordInsertedInDatabase());
    }

    @Test
    void devProfileShouldNotRestartApp() {
        ConfiguracionExterna config = new ConfigExternaEnUnleashDev();
        assertFalse(config.miAppTieneQueReiniciarCadaCincoMinutos());
    }

    @Test
    void localProfileShouldReturnLocalMessage() {
        ConfiguracionExterna config = new ConfigUnleashEnMemorialLocal(flagsWith(false));
        assertEquals("Mensaje desde el perfil LOCAL", config.getLastRecordInsertedInDatabase());
    }

    @Test
    void localProfileShouldRestartApp_whenFlagIsTrue() {
        ConfiguracionExterna config = new ConfigUnleashEnMemorialLocal(flagsWith(true));
        assertTrue(config.miAppTieneQueReiniciarCadaCincoMinutos());
    }

    @Test
    void localProfileShouldNotRestartApp_whenFlagIsFalse() {
        ConfiguracionExterna config = new ConfigUnleashEnMemorialLocal(flagsWith(false));
        assertFalse(config.miAppTieneQueReiniciarCadaCincoMinutos());
    }

    @Test
    void appConfigShouldExposeWelcomeMessage() {
        AppConfig appConfig = new AppConfig();
        appConfig.setWelcomeMessage("Hola");
        assertEquals("Hola", appConfig.getWelcomeMessage());
    }

    @Test
    void flagPropertiesShouldExposeFlag() {
        FlagProperties flags = new FlagProperties();
        flags.setFlagReinicioCincoMinutos(true);
        assertTrue(flags.isFlagReinicioCincoMinutos());
    }

    private FlagProperties flagsWith(boolean value) {
        FlagProperties flags = new FlagProperties();
        flags.setFlagReinicioCincoMinutos(value);
        return flags;
    }
}
