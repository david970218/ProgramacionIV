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
public class Pila implements ColeccionInterfaz {
    Object[] pila;
    private int cabeza,cola;
    private int tamaño;
    private int contador;
    
    
    public Pila(int tamaño){
        this.tamaño = tamaño;
        cabeza = cola = tamaño;
        pila = new Object[tamaño+1];
    }
    @Override
    public boolean estaVacia() {
        return cabeza == cola;
    }

    @Override
    public Object extraer() {
        Object a;
        a = pila[cabeza];
        pila[cabeza] = null;
        cabeza--;
        return a; 
    }

    @Override
    public Object Primero() {
       return pila[cabeza];
    }

    @Override
    public boolean añadir(Object c) {
      if(cola != 0)
      {
          pila[cola] = c;
          cola--;
          return true;
      }
      else
      {
          System.err.println("no se pudo añadir el objeto a la pila");
          return false;
      }
    }
    
    
}
