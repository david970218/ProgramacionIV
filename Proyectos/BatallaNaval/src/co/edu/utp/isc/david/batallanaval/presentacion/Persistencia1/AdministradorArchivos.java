/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.david.batallanaval.presentacion.Persistencia1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 * @author David Perez alvarado
 * Esta es la clase que maneja todo lo correspondiente a archivos 
 * como es Escritura, Lectura, Formateo de archivos de textos y seriaizables
 */

public class AdministradorArchivos {
    /**
     * 
     * @param archivo se le pasa como parametro un archivo serializable 
     * para guardar un contacto a la vez
     * @param c es el contacto a guardar
     * @throws FileNotFoundException 
     */
    
    public static void llenarArchivoSerializable(File archivo , Object c)
        throws FileNotFoundException{
        if(archivo.length() == 0){
            FileOutputStream fos =null;
            ObjectOutputStream  moos = null;
            try{
                fos = new FileOutputStream(archivo,true);
                moos = new ObjectOutputStream(fos);
                moos.reset();
                moos.writeUnshared(c);
                moos.reset();
                moos.close();
                }catch (IOException ex){}
        }else{
            FileOutputStream fos = null;
            MiObjectOutputStream  moos = null;
            try{
                fos = new FileOutputStream(archivo,true);
                moos = new MiObjectOutputStream(fos);
                moos.reset();
                moos.writeUnshared(c);
                moos.reset();
                moos.close();
                }catch (IOException ex) {}
        }
    }
    
    /**
     * 
     * @param archivo recibe un archivo serializable con contactos
     * @return retornatodos los contactos contenidos en el
     */
    
    public static Puntaje[] leerArchivoSerializable(File archivo){
        FileInputStream fis;
        Object[] c = new Puntaje[10];
        Object d;
        ObjectInputStream ois = null;
        if(archivo.exists() && archivo.length() != 0){
            try{
                int a = 1;
                fis = new FileInputStream(archivo);
                ois = new ObjectInputStream(fis);
                while(true){
                    d = ois.readObject();
                    c[a] = d;
                    a++;
                }
            }catch(FileNotFoundException ex) {} 
            catch (IOException | ClassNotFoundException ex) {}
            finally{
                try {
                    ois.close();
                }catch (IOException ex) {}
            }
        }
        return (Puntaje[])  c;
    }
    
    /**
     * 
     * @param Archivo recibe el archivo a ser limpiado
     * @throws FileNotFoundException
     * @throws IOException 
     */
    
    public static void LimpiarArchivo(File Archivo)
        throws FileNotFoundException, IOException{
        FileOutputStream fos = new FileOutputStream(Archivo);
        fos.close();      
    }
   
   /**
    * 
    * @param archivo se le pasa un archivo.txt 
    * para ser llenado con un objeto a la vez
    * @param c es el onjeto que se va a guardar
    * pero en formato de texto con la funcion toSring() 
    */
   
   public static void llenarArchivoTxt(File archivo, Object c){
       FileWriter fw = null;
       BufferedWriter bw = null;
       try {
            fw = new FileWriter(archivo,true);
            bw = new BufferedWriter(fw);
            bw.write(c.toString());
            bw.newLine();
       }catch (IOException ex) {}
       finally {
                try {
                    bw.close();
                 } catch (IOException ex) {}
        }
       
   }
   
   /**
    * 
    * @param archivo archivo que va a ser leido en todo su contenido
    * @return retorna una cadena de String que cada posicion
    * guarda una linea de texto que hay en el archivo
    */
   public static String[] leerArchivoTxt(File archivo) {
       FileReader fr = null;
       String[] objs = new String[1];
       BufferedReader br = null;
       if(archivo.exists() && archivo.length() !=0){
            try {
                 String aux;
                 int a = 1;
                 fr = new FileReader(archivo);
                 br = new BufferedReader(fr);
                 while((aux = br.readLine()) != null){
                     objs[a] = aux;
                     a++;
                 }
             }catch (FileNotFoundException ex) {}catch (IOException ex) {}
             finally {
                 try {
                     br.close();
                 } catch (IOException ex) {}
             }
        }
    return objs;
   }
   
   /**
    * 
    * @param serializable es el archivo el cual van a ser 
    * obtenidos todos los contactos habidos en el para eso se apoya en la funcion de la clase
    * @AdministradorArchivos  leerArchivoSerializable
    * @param txt
    * @return
    * @throws IOException 
    */
   public static boolean exportarContactos(File serializable,File txt) throws IOException{
       LimpiarArchivo(txt);
       int contador = 0;
       if(serializable.exists()){
           
           Object[] aux ;
           aux = leerArchivoSerializable(serializable);
           int a =1;
           while(aux[a] != null){
               contador ++;
               llenarArchivoTxt(txt,aux[a]);
               a++;
           }
                JOptionPane.showMessageDialog(null,"Total contactos exportados " + contador, 
                   "Contactos Exportados",  JOptionPane.INFORMATION_MESSAGE);
           return true;
       }
       return false;
   }
   /*
   public static boolean importarContactos(File serializable,File txt){
       if(txt.exists()){
           int total = 0,impor= 0,negados = 0;
           String[] aux;
           aux = leerArchivoTxt(txt);
           int a =1;
           while(aux[a] != null){
               String[][] creator;
               creator = convertirAStrings(aux[a].toCharArray());
               Contacto cntct;
               cntct = new Contacto(creator[1],creator[2],creator[3]);
               if(cntct.guardarContacto()){
                   impor +=1;
                   total += 1;
               }else{
                   negados +=1;
                   total ++;
               }
               a++;
           }
           JOptionPane.showMessageDialog(null,"Total contactos diponibles " + total + 
                   "\nContactos importados " + impor + "\nContactos no importados " + negados , 
                   "Contactos Importados",  JOptionPane.INFORMATION_MESSAGE);
           return true;
       }
       return false;
   }
   */
   
   private static String[][] convertirAStrings(char[] as) {
        String[] a = new String[7];
        Arrays.fill(a, "");
        boolean bandera = true;
        String[] b = new String[6];
        Arrays.fill(b, "");
        String[] c = new String[6];
        Arrays.fill(c, "");
        int aux = 0, j;
        for (int i = 1; i <= 11; i++) {
            for ( j = aux; j < as.length; j++) {
                if(i <=6){
                    if(as[j] != ';')
                        a[i] += as[j];
                    else
                        break;
                  }else{
                    if(bandera && as[j] != ';'){
                      if(as[j] == ':'){
                          bandera = false;
                      }else{
                          b[i-6] += as[j];
                      }
                    }else
                        if(as[j] != ';'){
                           c[i-6] += as[j];
                        }else
                            break;
                }
                
            }
          aux = j + 1;
          bandera = true;
        }
        String [][] d = new String[4][];
        d[1] = a;
        d[2] = b;
        d[3] = c;
        return d;
        }
}

