package org.example;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.time.LocalDateTime;


public class Main {
    public static void main(String[] args) {
        ReunionPresencial reunion = new ReunionPresencial(LocalDate.of(2024, 5, 7), Instant.now(), Duration.ofHours(1).plusMinutes(30), "A411");
        reunion.iniciar(LocalDateTime.of(2024, 5, 7, 10, 0));


        System.out.println("hola");
        System.out.println("hola");

        reunion.finalizar(LocalDateTime.of(2024, 5, 7, 11, 0));

        System.out.println(reunion.calcularTiempoReal() + " minutos transcurridos");

    }
}