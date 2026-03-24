package com.exampleinyection.demoinyeccion;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("dev")
class DemoinyeccionApplicationTests {

    @Autowired
    private ConfiguracionExterna configuracionExterna;

    @Autowired
    private AppConfig appConfig;

    @Test
    void contextLoads() {
    }

    @Test
    void shouldInjectDevImplementationOfConfiguracionExterna() {
        assertInstanceOf(ConfigExternaEnUnleashDev.class, configuracionExterna);
    }

    @Test
    void shouldReturnDevMessageFromInjectedBean() {
        assertEquals("Mensaje desde el perfil DEV", configuracionExterna.getLastRecordInsertedInDatabase());
    }

    @Test
    void shouldLoadWelcomeMessageFromDevYaml() {
        assertEquals("Bienvenido a DEV", appConfig.getWelcomeMessage());
    }

    @Test
    void shouldNotRestartAppInDevProfile() {
        assertFalse(configuracionExterna.miAppTieneQueReiniciarCadaCincoMinutos());
    }
}
