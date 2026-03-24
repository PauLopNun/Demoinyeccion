package com.exampleinyection.demoinyeccion;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Primary
@Profile("dev")
public class ConfigExternaEnUnleashDev implements ConfiguracionExterna {

    @Override
    public String getLastRecordInsertedInDatabase() {
        return "Mensaje desde el perfil DEV";
    }

    @Override
    public boolean miAppTieneQueReiniciarCadaCincoMinutos() {
        return false;
    }
}
