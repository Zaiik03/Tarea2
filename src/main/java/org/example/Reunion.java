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
    /**
     * Variable para almacenar la fecha
     */
    private LocalDate fecha;
    /**
     * Variable para almacenar la hora de inicio prevista
     */
    public LocalDateTime horaPrevista;
    /**
     * Variable para almacenar la duracion prevista
     */
    public Duration duracionPrevista;
    /**
     * Variable para almacenar la ubicación
     */
    private String ubicacion;
    /**
     * Variable para almacenar la hora de inicio
     */
    public LocalDateTime horaInicio;
    /**
     * Variable para almacenar la hora de finalización
     */
    public LocalDateTime horaFin;
    /**
     * Clase Empleado para almacenar al organizador
     */
    public Empleado organizador;
    /**
     * ArrayList de Notas para almacenar las notas durante la reunión
     */
    public ArrayList<Nota> notas;
    /**
     * ArrayList de Invitaciones para almacenar los invitados
     */
    public ArrayList<Invitacion> invitaciones;
    /**
     * ArrayList de invitados presentes
     */
    public ArrayList<Presente> presentes;
    /**
     * ArrayList de invitados quellegaron Atrasados
     */
    public ArrayList<Retraso> retrasos;
    /**
     * ArrayList de invitados ausentes
     */
    public ArrayList<Ausente> ausentes;
    /**
     * Variable que almacenará el tipo de reunión
     */
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

    /**
     * Método que da inicio a la reunion
     * @param horaInicioReal Hora de inicio de la reunion
     */
    public void iniciar(LocalDateTime horaInicioReal) { horaInicio = horaInicioReal; }

    /**
     * Método que da fin a la reunion
     * @param horaFinReal Hora de fin de la reunion
     */
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

        crearInforme();

    }

    /**
     * Método para calcular la duracion de la reunion
     * @return Retorna un float que representa la duracion de la reunion en minutos
     */
    public float calcularTiempoReal() {
        // Se devuelve el tiempo que duró la reunión
        Duration duracion = Duration.between(horaInicio, horaFin);
        return (float) duracion.toMinutes();
    }

    /**
     * Metodo para mostrar los invitados
     * @return Retorna un ArrayList con los invitados
     */
    public ArrayList listaInvitaciones(){
        return invitaciones;
    }

    /**
     * Metodo para obtener las Asistencias
     * @return Retorna un ArrayList por los presentes
     */
    public ArrayList obtenerAsistencias(){
        return presentes;
    }
    /**
     * Método para obtener la lista de atrasos
     * @return Retorna un ArrayList con los atrasos
     */
    public ArrayList obtenerRetrasos(){
        return retrasos;
    }
    /**
     * Metodo para obtener la lista de los ausentes
     * @return Retorna un ArrayList con los invitados ausentes
     */
    public ArrayList obtenerAusentes(){
        return ausentes;
    }
    /**
     * Metodo que crea el Informe que será almacenado en un archivo TXT al final de la reunión
     */
    public void crearInforme(){
        String nombrearchivo = "src/main/java/org/example/Informe.txt";

        File archivo = new File(nombrearchivo);

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

            escritor.println("-------- Notas ---------\n");
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
