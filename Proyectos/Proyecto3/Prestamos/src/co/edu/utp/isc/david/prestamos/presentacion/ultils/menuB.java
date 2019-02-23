/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.david.prestamos.presentacion.ultils;

import co.edu.utp.isc.david.prestamos.persistencia2.ControladorMenu;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author david
 */
public class menuB extends JMenuBar{
    JMenu opciones;
    JMenuItem regP;
    JMenuItem salir;
    JMenuItem info , time;
    
    public  menuB(){
        opciones = new JMenu("Opciones");
        add(opciones);
        regP = new JMenuItem("Nuevo cliente");
        info = new JMenuItem("Info economica");
        salir = new JMenuItem("Salir");
        time = new JMenuItem("Timer");
        opciones.add(regP);
        opciones.add(time);
        opciones.add(info);
        opciones.add(salir);
    }
    
    public void SetControlador(ControladorMenu c){
        regP.addActionListener(c);
        info.addActionListener(c);
        salir.addActionListener(c);
        time.addActionListener(c);
    }
}
