package org.example;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class Main {
    public static void main(String[] args) {
        ReunionPresencial reunion = new ReunionPresencial(LocalDate.of(2024, 5, 7), Instant.now(), Duration.ofHours(1).plusMinutes(30), "A411");
        reunion.iniciar(LocalDateTime.of(2024, 5, 7, 10, 0));

        // Departamentos
        Departamento depaComunista = new Departamento("anti-furros");

        // Empleados
        for (int i = 0; i < 10; i++){
            Empleado e = new Empleado("A-" + (i + 1), "oliver", "peñailillo", "oliver@hola.cl");
            depaComunista.addEmpleados(e);
        }

        Empleado hola = new Empleado("A-" + 3, "matias", "peneilillo", "oliver@hola.cl");
        depaComunista.addEmpleados(hola);

        // Invitaciones
        Invitacion i = new Invitacion();
        i.invitar(depaComunista);
        i.datosInvitacion();



        reunion.finalizar(LocalDateTime.of(2024, 5, 8, 11, 0));
    }
}