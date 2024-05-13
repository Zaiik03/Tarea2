package org.example;

import java.lang.reflect.Array;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Invitacion{
    private Instant hora;
    public String id_destinatario;

    public Invitacion(Instant hora, String id_destinatario){
        this.hora = Instant.now();
        this.id_destinatario = id_destinatario;
    }

    public void datosInvitacion(){

    }
}
