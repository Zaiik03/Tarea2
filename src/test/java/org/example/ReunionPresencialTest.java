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

class ReunionPresencialTest {
    private Empleado emp1;
    private Empleado emp2;
    private Empleado emp3;
    private Empleado emp4;
    private ArrayList<Ausente> ausentes_presencial_esperado;
    private ReunionPresencial reunionPresencial;


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

        ReunionPresencial reunionPresencial = new ReunionPresencial(LocalDate.of(2024, 5, 7), LocalDateTime.of(2024,5,7,10,0), Duration.ofMinutes(120), "A112", emp1, TipoReunion.MARKETING.getString());
        assertNotNull(reunionPresencial, "Error al crear reunion");

        emp1.invitar(reunionPresencial, LocalDateTime.of(2024,5,7,9,0));
        emp2.invitar(reunionPresencial, LocalDateTime.of(2024,5,7,10,0));
        emp3.invitar(reunionPresencial, LocalDateTime.of(2024,5,7,11,0));
        emp4.invitar(reunionPresencial, LocalDateTime.of(2024,5,7,15,0));
        // Interesa saber que al iniciar la reunion se asignó correctamente la hora de inicio
        reunionPresencial.iniciar(LocalDateTime.of(2024, 5, 14, 10, 0));

        emp1.confirmarAsistencia(LocalDateTime.of(2024,5,7,10,0), reunionPresencial);
        emp2.confirmarAsistencia(LocalDateTime.of(2024,5,7,10,0), reunionPresencial);
        emp3.confirmarAsistencia(LocalDateTime.of(2024,5,7,10,0), reunionPresencial);

        for(Invitacion i :reunionPresencial.invitaciones){
            assertNotNull(i, "Error al añadir invitaciones");
        }

        reunionPresencial.finalizar(LocalDateTime.of(2024, 5 ,7, 12, 0));

        for(Presente i :reunionPresencial.presentes){
            assertNotNull(i, "Error al añadir invitaciones");
        }

        for(Retraso i :reunionPresencial.retrasos){
            assertNotNull(i, "Error al añadir invitaciones");
        }

        for(Ausente i :reunionPresencial.ausentes){
            assertNotNull(i, "Error al añadir invitaciones");
        }




    }


}