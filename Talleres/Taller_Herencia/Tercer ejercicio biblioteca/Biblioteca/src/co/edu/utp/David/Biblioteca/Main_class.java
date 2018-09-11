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
public class Main_class {

    /**
     * @param a
     * 
     */
    
    public static void PublicacionesAntes(LibroAbstracto[] a, int año)
    {
        int contador = 0;
        
        for(LibroAbstracto b:a)
        {
            if(b == null)
              continue;
            if(b.getAnioPlublicacion()<= año)
            {
                contador++;
            }
        }
        System.out.println("Hay "+ contador + " Libros publicados antes de " + año);
    }
    public static  void cuentaPrestados(Prestable[] a)
    {
        int contador = 0;
        for(Prestable b:a)
        {
            if(b == null)
               continue;
            if(b.prestado() == true){
                System.out.println(b);
                contador++;
            }
            
        }
        System.out.println("Hay " + contador + " Libros prestados");
    }
    public static void main(String[] args) {
        LibroAbstracto[] lista;
        lista = new LibroAbstracto[6];
        //**********************************************************************
        lista[0] = new Libro("21454554","Libro ejemplo1",1998);
        lista[2] = new Libro("454546546","Libro ejemplo2",1985);
        lista[1] = new Revista("313131","Revista1",1975,"545466");
        lista[3] = new Revista("541654654","Revista2",1936,"32135");
        //**********************************************************************
        lista[3].prestar();
        //**********************************************************************
        cuentaPrestados(lista);
        PublicacionesAntes(lista,1990);
        //**********************************************************************
        for(LibroAbstracto a:lista){
           if(a == null)
               continue;
            System.out.println(a);
            
        }
        //**********************************************************************
    }
    
}
