/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.david.prestamos.persistencia2;

import co.edu.utp.isc.david.prestamos.persistencia1.Cooperativa;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author david
 */
public class Memento implements Serializable{
   private Cooperativa state;
   private static Memento instance;
   private final String archivo ="memento.txt";
   private File arch;
   
   private Memento(){
       arch = new File(archivo);
       if(!arch.exists()){
           try {
                   arch.createNewFile();
               
           } catch (Exception e) {
               System.out.println(e);
           }
                   
       }
   }

   public static Memento getInstance(){
       if(instance == null)
           instance = new Memento();
       return instance;
       
   }
   
    public void setState(Cooperativa state) {
        this.state = state;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        
        try {
            LimpiarArchivo(arch);
            fos = new FileOutputStream(arch);
            oos = new ObjectOutputStream(fos);
            oos.reset();
            oos.writeUnshared(state);
            oos.reset();
            oos.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo salio mal con el guardado del state\n"
                    + "By: Memento","Error",JOptionPane.ERROR_MESSAGE);
        }
        

        
    }
   
   
    public Cooperativa getState() {
        FileInputStream fis;
        ObjectInputStream ois;
        
        if(arch.exists()){
            try {
                fis = new FileInputStream(arch);
                ois = new ObjectInputStream(fis);
                state = (Cooperativa) ois.readObject();
                ois.close();
            } catch (Exception e) {
                System.err.println(e);
            }
            
        }
        return state;
        
    }
   
    
     private void LimpiarArchivo(File Archivo)
        throws FileNotFoundException, IOException{
        FileOutputStream fos = new FileOutputStream(Archivo);
        fos.close();      
    }
   
   
}
