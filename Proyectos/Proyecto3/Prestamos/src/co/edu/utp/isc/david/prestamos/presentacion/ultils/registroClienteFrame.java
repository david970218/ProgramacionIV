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
public class registroClienteFrame extends JFrame{
    private final Formulario_Ingreso fi;
    public registroClienteFrame(){
        fi = new Formulario_Ingreso();
        this.add(fi);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        this.setSize(800,400);
        this.setVisible(true);
        this.setResizable(false);
    }
    
}
