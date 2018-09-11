/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.David.Taller_Herencia_Multimedia;


/**
 *
 * @author David
 */
public class ListaMultimedia {
    int tamaño;
    int numero_elementos = 0;
    Multimedia[] milista;

    public ListaMultimedia(int tamaño) {
        this.tamaño = tamaño;
        milista = new Multimedia[tamaño];
    }
    
    public int Size(){return numero_elementos;}
    
   public  boolean add(Multimedia m){
       if(numero_elementos >= tamaño)
           System.err.println("no se pueden agregar mas elementos a la lista");
       else{
           milista[numero_elementos] = m;
           numero_elementos+=1;
       }
       return (numero_elementos == tamaño);
   } 
    public Multimedia get(int posicion)
    {
        if(posicion > numero_elementos){
            System.err.println("No existe elementos en la poscicion indicada: " + posicion );
            return null;
        }else
            return milista[posicion];
        
            
    }
    
}
