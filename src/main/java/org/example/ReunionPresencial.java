package org.example;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Subclase Reunión Presencial
 */
public class ReunionPresencial extends Reunion{
    /**
     * Constructor ReunionPresecial
     * @param fecha Fecha de la reunión
     * @param horaPrevista Hora prevista de la reuníón
     * @param duracionPrevista Duración prevista de la reunión
     * @param ubicacion Ubicación de la reunión (Sala, local, url, enlace)
     * @param organizador Organizador de la Reunión
     * @param tipodereunion Especifica el tipo de reunión (Marketing, tecnica, otros...)
     */
    public ReunionPresencial(LocalDate fecha, LocalDateTime horaPrevista, Duration duracionPrevista, String ubicacion, Empleado organizador, String tipodereunion){
        super(fecha, horaPrevista, duracionPrevista, ubicacion, organizador, tipodereunion);
    }
}
