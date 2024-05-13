package org.example;

import java.time.Instant;
import java.time.LocalDateTime;

public class Retraso extends Asistencia{
    private LocalDateTime hora;
    public Retraso(LocalDateTime hora){
        this.hora = hora;
    }
}
