package org.example;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class Main {
    public static void main(String[] args) {
        // Departamentos de ejemplo
        Departamento dep1 = new Departamento("dep1");
        Departamento dep2 = new Departamento("dep2");

        // Empleados de ejemplo
        Empleado emp1 = new Empleado("1", "Oliver1", "Penailillo1", "hola1@123.cl");
        Empleado emp2 = new Empleado("2", "Oliver2", "Penailillo2", "hola2@123.cl");
        Empleado emp3 = new Empleado("3", "Oliver3", "Penailillo3", "hola3@123.cl");
        Empleado emp4 = new Empleado("4", "Oliver4", "Penailillo4", "hola4@123.cl");

        // Asignación departamentos
        dep1.addEmpleados(emp1);
        dep1.addEmpleados(emp2);
        dep2.addEmpleados(emp3);
        dep2.addEmpleados(emp4);

        System.out.println("Datos dep1: ");
        dep1.datosEmpleados();
        System.out.println("Datos dep2: ");
        dep2.datosEmpleados();



        ReunionPresencial reunion = new ReunionPresencial(LocalDate.of(2024, 5, 7), Instant.now(), Duration.ofHours(1).plusMinutes(30), "A411", emp1);
        emp2.invitar(reunion);
        dep2.invitar(reunion);

        reunion.iniciar(LocalDateTime.of(2024, 5, 7, 10, 0));
        emp2.confirmarAsistencia(Instant.now(), reunion);

        reunion.finalizar(LocalDateTime.of(2024, 5, 8, 11, 0));
    }
}