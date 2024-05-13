package org.example;

public enum TipoReunion {
    TECNICA("Tecnica"), MARKETING("Marketing"), OTRO("Otro");

    private final String tipo_reunion;

    TipoReunion(String tipo) {
        this.tipo_reunion = tipo;
    }

    public String getString(){
        return tipo_reunion;
    }


}
