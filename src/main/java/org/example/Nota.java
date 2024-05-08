package org.example;
import java.util.ArrayList;

public class Nota {
    private ArrayList<String> nota_reunion;

    public Nota(){
        nota_reunion = new ArrayList<String>();
    }

    public void getNota(){
        int i = 1;
        for(String nota : nota_reunion){
            System.out.println("Nota " + i + ": " + nota);
            i++;
        }
    }

    public void addNota(String nota){
        nota_reunion.add(nota);
    }
}
