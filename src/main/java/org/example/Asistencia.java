package org.example;

/**
 * Clase abstracta que representa la asistencia de un empleado a una reunion
 */
public abstract class Asistencia {
    /**
     * Variable tipo Empleado que representa el empleado al que se está evaluando la asistencia
     */
    public Empleado usuario;

    /**
     * Método constructor de Asistencia
     * @param e es un Empleado
     */
    public Asistencia(Empleado e){
        this.usuario = e;
    }

    /**
     * Método getter para o
     * @return Retorna el id del empleado invitado
     */
    public abstract String getIdInvitado();
}
