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
    public LocalDateTime horaPrevista; // de inicio estimada? hora de fin estimada?)
    public Duration duracionPrevista;
    private String ubicacion;
    /* Por ahora se asumirá que horaInicio y horaFin sólo se modificarán cuando se ocupen los métodos iniciar y finalizar, respectivamente */
    public LocalDateTime horaInicio;
    public LocalDateTime horaFin;

    public Empleado organizador;
    public static Nota nota;
    public ArrayList<Invitacion> invitaciones;
    public ArrayList<Presente> presentes;
    public ArrayList<Retraso> retrasos;
    public ArrayList<Ausente> ausentes;
    /**
     * Constructor Reunion
     *
     * @param fecha            fecha de creacion de la reunion
     * @param horaPrevista     inicio de la reunion
     * @param duracionPrevista duracion de la reunion
     * @param ubicacion        la sala o enlace
     */
    Reunion(LocalDate fecha, LocalDateTime horaPrevista, Duration duracionPrevista, String ubicacion, Empleado organizador) {
        /* Asignación de propiedades */
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.ubicacion = ubicacion;
        this.organizador = organizador;

        nota = new Nota();
        invitaciones = new ArrayList<>();
        presentes = new ArrayList<>();
        retrasos = new ArrayList<>();
        ausentes = new ArrayList<>();

    }

    public void iniciar(LocalDateTime horaInicioReal) {
        horaInicio = horaInicioReal;
    }

    public void finalizar(LocalDateTime horaFinReal) {
        horaFin = horaFinReal;

        for(Invitacion i : invitaciones){
            int p_si = 1;
            int r_si = 1;
            for(Presente p : presentes){
                if(i.empleado.equals(p.usuario)){
                    p_si = 0;
                }
            }

            for(Retraso r : retrasos){
                if(i.empleado.equals(r.usuario) ){
                    r_si = 0;
                }
            }
            if(r_si == 1 && p_si == 1){
                ausentes.add(new Ausente(i.empleado));
            }
        }
    }

    public float calcularTiempoReal() {
        // Se devuelve el tiempo que duró la reunión
        Duration duracion = Duration.between(horaInicio, horaFin);
        return (float) duracion.toMinutes();
    }

    public void listaInvitaciones(){
        for(Invitacion i : invitaciones){
            System.out.println(i.empleado.getId() + ", " + i.hora);
        }
    }

    public void obtenerAsistencias(){
        for(Presente persona : presentes){
            System.out.println("Persona puntual: " + persona.getIdInvitado());
        }
    }

    public void obtenerRetrasos(){
        for(Retraso persona : retrasos){
            System.out.println("Persona atrasada: " + persona.getIdInvitado() + " - " + persona.getHoraLlegada());
        }
    }

    public void obtenerAusentes(){
        for(Ausente persona : ausentes){
            System.out.println("Persona ausente: " + persona.getIdInvitado());
        }
    }

}
