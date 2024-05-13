package org.example;

public abstract class Asistencia {
    public Empleado usuario;

    public Asistencia(Empleado e){
        this.usuario = e;
    }

    public abstract String getIdInvitado();
}
