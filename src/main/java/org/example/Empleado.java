package org.example;

import java.time.Instant;
import java.time.LocalDateTime;

public class Empleado implements Invitable {
    private String id;
    private String apellido;
    private String nombre;
    private String correo;

    public Empleado(String id, String nombre, String apellido, String correo){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
    }

    public String getId(){
        return this.id;
    }

    @Override
    public String toString() {
        return new String(id + ", " + nombre + " " + apellido + ", " + correo);
    }

    @Override
    public void invitar(Reunion reunion) {
        // Se agrega la invitación a la lista de invitaciones de la reunion
        reunion.invitaciones.add(new Invitacion(Instant.now(), this.id));

    }

    public void confirmarAsistencia(LocalDateTime horaLlegada, Reunion reunion){
        // Dependiendo de la hora de llegada, agregar empleado a lista de asistencias o retrasos
        if(horaLlegada.isAfter(reunion.getHoraInicio())){
            reunion.retrasos.add(new Retraso(horaLlegada));
        } else{
            reunion.asistencias.add(new Asistencia());
        }
    }
}
