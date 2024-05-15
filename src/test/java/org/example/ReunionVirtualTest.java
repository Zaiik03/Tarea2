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

class ReunionVirtualTest {
    private Empleado emp1;
    private Empleado emp2;
    private Empleado emp3;
    private Empleado emp4;
    private ArrayList<Ausente> ausentes_virtual_esperado;
    private ReunionVirtual reunionVirtual;

    @BeforeEach
    void setUp() {
        this.emp1 =
                new Empleado("1", "Papu", "Gomez", "papu_gomez@123.cl");
        this.emp2 =
                new Empleado("2", "Oliver2", "Penailillo2", "hola2@123.cl");
        this.emp3 =
                new Empleado("3", "Oliver3", "Penailillo3", "hola3@123.cl");
        this.emp4 =
                new Empleado("4", "Oliver4", "Penailillo4", "hola4@123.cl");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Test iniciar reunion")
    public void testIniciarReunion() {
        System.out.println("Hora inicio reunion");
        emp1 = new Empleado("1", "Papu", "Gomez", "papu_gomez@123.cl");
        emp2 = new Empleado("2", "Oliver2", "Penailillo2", "hola2@123.cl");
        emp3 = new Empleado("3", "Oliver3", "Penailillo3", "hola3@123.cl");
        emp4 = new Empleado("4", "Oliver4", "Penailillo4", "hola4@123.cl");

        ReunionPresencial reunionVirtual = new ReunionPresencial(LocalDate.of(2024, 5, 7), LocalDateTime.of(2024,5,7,10,0), Duration.ofMinutes(120), "A112", emp1, TipoReunion.MARKETING.getString());
        assertNotNull(reunionVirtual);

        emp1.invitar(reunionVirtual, LocalDateTime.of(2024,5,7,10,0));
        emp2.invitar(reunionVirtual, LocalDateTime.of(2024,5,7,10,0));
        emp3.invitar(reunionVirtual, LocalDateTime.of(2024,5,7,10,0));
        emp4.invitar(reunionVirtual, LocalDateTime.of(2024,5,7,10,0));
        // Interesa saber que al iniciar la reunion se asignó correctamente la hora de inicio
        reunionVirtual.iniciar(LocalDateTime.of(2024, 5, 14, 10, 0));

        emp1.confirmarAsistencia(LocalDateTime.of(2024,5,7,10,0), reunionVirtual);
        emp2.confirmarAsistencia(LocalDateTime.of(2024,5,7,10,0), reunionVirtual);
        emp3.confirmarAsistencia(LocalDateTime.of(2024,5,7,10,0), reunionVirtual);

        for(Invitacion i :reunionVirtual.invitaciones){
            assertNotNull(i);
        }

        reunionVirtual.finalizar(LocalDateTime.of(2024, 5 ,7, 12, 0));

        for(Presente i :reunionVirtual.presentes){
            assertNotNull(i, "Error al añadir invitaciones");
        }

        for(Retraso i :reunionVirtual.retrasos){
            assertNotNull(i, "Error al añadir invitaciones");
        }

        for(Ausente i :reunionVirtual.ausentes){
            assertNotNull(i, "Error al añadir invitaciones");
        }
    }
}