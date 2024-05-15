package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DepartamentoTest {
    Departamento dep;
    Empleado emp1;
    Empleado emp2;
    Empleado emp3;

    @BeforeEach
    void setUp() {
        dep = new Departamento("Departamento ejemplo");
        emp1 = new Empleado("1", "Papu1", "Gomez1", "papu_gomez1@123.cl");
        emp2 = new Empleado("2", "Papu2", "Gomez2", "papu_gomez2@123.cl");
        emp3 = new Empleado("3", "Papu3", "Gomez3", "papu_gomez3@123.cl");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Test añadir Empleado")
    public void testAddEmpleado(){
        ArrayList<Empleado> arr_esperado = new ArrayList<>();
        arr_esperado.add(emp1);
        dep.addEmpleados(emp1);

        for(Empleado e : arr_esperado){
            if(e.getId().equals(dep.getEmpleado().getId())){
                assertTrue(true);
            } else {
                assertTrue(false, "Error al añadir Empleado a Departamento");
            }
        }
    }

    @Test
    @DisplayName("Test añadir dos veces un mismo Empleado al mismo Departamento")
    public void testAddEmpleado2veces(){
        ArrayList<Empleado> arr_esperado = new ArrayList<>();
        arr_esperado.add(emp1);
        arr_esperado.add(emp2);

        dep.addEmpleados(emp1);
        dep.addEmpleados(emp1);
        dep.addEmpleados(emp2);
        for(Empleado a : arr_esperado){
            Empleado b = dep.getEmpleado();
            if(a.getId().equals(b.getId())){
                assertTrue(true);
            } else{
                assertTrue(false, "Error al intentar añadir dos veces un mismo Empleado");
            }
        }
    }

    @Test
    @DisplayName("Test invitar Departamento a reunion")
    public void testInvitar(){
        ArrayList<Invitacion> arr_esperado = new ArrayList<>();
        arr_esperado.add(new Invitacion(LocalDateTime.of(2024, 5, 7, 10, 0), emp1));
        arr_esperado.add(new Invitacion(LocalDateTime.of(2024, 5, 7, 10, 0), emp2));
        arr_esperado.add(new Invitacion(LocalDateTime.of(2024, 5, 7, 10, 0), emp3));


        dep.addEmpleados(emp1);
        dep.addEmpleados(emp2);
        dep.addEmpleados(emp3);
        ReunionPresencial reunion =
                new ReunionPresencial(LocalDate.of(2024, 5, 7), LocalDateTime.of(2024, 5, 7, 10, 0), Duration.ofMinutes(120), "A411", emp1, TipoReunion.MARKETING.getString());
        dep.invitar(reunion, LocalDateTime.of(2024, 5, 7, 10, 0));

        for(Invitacion a : reunion.invitaciones){
            Invitacion b = arr_esperado.remove(0);
            if(a.empleado.getId().equals(b.empleado.getId())){;
                assertTrue(true);
            } else {
                assertTrue(false, "Error al invitar Departamento");
            }
        }

    }
}