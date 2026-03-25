package com.exampleinyection.demoinyeccion;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

class DemoinyeccionApplicationTests {

    @Nested
    @SpringBootTest
    @ActiveProfiles("dev")
    class DevProfileTest {

        @Autowired
        private ConfiguracionExterna configuracionExterna;

        @Autowired
        private AppConfig appConfig;

        @Autowired
        private DemoinyeccionApplication demoinyeccionApplication;

        @Test
        void contextLoads() {
            assertThat(configuracionExterna).isInstanceOf(ConfigEnFicheroConfigLocal.class);
        }

        @Test
        void shouldLoadDevWelcomeMessage() {
            assertThat(appConfig.getWelcomeMessage()).isEqualTo("Bienvenido a DEV");
        }

        @Test
        void shouldReturnDevMessage() {
            assertThat(demoinyeccionApplication.configuracionAplicada()).isEqualTo("Mensaje desde el perfil DEV");
        }

        @Test
        void shouldReadFeatureFlagFromYaml() {
            assertThat(configuracionExterna.miAppTieneQueReiniciarCadaCincoMinutos()).isTrue();
        }
    }

    @Nested
    @SpringBootTest
    @ActiveProfiles("local")
    class LocalProfileTest {

        @Autowired
        private ConfiguracionExterna configuracionExterna;

        @Autowired
        private AppConfig appConfig;

        @Test
        void contextLoads() {
            assertThat(configuracionExterna).isInstanceOf(ConfigHardcodeadaParaLocal.class);
        }

        @Test
        void shouldLoadLocalWelcomeMessage() {
            assertThat(appConfig.getWelcomeMessage()).isEqualTo("Bienvenido a LOCAL");
        }

        @Test
        void shouldReturnLocalMessage() {
            assertThat(configuracionExterna.getMensajeDeInicioDeAplicacion()).isEqualTo("Mensaje desde el perfil LOCAL");
        }

        @Test
        void shouldNotRestartApp() {
            assertThat(configuracionExterna.miAppTieneQueReiniciarCadaCincoMinutos()).isFalse();
        }
    }
}
