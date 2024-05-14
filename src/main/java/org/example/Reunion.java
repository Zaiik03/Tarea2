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

    public void iniciar(LocalDateTime horaInicioReal) { horaInicio = horaInicioReal; }

    public void finalizar(LocalDateTime horaFinReal) {
        horaFin = horaFinReal;

        // Lita de ausentes: Por cada empleado invitado se comprueba que no esté ni en la lista de presentes ni de retrasos
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
        // String nombrearchivo = "src/main/java/org/example\\Informe.txt";
        String nombrearchivo = "src/main/java/org/example/Informe.txt";

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

            escritor.println("\n");
            escritor.println("-------- Lista de presentes ---------\n");
            int i = 1;
            for (Presente e : presentes) {
                escritor.println(i + "._ " + e.usuario.toString());
                i++;
            }
            i = 1 ;
            escritor.println("\n");

            escritor.println("-------- Lista de Atrasados ---------\n" );

            for(Retraso r : retrasos){
                escritor.println(i + "._ " + r.usuario.toString());
                i++;
            }

            i = 1;
            escritor.println("\n");

            escritor.println("-------- Lista de Ausentes ---------\n" );
            for(Ausente a : ausentes){
                escritor.println(i + "._ " + a.usuario.toString());
                i++;
            }

            i = 1;
            escritor.println("\n");

            escritor.println("-------- Notas ---------'\n");
            for(Nota n : notas){
                escritor.println(i + "._ " + n.getNota());
                i++;
            }

            escritor.close();
        } catch (Exception e){
            System.err.println("Error: " + e);
        }

    }
}
