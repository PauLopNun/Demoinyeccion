# Demo Inyección de Dependencias, Feature Flags y API REST

![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.2-brightgreen?style=flat-square&logo=spring)
![JUnit 5](https://img.shields.io/badge/Testing-JUnit5-red?style=flat-square&logo=junit5)
![Lombok](https://img.shields.io/badge/Lombok-v1.18-blue?style=flat-square)

Este proyecto implementa un sistema dinámico de configuración y gestión de funcionalidades (Feature Flags) utilizando Spring Boot. Además, incluye una **API REST completa (CRUD)** para la gestión de usuarios almacenados en memoria, demostrando el uso de inyección de dependencias entre controladores y servicios.

## Arquitectura y Diseño

### 1. Gestión de Configuraciones (Feature Flags)
El sistema se basa en el principio de inversión de dependencia para gestionar la configuración externa:
* **ConfiguracionExterna**: Interfaz que define el contrato para la obtención de mensajes de bienvenida y estados de flags.
* **ConfigExternaEnUnleashDev**: Implementación activa para el perfil `dev` que conecta con el servicio Unleash.
* **ConfigUnleashEnMemorialLocal**: Implementación para el perfil `local` que utiliza archivos YAML locales para simular el comportamiento de flags sin dependencias externas.
* **FlagProperties**: Mapeo de propiedades jerárquicas mediante `@ConfigurationProperties` para la gestión de flags en local.

### 2. API REST de Usuarios (En memoria)
El proyecto expone endpoints para gestionar entidades de tipo `User` (nombre, edad, alergias). La persistencia se simula en memoria a través del `UserService`.

**Endpoints disponibles:**
* `GET /api` - Obtener la lista de todos los usuarios.
* `GET /api/{id}` - Obtener los detalles de un usuario por su ID.
* `POST /api` - Crear un nuevo usuario.
* `PUT /api/{id}` - Actualizar los datos de un usuario existente.
* `DELETE /api/{id}` - Eliminar un usuario.

## Requisitos

* **Java 21** o superior (Configurado y testeado en flujos de CI/CD con GitHub Actions).
* Maven 3.6+.

## Configuración de Perfiles

El proyecto utiliza archivos de propiedades específicos por entorno:
* `application-local.yaml`: Configuración para desarrollo offline.
* `application-dev.yaml`: Configuración para integración con servicios externos.
* `feature-flags.yaml`: Definición de estados para las funcionalidades en entorno local.

## Ejecución

Para iniciar la aplicación con el perfil local:

```bash
mvn spring-boot:run -Dspring-boot.run.profiles=local
