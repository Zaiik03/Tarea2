package org.example;

import java.lang.reflect.Array;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Invitacion{
    public LocalDateTime hora;
    public Empleado empleado;

    public Invitacion(LocalDateTime hora, Empleado empleado){
        this.hora = LocalDateTime.now();
        this.empleado = empleado;
    }
}
