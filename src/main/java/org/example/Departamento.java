package org.example;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Departamento {
    private ArrayList<Empleado> empleados;
    private ArrayList<Empleado> aux;
    private String nombre;

    public Departamento(String nombre_depa){
        empleados = new ArrayList<Empleado>();
        nombre = nombre_depa;
    }

    public void addEmpleados(Empleado e){
        boolean verificar = true;
        for(Empleado a : empleados){
            if(a.getId().equals(e.getId())){
                verificar = false;
                break;
            }
        }
        if(verificar){
            empleados.add(e);
            aux = (ArrayList<Empleado>) empleados.clone();
        }
    }

    public int obtenerCantidadEmpleados(){
        return empleados.size();
    }

    public void datosEmpleados(){
        for(Empleado e : empleados){
            System.out.println(e);
        }
    }

    public Empleado getEmpleado(){
        return aux.remove(0);
    }
}
