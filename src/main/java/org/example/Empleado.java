package org.example;

public class Empleado {
    private String id;
    private String apellido;
    private String nombre;
    private String correo;

    public Empleado(String id, String nombre, String apellido, String correo){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
    }

    public String getId(){
        return this.id;
    }

    @Override
    public String toString() {
        return new String(id + " ," + nombre + " " + apellido + " ," + correo);
    }
}
