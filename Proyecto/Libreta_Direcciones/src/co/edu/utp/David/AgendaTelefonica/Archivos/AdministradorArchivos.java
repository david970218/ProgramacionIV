/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.David.AgendaTelefonica.Archivos;
import co.edu.utp.David.AgendaTelefonica.Logic.Contacto;
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
import java.io.Serializable;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author David
 */
public class AdministradorArchivos {
    public static void llenarArchivoSerializable(File archivo , Object c) throws FileNotFoundException{
        if(archivo.length() == 0)
        {
            FileOutputStream fos =null;
            ObjectOutputStream  moos = null;
         try{
         fos = new FileOutputStream(archivo,true);
            moos = new ObjectOutputStream(fos);
            moos.writeUnshared(c);
            moos.close();
        } catch (IOException ex) {}
            
        }
        else
        {
        FileOutputStream fos = null;
        MiObjectOutputStream  moos = null;
        try{
         fos = new FileOutputStream(archivo,true);
            moos = new MiObjectOutputStream(fos);
            
            moos.writeUnshared(c);
            
            moos.close();
          
        } catch (IOException ex) {}
        
        }
    }
    
 
    
    public static Contacto[] leerArchivoSerializable(File archivo){
        FileInputStream fis;
        Object[] c = new Contacto[10000];
        ObjectInputStream ois = null;
        if( archivo.exists() && archivo.length() != 0 ){
        try{
            int a = 1;
            fis = new FileInputStream(archivo);
            ois = new ObjectInputStream(fis);
            
            while(true){
         
            c[a] = ois.readObject();
                System.out.println(c[a]);
             a++;
                
            }
            
        } catch (FileNotFoundException ex) {} 
          catch (IOException | ClassNotFoundException ex) {}
        finally{
            try {
                ois.close();
            } catch (IOException ex) {}
            
            
        }
        }
        return (Contacto[])  c;
    }
    
   public static void LimpiarArchivo(File Archivo) throws FileNotFoundException, IOException{
        FileOutputStream fos = new FileOutputStream(Archivo);
        fos.close();      
    }
   public static void llenarArchivoTxt(File archivo, Object c){
       FileWriter fw = null;
       BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo,true);
            bw = new BufferedWriter(fw);
            bw.write(c.toString());
            bw.newLine();
        } catch (IOException ex) {
            Logger.getLogger(AdministradorArchivos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(AdministradorArchivos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
   }
   
   public static String[] leerArchivoTxt(File archivo) {
       FileReader fr = null;
       String[] objs = new String[10000];
       BufferedReader br = null;
       if(archivo.exists() && archivo.length() !=0){
        try {
            String aux;
            int a = 1;
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            while((aux = br.readLine()) != null){
                System.out.println(aux);
                objs[a] = aux;
                a++;
            }
        } catch (FileNotFoundException ex) {}catch (IOException ex) {}
        finally {
            try {
                br.close();
            } catch (IOException ex) {}
        }
       }
   return objs;
   }
   
   public static boolean exportarContactos(File serializable,File txt) throws IOException{
       LimpiarArchivo(txt);
       if(serializable.exists()){
           
           Contacto[] aux ;
           aux = leerArchivoSerializable(serializable);
           System.out.println();
           int a =1;
           while(aux[a] != null){
               llenarArchivoTxt(txt,aux[a]);
               a++;
           }
           return true;
       }
       return false;
   }
   
   public static boolean importarContactos(File serializable,File txt){
       if(txt.exists()){
           String[] aux;
           aux = leerArchivoTxt(txt);
           System.out.println();
           int a =1;
           while(aux[a] != null){
               String[][] creator;
               creator = convertirAStrings(aux[a].toCharArray());
               Contacto cntct;
               cntct = new Contacto(creator[1],creator[2],creator[3]);
               System.out.println(cntct.guardarContacto());
               a++;
           }
           return true;
       }
       return false;
   }
   
   
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

