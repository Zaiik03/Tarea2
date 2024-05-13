package org.example;

import java.time.Instant;
import java.time.LocalDateTime;

public class Empleado implements Invitable {
    private String id;
    private String apellido;
    private String nombre;
    private String correo;

    public Empleado(String id, String nombre, String apellido, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
    }

    public String getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return new String(id + ", " + nombre + " " + apellido + ", " + correo);
    }

    @Override
    public void invitar(Reunion reunion) {
        // Se agrega la invitación a la lista de invitaciones de la reunion
        reunion.invitaciones.add(new Invitacion(LocalDateTime.now(), this));

    }

    public void confirmarAsistencia(LocalDateTime horaLlegada, Reunion reunion) {
        // Validacion para confirmar que el empleado fue invitado
        for (Invitacion i : reunion.invitaciones) {
            if (this.equals(i.empleado)) {
                // Dependiendo de la hora de llegada, agregar empleado a lista de asistencias o retrasos
                LocalDateTime horainicio = reunion.horaPrevista;
                LocalDateTime horafin = horainicio.plus(reunion.duracionPrevista);


                if (horaLlegada.isBefore(reunion.horaInicio) || horaLlegada.isEqual(reunion.horaInicio)) {
                    reunion.presentes.add(new Presente(this));
                } else if (horaLlegada.isAfter(reunion.horaInicio) && horaLlegada.isBefore(horafin)) {
                    reunion.retrasos.add(new Retraso(this, horaLlegada));
                } else {
                    reunion.ausentes.add(new Ausente(this));
                }
            }
        }
    }


    public void presentes(){

    }
}
