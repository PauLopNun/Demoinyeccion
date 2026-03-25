package com.exampleinyection.demoinyeccion;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigInteger;

@Slf4j
@SpringBootApplication
public class DemoinyeccionApplication {

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
            log.info("Tiene que reiniciarme cada 5 minutos? {}", configuracionExterna.miAppTieneQueReiniciarCadaCincoMinutos());
            log.info("Mensaje de configuración: {}", appConfig.getWelcomeMessage());
        };
    }

    public String configuracionAplicada() {
        try {
            return configuracionExterna.getMensajeDeInicioDeAplicacion();
        } catch (RuntimeException exc) {
            log.warn("Exception no controlada", exc);
        } catch (Exception exc) {
            log.warn("Exception no controlada, {}", exc.getMessage());
        }
        return "ERROR INESPERADO SIN EXCEPCION";
    }
}
