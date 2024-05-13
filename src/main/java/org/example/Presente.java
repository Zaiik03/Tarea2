package org.example;

public class Presente extends Asistencia{
    public Presente(Empleado e){
        super(e);
    }

    public String getIdInvitado(){
        return super.usuario.toString();
    }
}
