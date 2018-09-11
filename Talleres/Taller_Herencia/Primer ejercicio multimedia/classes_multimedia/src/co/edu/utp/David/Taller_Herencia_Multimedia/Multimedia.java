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
public class Multimedia {
       public final String Titulo, Autor , Formato, Duracion;

    public Multimedia(String Titulo, String Autor, String Formato, String Duracion) {
        this.Titulo = Titulo;
        this.Autor = Autor;
        this.Formato = Formato;
        this.Duracion = Duracion;
    }
    public String getTitulo() {return Titulo;}
    public String getAutor()  {return Autor;}
    public String getFormato() {return Formato;}
    public String getDuracion() {return Duracion;}

    @Override
    public String toString() {
        return "Titulo:          " + Titulo + ",\nAutor:           " + Autor + ",\nFormato:         " + Formato + ",\nDuracion:        " + Duracion + ",\n";
    }
  
    public boolean equals(Multimedia a){
            
         return ((a.getTitulo().equals(this.getTitulo())) && (a.getAutor().equals(this.getAutor())));
        
    }


    
    
        
    
}
