package org.example;

import java.time.Instant;
import java.time.LocalDateTime;

public class Retraso extends Asistencia{
    private LocalDateTime horaLlegada;
    public Retraso(Empleado e, LocalDateTime horaLlegada){
        super(e);
        this.horaLlegada = horaLlegada;
    }

    public String getIdInvitado(){
        return super.usuario.toString();
    }

    public LocalDateTime getHoraLlegada(){
        return this.horaLlegada;
    }

}
