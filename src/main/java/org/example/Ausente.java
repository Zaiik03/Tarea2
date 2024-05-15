package org.example;

/**
 * Clase de los Invitados Ausentes
 */
public class Ausente extends Asistencia{
    /**
     * Metodo constructor de Ausentes
     * @param e Es un empleado
     */
    public Ausente(Empleado e){
        super(e);
    }

    /**
     * Metodo getter
     * @return Retorna un String con los datos del empleado
     */
    public String getIdInvitado(){
        return super.usuario.toString();
    }
}
