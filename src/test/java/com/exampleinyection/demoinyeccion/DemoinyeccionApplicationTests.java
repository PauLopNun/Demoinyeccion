package com.exampleinyection.demoinyeccion;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("dev")
class DemoinyeccionApplicationTests {

    @Autowired
    private ConfiguracionExterna configuracionExterna;

    @Autowired
    private AppConfig appConfig;

    @Autowired
    private MockMvc mockMvc;

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

    @Test
    void healthDemoShouldReturnOk() throws Exception {
        mockMvc.perform(get("/health-demo"))
                .andExpect(status().isOk())
                .andExpect(content().string("ok"));
    }

    @Test
    void mensajeShouldReturnExpectedPayloadInDevProfile() throws Exception {
        mockMvc.perform(get("/mensaje"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mensajeServicio").value("Mensaje desde el perfil DEV"))
                .andExpect(jsonPath("$.mensajeConfiguracion").value("Bienvenido a DEV"))
                .andExpect(jsonPath("$.reiniciarCadaCincoMinutos").value(false));
    }
}
