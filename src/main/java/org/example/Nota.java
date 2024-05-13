package org.example;
import java.util.ArrayList;

public class Nota {
    private ArrayList<String> notas_reunion;

    public Nota(){
        notas_reunion = new ArrayList<String>();
    }

    public void getNota(){
        int i = 1;
        for(String nota : notas_reunion){
            System.out.println("Nota " + i + ": " + nota);
            i++;
        }
    }

    public void addNota(String nota){
        notas_reunion.add(nota);
    }
}
