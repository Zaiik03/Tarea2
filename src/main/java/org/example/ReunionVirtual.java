package org.example;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

public class ReunionVirtual extends Reunion {
    public ReunionVirtual(LocalDate fecha, Instant horaPrevista, Duration duracionPrevista, String ubicacion){
        super(fecha, horaPrevista, duracionPrevista, ubicacion);
    }

}
