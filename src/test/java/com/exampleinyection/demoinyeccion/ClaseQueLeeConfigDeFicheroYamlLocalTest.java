package com.exampleinyection.demoinyeccion;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("dev")
class ClaseQueLeeConfigDeFicheroYamlLocalTest {

    @Autowired
    private ClaseQueLeeConfigDeFicheroYamlLocal config;

    @Test
    void shouldLoadFeatureFlagFromYaml() {
        assertThat(config.getValorDeFeatureFlag()).isTrue();
    }

    @Test
    void shouldExposeReiniciarCadaCincoMinutosField() {
        assertThat(config.isReiniciarCadaCincoMinutos()).isTrue();
    }
}
