package org.example;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.time.LocalDateTime;
/**
 * Clase Reunión
 */


abstract public class Reunion {
    private LocalDate fecha;
    private Instant horaPrevista; // de inicio estimada? hora de fin estimada?)
    private Duration duracionPrevista;
    private String ubicacion;
    /* Por ahora se asumirá que horaInicio y horaFin sólo se modificarán cuando se ocupen los métodos iniciar y finalizar, respectivamente */
    private LocalDateTime horaInicio;
    private LocalDateTime horaFin;

    private Nota nota;
    private Asistencia asistencia;

    /**
     * Constructor Reunion
     * @param fecha fecha de creacion de la reunion
     * @param horaPrevista inicio de la reunion
     * @param duracionPrevista duracion de la reunion
     * @param ubicacion la sala o enlace
     */
    Reunion(LocalDate fecha, Instant horaPrevista, Duration duracionPrevista, String ubicacion){
        /* Asignación de propiedades */
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.ubicacion = ubicacion;
        nota = new Nota();
        asistencia = new Asistencia();

    }

    public void iniciar(LocalDateTime horaInicioReal){
        horaInicio = horaInicioReal;
    }

    public void finalizar(LocalDateTime horaFinReal){
        horaFin = horaFinReal;
//        nota.addNota(nota_reunion);
    }

    public float calcularTiempoReal(){
        // Se devuelve el tiempo que duró la reunión
        Duration duracion = Duration.between(horaInicio, horaFin);

        return (float) duracion.toMinutes();
    }

    public String notaReunion(){
        return nota.getNota();
    }
}
