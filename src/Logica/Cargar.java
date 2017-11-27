/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author COMPAQ
 */
public class Cargar {
   private Scanner entrada;
    private  ArrayList<String>entradas;
    public Cargar() throws FileNotFoundException{
    this.entradas=new ArrayList<>();
    File archivo=new File("Nivel.txt");
   
    if(archivo.exists()){
    this.entrada=new Scanner(archivo);
    entrada.useDelimiter(",");
    while(entrada.hasNext()){
    String s=entrada.next();
    this.entradas.add(s);
    }
    
    }
    
    }

    public ArrayList<String> getEntradas() {
        return entradas;
    }
}
