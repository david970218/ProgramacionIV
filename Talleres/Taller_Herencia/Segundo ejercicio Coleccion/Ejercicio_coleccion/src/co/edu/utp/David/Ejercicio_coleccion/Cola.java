/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.David.Ejercicio_coleccion;

import java.util.LinkedList;

/**
 *
 * @author david_perez
 */
public class Cola implements ColeccionInterfaz{
    LinkedList<Object> a;

    public Cola() {
        a = new LinkedList();
    }
    
   
    
    @Override
    public boolean estaVacia() {
       return a.isEmpty();
    }

    @Override
    public Object extraer() {
       return a.removeLast();
       
    }

    @Override
    public Object Primero() {
        return a.getFirst();
    }

    @Override
    public boolean añadir(Object c) {
        a.add(c);
        return true;
    }
}
