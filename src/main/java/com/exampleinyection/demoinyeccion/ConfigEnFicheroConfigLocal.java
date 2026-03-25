package com.exampleinyection.demoinyeccion;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Profile("dev")
public class ConfigEnFicheroConfigLocal implements ConfiguracionExterna {

    private final ClaseQueLeeConfigDeFicheroYamlLocal configDeFicheroYamlLocal;

    @Override
    public String getMensajeDeInicioDeAplicacion() {
        return "Mensaje desde el perfil DEV";
    }

    @Override
    public boolean miAppTieneQueReiniciarCadaCincoMinutos() {
        return configDeFicheroYamlLocal.getValorDeFeatureFlag();
    }
}
