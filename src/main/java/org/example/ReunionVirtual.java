package org.example;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class ReunionVirtual extends Reunion {
    public ReunionVirtual(LocalDate fecha, LocalDateTime horaPrevista, Duration duracionPrevista, String ubicacion, Empleado organizador, String tipodereunion){
        super(fecha, horaPrevista, duracionPrevista, ubicacion, organizador, tipodereunion);
    }

}
