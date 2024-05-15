package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class AusenteTest {
    Empleado emp;
    Ausente ausente;
    @BeforeEach
    void setUp() {
        emp = new Empleado("1", "Papu", "Gomez", "papu_gomez@123.cl");
        ausente = new Ausente(emp);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Test getIdInvitado")
    public void testgetIdInvitado(){

        String datos_ausente = ausente.getIdInvitado();
        assertNotNull(datos_ausente);
    }
}