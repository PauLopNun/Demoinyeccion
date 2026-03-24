package com.exampleinyection.demoinyeccion;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final ConfiguracionExterna configuracionExterna;
    private final AppConfig appConfig;

    public DemoController(ConfiguracionExterna configuracionExterna, AppConfig appConfig) {
        this.configuracionExterna = configuracionExterna;
        this.appConfig = appConfig;
    }

    @GetMapping("/health-demo")
    public String healthDemo() {
        return "ok";
    }

    @GetMapping("/mensaje")
    public Map<String, Object> mensaje() {
        return Map.of(
                "mensajeServicio", configuracionExterna.getLastRecordInsertedInDatabase(),
                "mensajeConfiguracion", appConfig.getWelcomeMessage(),
                "reiniciarCadaCincoMinutos", configuracionExterna.miAppTieneQueReiniciarCadaCincoMinutos()
        );
    }
}

