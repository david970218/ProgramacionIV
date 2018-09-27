/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.David.ArchivoSerializable;

import java.io.IOException;

/**
 *
 * @author utp
 */
public class Main_Class {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Camisetas camisaa;
        ArchivoSerializable archivo =new ArchivoSerializable();
        camisaa = new Camisetas("Rojo","xl","gucci");
        archivo.escribirObjeto(camisaa);
        archivo.escribirObjeto(camisaa);
        archivo.escribirObjeto(camisaa);
        archivo.mostrarArchivo();
        //System.out.println(camisaa);
    }
    
}
