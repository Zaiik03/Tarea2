package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ReunionTest {
    private Empleado emp1;
    private ReunionPresencial reunionPresencial;
    private ReunionVirtual reunionVirtual;


    @BeforeEach
    void setUp() {
        this.emp1 =
                new Empleado("1", "Papu", "Gomez", "papu_gomez@123.cl");

        this.reunionPresencial =
                new ReunionPresencial(LocalDate.of(2024, 5, 14), LocalDateTime.of(2024, 5, 14, 10, 0), Duration.ofMinutes(120), "A112", emp1, TipoReunion.MARKETING.getString());

        this.reunionVirtual =
                new ReunionVirtual(LocalDate.of(2024, 5, 14), LocalDateTime.of(2024, 5, 14, 10, 0), Duration.ofMinutes(120), "www.google.com", emp1, TipoReunion.MARKETING.getString());

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Test iniciar reunion")
    public void testIniciarReunion(){
        System.out.println("Hora inicio reunion");

        // Interesa saber que al iniciar la reunion se asignó correctamente la hora de inicio
        reunionPresencial.iniciar(LocalDateTime.of(2024, 5, 14, 10, 0));
        reunionVirtual.iniciar(LocalDateTime.of(2024, 5, 14, 10, 0));
        assertNotNull(reunionPresencial.horaInicio);
        assertNotNull(reunionVirtual.horaInicio);
    }

    @Test
    @DisplayName("Test finalizar reunion")
    public void testFinalizarReunion(){
        System.out.println("Hora fin reunion, lista ausentes e informe");

        // Interesa saber que se asigna correctamente la hora de fin
        reunionPresencial.finalizar(LocalDateTime.of(2024, 5, 14, 12, 0));
        reunionVirtual.finalizar(LocalDateTime.of(2024, 5, 14, 12, 0));
        assertNotNull(reunionPresencial.horaFin);
        assertNotNull(reunionVirtual.horaFin);

        // Interesa saber que se añaden correctamente los ausentes a lista de ausentes


    }
}