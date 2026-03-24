package com.exampleinyection.demoinyeccion;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
public class DemoinyeccionApplication {

    private final ConfiguracionExterna configuracionExterna;
    private final AppConfig appConfig;

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
