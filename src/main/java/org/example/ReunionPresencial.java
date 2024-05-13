package org.example;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class ReunionPresencial extends Reunion{
    public ReunionPresencial(LocalDate fecha, LocalDateTime horaPrevista, Duration duracionPrevista, String ubicacion, Empleado organizador){
        super(fecha, horaPrevista, duracionPrevista, ubicacion, organizador);
    }
}
