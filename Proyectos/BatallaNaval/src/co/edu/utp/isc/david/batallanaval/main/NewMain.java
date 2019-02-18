/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.david.batallanaval.main;

import co.edu.utp.isc.david.batallanaval.presentacion.MiFrame;
import co.edu.utp.isc.david.batallanaval.presentacion.Persistencia1.ControladorMenu;
import co.edu.utp.isc.david.batallanaval.presentacion.Persistencia1.Vista;

/**
 *
 * @author utp
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Vista vista = new MiFrame();
       ControladorMenu cm = new ControladorMenu(vista);
       vista.setControlador(cm);
   
         
    }
    
}
