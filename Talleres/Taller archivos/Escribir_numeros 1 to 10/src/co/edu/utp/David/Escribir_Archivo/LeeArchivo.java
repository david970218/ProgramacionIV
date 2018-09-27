/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.David.Escribir_Archivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david_perez
 */
public class LeeArchivo {
    private  File archivo;
    private FileReader fr;
    private BufferedReader br;
    
    LeeArchivo(String Pahtname)
    {
        
        archivo = new File(Pahtname);
       
    }
    
    private void abrirBuffer() throws FileNotFoundException
    {
        fr = new FileReader(archivo);
        br = new BufferedReader(fr);
    }
    
    public double calculaPromedio()
    {
        double a,suma = 0,contador = 0;
        
        String numero;
        try{
            abrirBuffer();
            while((numero = br.readLine()) != null)
            {
                
                suma += Integer.valueOf(numero);
                if(Integer.valueOf(numero) != 0)
                    contador +=1;
            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(LeeArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return suma/contador;
    }
    
}
