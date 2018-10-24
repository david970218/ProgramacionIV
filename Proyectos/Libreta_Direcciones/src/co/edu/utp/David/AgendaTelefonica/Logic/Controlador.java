/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.David.AgendaTelefonica.Logic;

import co.edu.utp.David.AgendaTelefonica.Archivos.AdministradorArchivos;
import co.edu.utp.David.AgendaTelefonica.Gui.VistaInterface;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author david_perez
 */
public class Controlador implements ActionListener {
    VistaInterface vista;
    //Contacto controlContactos;

    public Controlador(VistaInterface vista) {
        this.vista = vista;

    }
    

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Crear_contacto")){
            addActionPerformed();
        }
    }
    
    private void addActionPerformed(){
        if(!vista.getPformulario().isContact()){
            Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog((Component) vista,"Los Campos con * son obligatorios",
                   "No se puede crear el contacto", JOptionPane.ERROR_MESSAGE);
                    
        }else{
            String[][] cmp;
            cmp = vista.getPformulario().getComponentes();
            Contacto a;
            a = new Contacto(cmp[1],cmp[2],cmp[3]);
            if(!a.guardarContacto())
                JOptionPane.showMessageDialog((Component) vista,
                   "No se puede crear el contacto\n "
                 + "porque uno o varios numeros telefonicos ya existen en la libreta","Error", 
                JOptionPane.ERROR_MESSAGE);
            else{
            JOptionPane.showMessageDialog((Component) vista,"Contacto Creado con Exito",
            "Confirm Dialog",JOptionPane.INFORMATION_MESSAGE);
            vista.getPformulario().limpiarActionPerformed(null);
            }
        }
    }
    
}
