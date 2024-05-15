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

class EmpleadoTest {
    Empleado emp1;
    Empleado emp2;
    Invitacion inv1_esperado;
    ReunionPresencial reunion;

    @BeforeEach
    void setUp() {
        this.emp1 =
                null;
        this.reunion =
                new ReunionPresencial(LocalDate.now(), LocalDateTime.now(), Duration.ofMinutes(120), "A112", emp1, TipoReunion.MARKETING.getString());


    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Test creación empleado")
    public void testIniciarEmpleado() {
        emp1 = new Empleado("1", "Papu", "Gomez", "papu_gomez@123.cl");
        assertNotNull(emp1);
    }

    @Test
    @DisplayName("Test invitar empleado")
    public void testInvitarEmpleado() {
        emp1 = new Empleado("1", "Papu", "Gomez", "papu_gomez@123.cl");

        inv1_esperado = new Invitacion(LocalDateTime.of(2024, 5, 14, 10, 0), emp1);

        reunion.invitaciones.add(new Invitacion(LocalDateTime.of(2024,5,14,10,0), emp1));

        for (Invitacion i : reunion.invitaciones) {
            if (inv1_esperado.empleado.equals(i.empleado)) {
                assertTrue(true);
            } else {
                assertTrue(false);
            }
        }
    }

    @Test
    @DisplayName("Test confirmar asistencia")
    public void testConfirmarAsistencia(){
        emp1 = new Empleado("1", "Papu", "Gomez", "papu_gomez@123.cl");

        reunion = new ReunionPresencial(LocalDate.of(2024, 5, 7), LocalDateTime.of(2024,5,7,10,0), Duration.ofMinutes(120), "A112", emp1, TipoReunion.MARKETING.getString());
        ArrayList<Presente> presente_esperado = new ArrayList<Presente>();
        presente_esperado.add(new Presente(emp1));
        emp1.invitar(reunion, LocalDateTime.of(2024, 5, 7, 10,0));

        reunion.iniciar(LocalDateTime.of(2024, 5, 7, 10, 0));

        emp1.confirmarAsistencia(LocalDateTime.of(2024,5,7,10,0), reunion);

        for (Presente p : reunion.presentes){
            if(p.getIdInvitado().equals(presente_esperado.get(0).getIdInvitado())){
                assertTrue(true);
            } else {
                assertTrue(false);
            }
        }

        String datos_empleado = emp1.toString();
        assertNotNull(datos_empleado);
    }
}