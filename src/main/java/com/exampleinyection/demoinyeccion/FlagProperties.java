package com.exampleinyection.demoinyeccion;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "feature-flags")
public class FlagProperties {
    private boolean flagReinicioCincoMinutos;
}
