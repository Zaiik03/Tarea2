package org.example;

import java.io.File;
import java.io.PrintWriter;
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
    public ArrayList<Nota> notas;
    public ArrayList<Invitacion> invitaciones;
    public ArrayList<Presente> presentes;
    public ArrayList<Retraso> retrasos;
    public ArrayList<Ausente> ausentes;

    private String tipo_reunion;
    /**
     * Constructor Reunion
     *
     * @param fecha            fecha de creacion de la reunion
     * @param horaPrevista     inicio de la reunion
     * @param duracionPrevista duracion de la reunion
     * @param ubicacion        la sala o enlace
     */
    Reunion(LocalDate fecha, LocalDateTime horaPrevista, Duration duracionPrevista, String ubicacion, Empleado organizador, String tipodereunion) {
        /* Asignación de propiedades */
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.ubicacion = ubicacion;
        this.organizador = organizador;
        this.tipo_reunion = tipodereunion;

        notas = new ArrayList<>();
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

        // Lita de ausentes
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

        // Informe
        crearInforme();

    }

    public float calcularTiempoReal() {
        // Se devuelve el tiempo que duró la reunión
        Duration duracion = Duration.between(horaInicio, horaFin);
        return (float) duracion.toMinutes();
    }

    public ArrayList listaInvitaciones(){
        return invitaciones;
    }

    public ArrayList obtenerAsistencias(){
        return presentes;
    }

    public ArrayList obtenerRetrasos(){
        return retrasos;
    }

    public ArrayList obtenerAusentes(){
        return ausentes;
    }

    public void crearInforme(){
        // Datos del archivo
        String nombrearchivo = "src/main/java/org/example\\Informe.txt";

        // Archivo informe
        File archivo = new File(nombrearchivo);

        // Try del archivo
        try {
            PrintWriter escritor = new PrintWriter(archivo);
            escritor.println("Informe Reunión " + fecha + "\nOrganizado por: " + organizador);
            escritor.println("Hora de la reunion: " + horaPrevista);
            escritor.println("Hora finalización: " + horaFin);
            escritor.println("Duracion total: " + calcularTiempoReal() + " minutos");
            escritor.println("Tipo de reunión: " + tipo_reunion);
            escritor.println("Ubicación: " + ubicacion);

            escritor.println("-------- Lista de presentes ---------");
            for (Presente e : presentes) {
                System.out.println(e.usuario.toString());
            }

            escritor.println("-------- Lista de Atrasados ---------" );
            for(Retraso r : retrasos){
                System.out.println(r.usuario.toString());
            }

            escritor.println("-------- Lista de Ausentes ---------" );
            for(Ausente a : ausentes){
                System.out.println(a.usuario.toString());
            }

            escritor.println("-------- Notas ---------");
            for(Nota n : notas){
                escritor.println(n.getNota());
            }

            escritor.close();
        } catch (Exception e){
            System.err.println("Error: " + e);
        }

    }
}
