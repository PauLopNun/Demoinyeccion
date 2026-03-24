package com.exampleinyection.demoinyeccion;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "feature-flags")
public class FlagProperties {
    private boolean flagReinicioCincoMinutos;

    public boolean isFlagReinicioCincoMinutos() {
        return flagReinicioCincoMinutos;
    }

    public void setFlagReinicioCincoMinutos(boolean flagReinicioCincoMinutos) {
        this.flagReinicioCincoMinutos = flagReinicioCincoMinutos;
    }
}
