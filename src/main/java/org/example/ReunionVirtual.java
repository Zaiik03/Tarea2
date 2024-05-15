package org.example;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Subclase de Reunion, ReunionVirtual
 */
public class ReunionVirtual extends Reunion {
    /**
     * Método constructor de ReunionVirtual
     * @param fecha Fecha de la reunión
     * @param horaPrevista Hora prevista de la reunion
     * @param duracionPrevista Duración prevista de la reunión
     * @param ubicacion Ubicación de la reunión (url, enlace)
     * @param organizador Organizador de la Reunión
     * @param tipodereunion Especifica el tipo de reunión (Marketing, tecnica, otros...)
     */
    public ReunionVirtual(LocalDate fecha, LocalDateTime horaPrevista, Duration duracionPrevista, String ubicacion, Empleado organizador, String tipodereunion){
        super(fecha, horaPrevista, duracionPrevista, ubicacion, organizador, tipodereunion);
    }

}
