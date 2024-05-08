package org.example;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Invitacion implements Invitable{

    private LocalDateTime hora;
    private ArrayList<Empleado> invitados;

    public Invitacion(){
        invitados = new ArrayList<Empleado>();
    }

    @Override
    public void invitar(Departamento d) {
        for(int i = 0; i < d.obtenerCantidadEmpleados(); i++){
            invitados.add(d.getEmpleado());
        }
    }

    public void datosInvitacion(){
        for(Empleado e : invitados){
            System.out.println(e);
        }
    }
}
