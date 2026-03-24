# Demo Inyeccion de Dependencias y Feature Flags

Proyecto Spring Boot con inyeccion por perfiles (`local` y `dev`) y endpoints de prueba para validar configuracion.

## Requisitos

- Java 17
- IntelliJ IDEA con soporte Maven

Nota: en este equipo no hace falta tener `mvn` instalado globalmente. Puedes ejecutar desde IntelliJ.

## Perfiles

- `local`: perfil por defecto (`spring.profiles.default=local`)
- `dev`: perfil alternativo

Archivos de configuracion:

- `src/main/resources/application.yaml`
- `src/main/resources/application-local.yaml`
- `src/main/resources/application-dev.yaml`
- `src/main/resources/feature-flags.yaml`

## Ejecutar desde IntelliJ

1. Abre el proyecto por `pom.xml`.
2. Verifica `Project SDK = 17`.
3. Ejecuta `DemoinyeccionApplication`.

Para forzar perfil en Run Configuration (VM options):

```text
-Dspring.profiles.active=local
```

o

```text
-Dspring.profiles.active=dev
```

## Comandos utiles en PowerShell

Comprobar Java:

```powershell
java -version
```

Probar endpoints cuando la app este levantada:

```powershell
curl.exe http://localhost:9090/health-demo
curl.exe http://localhost:9090/mensaje
```

## Endpoints

- `GET /health-demo` -> `ok`
- `GET /mensaje` -> JSON con:
  - `mensajeServicio`
  - `mensajeConfiguracion`
  - `reiniciarCadaCincoMinutos`

## Maven Wrapper (opcional y local)

Si quieres usar wrapper sin instalar Maven global, puedes generarlo desde IntelliJ (Maven Tool Window -> Execute Maven Goal) con:

```text
org.apache.maven.plugins:maven-wrapper-plugin:3.3.2:wrapper
```

Este repo esta configurado para no subir el wrapper al remoto:

- `mvnw`
- `mvnw.cmd`
- `.mvn/`

Si algun archivo del wrapper ya estuviera trackeado, quitarlo del index:

```powershell
git rm --cached mvnw
git rm --cached mvnw.cmd
git rm --cached -r .mvn
```
