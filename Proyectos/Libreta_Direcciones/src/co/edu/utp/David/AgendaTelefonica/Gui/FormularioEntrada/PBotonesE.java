/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.David.AgendaTelefonica.Gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author David
 */
public class PBotonesE extends JPanel{
        JButton agregar,limpiar,salir;

        public PBotonesE(){
                initGui();
                setBackground(java.awt.Color.black);
        }

        private void initGui(){
                setLayout(new FlowLayout());
                setPreferredSize(new Dimension(400,200));
                setActions();
                agregarBoton(agregar,"Crear_contacto");
                agregarBoton(limpiar,"Limpiar");
                agregarBoton(salir,"Cerrar");
        }


        private void agregarBoton(JButton b, String name){
                b.setText(name);
                b.setBackground(Color.GRAY);
                add(b);
        }

        private void setActions(){
                agregar = new JButton();    
                limpiar = new JButton();
                salir = new JButton();
                
                
        }

        public JButton getSalir(){
            return salir;
        }

        public JButton getAgregar() {
                return agregar;
        }

        public JButton getLimpiar() {
                return limpiar;
        }

}
