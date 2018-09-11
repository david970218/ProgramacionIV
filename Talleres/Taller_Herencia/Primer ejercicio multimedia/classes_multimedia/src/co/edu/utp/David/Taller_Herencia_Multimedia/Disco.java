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
public class Disco extends Multimedia {
    String genero;
    public Disco(String Titulo, String Autor, String Formato, String Duracion) {
        super(Titulo, Autor, Formato, Duracion);
    }
    
    public Disco(String Titulo, String Autor){super(Titulo,Autor,null,null);}

    @Override
    public String toString() {
        return "Disco{\n" + super.toString() + "Genero=  " + genero + '}';
    }
    
    
}
