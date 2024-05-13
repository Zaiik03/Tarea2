package org.example;

public class Ausente extends Asistencia{
    public Ausente(Empleado e){
        super(e);
    }

    public String getIdInvitado(){
        return super.usuario.toString();
    }
}
