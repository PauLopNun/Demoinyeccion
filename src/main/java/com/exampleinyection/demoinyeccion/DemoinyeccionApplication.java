package com.exampleinyection.demoinyeccion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoinyeccionApplication {

    private static final Logger log = LoggerFactory.getLogger(DemoinyeccionApplication.class);

    private final ConfiguracionExterna configuracionExterna;
    private final AppConfig appConfig;

    public DemoinyeccionApplication(ConfiguracionExterna configuracionExterna, AppConfig appConfig) {
        this.configuracionExterna = configuracionExterna;
        this.appConfig = appConfig;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoinyeccionApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            log.info("Mensaje del servicio: {}", configuracionExterna.getLastRecordInsertedInDatabase());
            log.info("Mensaje de configuración: {}", appConfig.getWelcomeMessage());
        };
    }
}
