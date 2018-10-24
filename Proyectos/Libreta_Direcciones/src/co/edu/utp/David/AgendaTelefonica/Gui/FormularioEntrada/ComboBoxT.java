/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.David.AgendaTelefonica.Gui;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author David
 */
public class ComboBoxT  extends JComboBox{
    ComboBoxModel cbm;
    public ComboBoxT()
    {
       crearCBM();
      
    }
    
    public void crearCBM(){
          cbm = new DefaultComboBoxModel(new String[]{
           "","Movil",
          "Trabajo",
          "Casa",
          "Principal",
          "Fax del trabajo",
          "Fax de Casa",
          "Otro",
          });
         this.setModel(cbm);
    }
}
