/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.David.AgendaTelefonica.Archivos;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author David
 */
public class MiObjectOutputStream extends ObjectOutputStream {
    MiObjectOutputStream(OutputStream os)throws IOException{
        super(os);
}
    protected  MiObjectOutputStream() throws IOException{
        super();
    }
    @Override
    protected void writeStreamHeader() throws IOException{
       
    }
}
