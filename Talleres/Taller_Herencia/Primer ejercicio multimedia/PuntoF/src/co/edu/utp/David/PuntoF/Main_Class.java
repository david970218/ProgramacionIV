/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.David.PuntoF;

import co.edu.utp.David.Taller_Herencia_Multimedia.*;

/**
 *
 * @author david_perez
 */
public class Main_Class {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ListaMultimedia lista;
        lista = new ListaMultimedia(20);
        //*************************************************************
        lista.add(new Disco("Sonne","Rammstein","mp3","4:30 min"));
        lista.add(new Disco("Molinos de viento","mago de oz","mp3","5:35 min"));
        lista.add(new Disco("Survival","Muse","mp3","3:20 min"));
        //***************************************************************
        for (int i = 0; i < lista.Size(); i++)
            System.out.println(lista.get(i));
        Multimedia a;
        a = new Disco("Survival","Muse");
        System.out.println(a.equals(lista.get(2)));
    }
    
}
