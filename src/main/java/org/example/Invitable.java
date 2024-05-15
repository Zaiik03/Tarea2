package org.example;

import java.time.LocalDateTime;

/**
 * Interfaz Invitable
 */
public interface Invitable {
    /**
     * Método para invitar Empleado
     * @param reunion reunion
     * @param horita hora
     */
    void invitar(Reunion reunion, LocalDateTime horita);
}
