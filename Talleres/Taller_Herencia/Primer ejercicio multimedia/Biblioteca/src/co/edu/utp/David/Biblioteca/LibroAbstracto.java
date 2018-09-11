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
public abstract class LibroAbstracto implements Prestable{
    final String Codigo,Titulo;
    final int anioPlublicacion;
    boolean Prestado;

    public LibroAbstracto(String Codigo, String Titulo, int anioPlublicacion) {
        this.Codigo = Codigo;
        this.Titulo = Titulo;
        this.anioPlublicacion = anioPlublicacion;
        this.Prestado = false;
    }

    @Override
    public String toString() {
        return "Codigo:           " + Codigo + "\nTitulo:           " + Titulo + ",\nanioPlublicacion: " + anioPlublicacion;
    }
   
    @Override
    public void prestar()
    {
     if(this.Prestado == false){
            System.out.println("Se ha prestado el Libro \n"+ this);
            this.Prestado = true;
        }
     else{
         System.err.println("No se puede Prestar el Libro \n" + this + "\nPorque ya se encuentra prestado" );
     }
     
    }
    
    @Override
    public boolean prestado(){
        return this.Prestado;
    }
    
    @Override
    public void devolver(){
        this.Prestado = true;
        System.out.println("El libro \n" + this +"\n Ha sido devuelto");
    }

    public String getCodigo() {
        return Codigo;
    }

    public int getAnioPlublicacion() {
        return anioPlublicacion;
    }
    
}
