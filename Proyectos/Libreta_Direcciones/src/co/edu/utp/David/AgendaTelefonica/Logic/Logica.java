/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.David.AgendaTelefonica.Logic;

import co.edu.utp.David.AgendaTelefonica.Archivos.AdministradorArchivos;
import co.edu.utp.David.AgendaTelefonica.Gui.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author david_perez
 */


public class Logica {
    FFormulario frame;
    Controlador controlador;
    private static BusquedaContactos search;
    public final static int Numero_Contactos = 10000,
    Cantidad_Telefonos = 5;
    public Logica(){
       frame = new FFormulario();
       controlador = new Controlador(frame);
       frame.setControlador(controlador);
    }
    
    public void iniciarPrograma(){
        frame.setVisible(true);
    }

    
    public static void setBusqueda(BusquedaContactos a){
        Logica.search = a;
    }

    public static Contacto[] buscar(String busqueda){
        Contacto[] ListaContacto;
        ListaContacto = search.listaQueCumpleElRequisito(
        AdministradorArchivos.leerArchivoSerializable(Contacto.getArchivo()),busqueda);
        return ListaContacto;
    }
    public static BusquedaContactos getSearch() {
        return search;
    }    
}
