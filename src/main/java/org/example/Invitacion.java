package org.example;

import java.lang.reflect.Array;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Clase Invitación
 */
public class Invitacion{
    /**
     * Variable que almacena la hora prevista
     */
    public LocalDateTime hora;
    /**
     * Variable que almacena al empleado invitado
     */
    public Empleado empleado;
    /**
     * Constructor Invitación
     * @param hora Hora prevista
     * @param empleado Empleado invitado
     */
    public Invitacion(LocalDateTime hora, Empleado empleado){
        this.hora = LocalDateTime.now();
        this.empleado = empleado;
    }
}
