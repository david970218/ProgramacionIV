/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import co.edu.utp.David.Taller_Herencia_Multimedia.*;

/**
 *
 * @author David
 */
public class Main_CLass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         //***************************************************************************************************************************
        ListaMultimedia m;
         //***************************************************************************************************************************
        m = new ListaMultimedia(10);
        //***************************************************************************************************************************
        m.add(new Pelicula("Avengers","Desconocido","Mp4","3h","Scarlet Jhohanson",null));
        m.add(new Pelicula("Piratas del caribe","Desconocido","Mp4","3h",null,"jack Sparrow"));
        m.add(new Pelicula("La Monja","Desconocido","Mp4","4h","Desconocido",null));
        m.add(new Pelicula("Avengers","Desconocido","Mp4","3h","Scarlet Jhohanson",null));
         //***************************************************************************************************************************
        for(int i = 0; i< m.Size(); i++)
            System.out.println(m.get(i));
         //***************************************************************************************************************************
       System.out.println(m.get(0).equals(m.get(2)));
       System.out.println(m.Size());
    }
    
}
