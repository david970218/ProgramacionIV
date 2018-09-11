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
public class Pelicula extends Multimedia {
    String actorPrincipal,actrizPrincipal;

    public Pelicula( String Titulo, String Autor, String Formato, String Duracion, String actrizPrincipal, String actorPrincipal) {
        super(Titulo, Autor, Formato, Duracion);
        this.actrizPrincipal = actrizPrincipal;
        this.actorPrincipal = actorPrincipal ;
    }
   
    @Override
    public String toString()
{    
    if(actrizPrincipal == null)
        return "Pelicula{\n" + super.toString() + "Actor Principal: " + actorPrincipal + "\n}\n";
    else
        return "Pelicula{\n" + super.toString() +  "Actriz Principal: "+ actrizPrincipal + "\n}\n";
}
    
}
