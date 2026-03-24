package com.exampleinyection.demoinyeccion;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("local")
public class ConfigUnleashEnMemorialLocal implements ConfiguracionExterna {

    private final FlagProperties flagProperties;

    public ConfigUnleashEnMemorialLocal(FlagProperties flagProperties) {
        this.flagProperties = flagProperties;
    }

    @Override
    public String getLastRecordInsertedInDatabase() {
        return "Mensaje desde el perfil LOCAL";
    }

    @Override
    public boolean miAppTieneQueReiniciarCadaCincoMinutos() {
        return flagProperties.isFlagReinicioCincoMinutos();
    }
}
