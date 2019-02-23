/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.david.prestamos.presentacion.ultils;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author david
 */
public class Ftime extends JFrame{
    PTime paneltiempo;
    
   public Ftime(){
        paneltiempo = new PTime();
        add(paneltiempo);
        setSize(229,100);
        this.setVisible(false);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }
}
