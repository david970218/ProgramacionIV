/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.David.ArchivoSerializable;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import static jdk.nashorn.internal.parser.TokenType.EOF;

/**
 *
 * @author utp
 */
public class ArchivoSerializable {
    private File file;
    private ObjectOutputStream oos;
    private FileOutputStream fos;
    private ObjectInputStream ois;
    private FileInputStream fis;
    
    ArchivoSerializable() throws IOException{
        file = new File("Camisas.txt");
    }
    
    private void abrirBufferedWriter() throws FileNotFoundException, IOException
    {
        fos = new FileOutputStream(file);
        oos = new ObjectOutputStream(fos);
    }
    
    private void abrirBufferedReader() throws FileNotFoundException, IOException
    {
        fis = new FileInputStream(file);
        ois = new ObjectInputStream(fis);
    }
    
    public void mostrarArchivo() throws IOException, ClassNotFoundException, EOFException{
        abrirBufferedReader();
        Serializable a;
        
        while( (a = (Camisetas) ois.readObject()) != null )
        {
 
            System.out.println(a);
        }
    }
    
    
    
    
    
    public void escribirObjeto(Serializable c) throws IOException
    {
        abrirBufferedWriter();
        oos.writeObject(c);
        oos.close();
    }
    
}
