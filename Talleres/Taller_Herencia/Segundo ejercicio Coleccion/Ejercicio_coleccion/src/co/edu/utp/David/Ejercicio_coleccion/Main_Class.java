/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.David.Ejercicio_coleccion;

/**
 *
 * @author david_perez
 */
public class Main_Class {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //*********************************************
        ColeccionInterfaz p,c;
        System.out.println("Prueba Pila");
        p = new Pila(10);
        PruebaPila a = new PruebaPila();
        a.rellenar(p);
        a.mostraryVacear(p);
        System.out.println(p.estaVacia());
        //********************************************************
        System.out.println("Prueba Cola");
        c = new Cola();
        a.rellenar(c);
        a.mostraryVacear(c);
        System.out.println(c.estaVacia());
        //********************************************************
    }
    
}
