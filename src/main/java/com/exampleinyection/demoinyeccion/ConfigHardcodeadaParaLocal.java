package com.exampleinyection.demoinyeccion;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Primary
@Profile("local")
public class ConfigHardcodeadaParaLocal implements ConfiguracionExterna {

    @Override
    public String getMensajeDeInicioDeAplicacion() {
        return "Mensaje desde el perfil LOCAL";
    }

    @Override
    public boolean miAppTieneQueReiniciarCadaCincoMinutos() {
        return false;
    }
}
