/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.david.prestamos.presentacion.ultils;

import co.edu.utp.isc.david.prestamos.persistencia2.ControladorMenu;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author david
 */
public class VPrestamos extends JFrame{
    private menuB menu;
    private ControladorMenu cm;
    private registroClienteFrame cf;
    private FPrestamos f;
    private Ftime t;
    
    public VPrestamos(){
        t = new Ftime();
        menu = new menuB();
        setJMenuBar(menu);
        cm = ControladorMenu.getInstance();
        cm.setVista(this);
        cf = new registroClienteFrame();
        cf.setVisible(false);
        menu.SetControlador(cm);
        f = new FPrestamos();
        add(f);
        setSize(600,500);
        setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public registroClienteFrame getCf() {
        return cf;
    }

    public Ftime getT() {
        return t;
    }
    
    
}
