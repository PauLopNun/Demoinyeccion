package com.exampleinyection.demoinyeccion;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
class DemoinyeccionApplicationUnitTests {

    @InjectMocks
    DemoinyeccionApplication demoinyeccionApplication;

    @Mock
    ConfiguracionExterna configuracionExterna;

    @Mock
    AppConfig appConfig;

    @Test
    void shouldReturnMensaje_whenConfiguracionExternaResponde() {
        doReturn("Hola").when(configuracionExterna).getMensajeDeInicioDeAplicacion();
        assertThat(demoinyeccionApplication.configuracionAplicada()).isEqualTo("Hola");
    }

    @Test
    void shouldReturnErrorMessage_whenRuntimeExceptionIsThrown() {
        doThrow(new RuntimeException("fallo")).when(configuracionExterna).getMensajeDeInicioDeAplicacion();
        assertThat(demoinyeccionApplication.configuracionAplicada()).isEqualTo("ERROR INESPERADO SIN EXCEPCION");
    }

    @Test
    void shouldReturnErrorMessage_whenExceptionIsThrown() {
        doThrow(new RuntimeException("fallo") {}).when(configuracionExterna).getMensajeDeInicioDeAplicacion();
        assertThat(demoinyeccionApplication.configuracionAplicada()).isEqualTo("ERROR INESPERADO SIN EXCEPCION");
    }
}
