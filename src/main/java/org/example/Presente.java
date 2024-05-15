package org.example;

/**
 * Subclase de los invitados que llegaron Puntual
 */
public class Presente extends Asistencia{
    /**
     * Contructor Presente
     * @param e Se le ingresa un empleado
     */
    public Presente(Empleado e){
        super(e);
    }

    /**
     * Metodo getter
     * @return Retorna los datos de un empleado
     */
    public String getIdInvitado(){
        return super.usuario.toString();
    }
}
