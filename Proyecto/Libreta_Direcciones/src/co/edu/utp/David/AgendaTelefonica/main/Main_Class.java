/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.David.AgendaTelefonica.main;
import co.edu.utp.David.AgendaTelefonica.Archivos.AdministradorArchivos;
import co.edu.utp.David.AgendaTelefonica.Archivos.Filtro;
import co.edu.utp.David.AgendaTelefonica.Logic.*;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;



/**
 *
 * @author David
 */
public class Main_Class{
   
    /**
     * 
     * @param args the command line arguments
     */
    public static File jfile(){
        
        return null;
    }
    
    public static void main(String[] args) throws IOException  {
       Logica l = new Logica();
       Contacto d,d1;
       Contacto[] lista;
       lista = new Contacto[30];
       String[] a = { "","David" , "Perez" ,"Alvarado" ,"dvd", "cl34 no 23-41","davidperez24@utp.edu.co"};
       String[] b = {"","Movil","Movil","CC","",""};
       String[] c = {"","3","2","1","",""};
       String[] x = {"", "4","5","6", "" ,""};
       d = new Contacto(a,b,c);
       d1 = new Contacto(a,b,x);
        char[] as = d.toString().toCharArray();
        //System.out.println(as);
        lista[1] = d;
        lista[2] = d1;
        //String[][] h;
        //h = convertirAStrings(as);
        //Contacto dd = new Contacto(h[1],h[2],h[3]);
        Contacto.guardarListaContacto(lista);
        File in = new File("in.in") , out = new File("out.out");
        AdministradorArchivos.importarContactos(Contacto.getArchivo(),in);
        AdministradorArchivos.exportarContactos(Contacto.getArchivo(), out);
    }

    
        
        
        
    }
    

