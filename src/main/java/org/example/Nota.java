package org.example;
import java.util.ArrayList;

/**
 * Clase notas
 */
public class Nota {
    /**
     * Almacena una nota tipo String
     */
    private String texto_nota;
    /**
     * Metodo Constructor
     * @param nota Se le ingresa una nota tipo String
     */
    public Nota(String nota){
        texto_nota = nota;
    }

    /**
     * Metodo getter
     * @return Retorna String con la nota
     */
    public String getNota(){
        return texto_nota;
    }
}
