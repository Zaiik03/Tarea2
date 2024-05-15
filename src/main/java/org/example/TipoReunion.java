package org.example;

/**
 * Enum de tipos de Reunión
 */
public enum TipoReunion {
    TECNICA("Tecnica"), MARKETING("Marketing"), OTRO("Otro");
    /**
     * Variable que almacena el tipo de reunión
     */
    private final String tipo_reunion;
    /**
     * Constructor TipoReunión
     * @param tipo String con el tipo de reunión
     */
    TipoReunion(String tipo) {
        this.tipo_reunion = tipo;
    }
    /**
     * Metodo getter
     * @return Retorna el tipo de reunión
     */
    public String getString(){
        return tipo_reunion;
    }
}
