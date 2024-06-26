package org.example;


import java.time.LocalDateTime;

/**
 * Clase que representa al Empleado
 */

public class Empleado implements Invitable {
    /**
     * Variable que almacena el id del Empleado
     */
    private String id;
    /**
     * Variable que almacena el apellido del Empleado
     */
    private String apellido;
    /**
     * Variable que almacena el nombre del Empleado
     */
    private String nombre;
    /**
     * Variable que almacena el correo electronico del Empleado
     */
    private String correo;

    /**
     * Método constructor de Empleado
     * @param id es un String
     * @param nombre es un String
     * @param apellido es un String
     * @param correo es un String
     */
    public Empleado(String id, String nombre, String apellido, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
    }

    /**
     * Método getter
     * @return Retorna el id del Empleado
     */
    public String getId() {
        return this.id;
    }

    /**
     * Método getter
     * @return Retorna los datos del Empleado
     */
    @Override
    public String toString() {
        return new String(nombre + " " + apellido + " - " + correo + " - " + id);
    }

    /**
     * Método para invitar a un empleado a una reunion
     * @param reunion Es la reunion a la que asistirán
     * @param horita Hora a la que se invito
     */
    @Override
    public void invitar(Reunion reunion, LocalDateTime horita) {
        // Se agrega la invitación a la lista de invitaciones de la reunion
        reunion.invitaciones.add(new Invitacion(horita, this));

    }

    /**
     * Método para que un Empleado confirme su asistencia a la reunion
     * @param horallegada es LocalDateTime
     * @param reunion es Reunion
     */
    public void confirmarAsistencia(LocalDateTime horallegada, Reunion reunion) {
        for (Invitacion i : reunion.invitaciones) {
            if (this.equals(i.empleado)) {
                LocalDateTime horainicio = reunion.horaPrevista;
                LocalDateTime horafin = horainicio.plus(reunion.duracionPrevista);


                if (horallegada.isBefore(reunion.horaInicio) || horallegada.isEqual(reunion.horaInicio)) {
                    reunion.presentes.add(new Presente(this));
                } else if (horallegada.isAfter(reunion.horaInicio) && horallegada.isBefore(horafin)) {
                    reunion.retrasos.add(new Retraso(this, horallegada));
                } else {
                    reunion.ausentes.add(new Ausente(this));
                }
            }
        }
    }
}
