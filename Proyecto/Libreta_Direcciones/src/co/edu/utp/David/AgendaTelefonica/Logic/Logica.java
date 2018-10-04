/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.David.AgendaTelefonica.Logic;

import co.edu.utp.David.AgendaTelefonica.Gui.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author david_perez
 */
public class Logica {
    FFormulario frame;
    public Logica(){
       
       frame = new FFormulario();
       frame.setVisible(true);
       setActions();
    }
    private void setActions(){
        frame.getPformulario().getPanelBotones().getAgregar().addActionListener(new ActionListener(){
                @Override
                        public void actionPerformed(ActionEvent evt){
                                addActionPerformed(evt);
                         }
        });
    }
    
    private void addActionPerformed(ActionEvent evt){
        if(!frame.getPformulario().isContact())
           JOptionPane.showMessageDialog(frame,"Los Campos con * son obligatorios",
                   "No se puede crear el contacto", JOptionPane.ERROR_MESSAGE);
        else{
            String[][] cmp;
            cmp = frame.getPformulario().getComponentes();
            Contacto a;
            a = new Contacto(cmp[1],cmp[2],cmp[3]);
            if(!a.guardarContacto())
                JOptionPane.showMessageDialog(frame,
                   "No se puede crear el contacto\n "
                 + "porque el uno o varios numeros telefonicos ya existen en la libreta","", 
                JOptionPane.ERROR_MESSAGE);
            else{
            JOptionPane.showMessageDialog(frame,"Contacto Creado con Exito",
            "Confirm Dialog",JOptionPane.INFORMATION_MESSAGE);
            frame.getPformulario().limpiarActionPerformed(null);
            }
                
        }
    }
}
