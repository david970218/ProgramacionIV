/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.David.Escribir_Archivo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david_perez
 */
public class Archivo {
    private File archivo;
    String Pahtname;
    private FileWriter fw;
    private BufferedWriter bw;
    
    public Archivo(String Pahtname) throws IOException
    {
        this.Pahtname = Pahtname;
        archivo = new File(Pahtname);
    }
    
    public void llenarArchivo(int a){
        this.abrirBuffer();
        try {
                
                bw.write(Integer.toString(a) + "\n");
                bw.close();
                
            } catch (IOException ex) {
                Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    
    private void abrirBuffer()
    {
        try{
            fw = new FileWriter(Pahtname , true); // el valor true hace que el archivo abierto
            bw = new BufferedWriter(fw);         //no pierda el contenido que ya tenia
            
            
        } 
        catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private void CerrarBuffer()
    {
        try{
        this.bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void eliminarArchivo(){archivo.delete();}
    public void vacearArchivo() throws FileNotFoundException, IOException
    {
        FileOutputStream fso = new FileOutputStream(Pahtname);
        fso.close();
    }
    
}
