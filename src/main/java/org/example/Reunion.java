package org.example;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

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

    Empleado organizador;
    public static Nota nota;
    public ArrayList<Invitacion> invitaciones;
    public ArrayList<Asistencia> asistencias;
    public ArrayList<Retraso> retrasos;
    /**
     * Constructor Reunion
     *
     * @param fecha            fecha de creacion de la reunion
     * @param horaPrevista     inicio de la reunion
     * @param duracionPrevista duracion de la reunion
     * @param ubicacion        la sala o enlace
     */
    Reunion(LocalDate fecha, Instant horaPrevista, Duration duracionPrevista, String ubicacion, Empleado organizador) {
        /* Asignación de propiedades */
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.ubicacion = ubicacion;
        this.organizador = organizador;

        nota = new Nota();
        invitaciones = new ArrayList<>();
        asistencias = new ArrayList<>();
        retrasos = new ArrayList<>();

    }

    public void iniciar(LocalDateTime horaInicioReal) {
        horaInicio = horaInicioReal;
    }

    public void finalizar(LocalDateTime horaFinReal) {
        horaFin = horaFinReal;
    }

    public float calcularTiempoReal() {
        // Se devuelve el tiempo que duró la reunión
        Duration duracion = Duration.between(horaInicio, horaFin);
        return (float) duracion.toMinutes();
    }

    public LocalDateTime getHoraInicio(){
        return horaInicio;
    }


}
