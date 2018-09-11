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
public class Revista extends LibroAbstracto{

    String Numero;
    public Revista(String Codigo, String Titulo, int anioPlublicacion, String Numero) {
        super(Codigo, Titulo, anioPlublicacion);
        this.Numero = Numero;
    }

    @Override
    public String toString() {
        return "Revista{\n" + super.toString() + "\nNumero:           " + Numero + "\n}";
    }

    
}
