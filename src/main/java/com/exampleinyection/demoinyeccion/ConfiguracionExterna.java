package com.exampleinyection.demoinyeccion;

public interface ConfiguracionExterna {
    String getLastRecordInsertedInDatabase();
    boolean miAppTieneQueReiniciarCadaCincoMinutos();
}
