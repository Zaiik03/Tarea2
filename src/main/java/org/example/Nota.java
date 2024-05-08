package org.example;
import java.util.ArrayList;

public class Nota {
    private ArrayList<String> nota_reunion;

    public Nota(){
        nota_reunion = new ArrayList<String>();
    }

    public String getNota(){
        for(String nota : nota_reunion){
            System.out.println(nota);
        }
        return "";
    }

    public void addNota(String nota){
        nota_reunion.add(nota);
    }

    private int getTamaño(){
        return nota_reunion.size();
    }
}
