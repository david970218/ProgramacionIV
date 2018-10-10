/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.David.AgendaTelefonica.Gui.TablasDeSalida;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author david_perez
 */
public class mijcombobox extends JComboBox{

    public mijcombobox() {
        crearCBM();
    }
        
    
    private void crearCBM(){
        DefaultComboBoxModel cbm = new DefaultComboBoxModel(new String[]{
            "Nombre",
            "Primer Apellido",
            "Segundo Apellido",
            "Alias",
            "Direccion",
            "E-mail",
            "Numero Telefono",
            });
         this.setModel(cbm);
    }
}
