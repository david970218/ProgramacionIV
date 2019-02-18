/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.david.batallanaval.presentacion;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author david
 */
public class MenuBar extends JMenuBar {
    JMenuItem reinicio;
    JMenu opciones;
    JMenuItem solucion;
    JMenuItem ayuda;
    JMenuItem info;
    JMenuItem salir;
    
    public MenuBar(){
        opciones = new JMenu("Opciones");
        add(opciones);
        reinicio = new JMenuItem("Reiniciar");
        opciones.add(reinicio);
        solucion = new JMenuItem("Ver Mapa");
        opciones.add(solucion);
        info = new JMenuItem("Acerca de");
        opciones.add(info);
        ayuda = new JMenuItem("Ayuda");
        salir = new JMenuItem("Salir");
        opciones.add(ayuda);
        opciones.add(salir);
    }

    public JMenuItem getAyuda() {
        return ayuda;
    }

    public JMenuItem getInfo() {
        return info;
    }

    
    public JMenuItem getSalir() {
        return salir;
    }
    
    

    public JMenuItem getReinicio() {
        return reinicio;
    }

    public JMenuItem getSolucion() {
        return solucion;
    }
    
    
}
