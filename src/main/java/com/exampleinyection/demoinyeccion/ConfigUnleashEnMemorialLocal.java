package com.exampleinyection.demoinyeccion;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Profile("local")
public class ConfigUnleashEnMemorialLocal implements ConfiguracionExterna {

    private final FlagProperties flagProperties;

    @Override
    public String getLastRecordInsertedInDatabase() {
        return "Mensaje desde el perfil LOCAL";
    }

    @Override
    public boolean miAppTieneQueReiniciarCadaCincoMinutos() {
        return flagProperties.isFlagReinicioCincoMinutos();
    }
}
