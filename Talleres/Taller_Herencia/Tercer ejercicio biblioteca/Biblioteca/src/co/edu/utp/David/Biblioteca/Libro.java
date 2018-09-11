/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.David.Biblioteca;

/**
 *
 * @author david_perez
 */
public class Libro extends LibroAbstracto{
    
    public Libro(String Codigo, String Titulo, int anioPlublicacion) {
        super(Codigo, Titulo, anioPlublicacion);
    }
    
    @Override
    public String toString(){
        return "Libro{\n" + super.toString() + "\n}";
    }
    
}
