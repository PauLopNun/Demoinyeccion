# Demo Inyección de Dependencias y Feature Flags

Este proyecto implementa un sistema dinámico de configuración y gestión de funcionalidades (Feature Flags) utilizando Spring Boot. La arquitectura permite alternar entre implementaciones reales (Unleash) y simulaciones locales mediante perfiles de Spring, garantizando un desacoplamiento total de la lógica de negocio.

![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.2-brightgreen?style=flat-square&logo=spring)
![JUnit 5](https://img.shields.io/badge/Testing-JUnit5-red?style=flat-square&logo=junit5)
![Lombok](https://img.shields.io/badge/Lombok-v1.18-blue?style=flat-square)

## Arquitectura y Diseño

El sistema se basa en el principio de inversión de dependencia para gestionar la configuración externa:

- **ConfiguracionExterna**: Interfaz que define el contrato para la obtención de mensajes de bienvenida y estados de flags.
- **ConfigExternaEnUnleashDev**: Implementación activa para el perfil `dev` que conecta con el servicio Unleash.
- **ConfigUnleashEnMemorialLocal**: Implementación para el perfil `local` que utiliza archivos YAML locales para simular el comportamiento de flags sin dependencias externas.
- **FlagProperties**: Mapeo de propiedades jerárquicas mediante `@ConfigurationProperties` para la gestión de flags en local.

## Requisitos

- Java 17 o superior.
- Maven 3.6+.

## Configuración de Perfiles

El proyecto utiliza archivos de propiedades específicos por entorno:

- `application-local.yaml`: Configuración para desarrollo offline.
- `application-dev.yaml`: Configuración para integración con servicios externos.
- `feature-flags.yaml`: Definición de estados para las funcionalidades en entorno local.

## Ejecución

Para iniciar la aplicación con el perfil local:

```bash
mvn spring-boot:run -Dspring-boot.run.profiles=local
