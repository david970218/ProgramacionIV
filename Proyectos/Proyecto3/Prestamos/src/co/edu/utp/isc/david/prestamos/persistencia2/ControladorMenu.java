/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.david.prestamos.persistencia2;

import co.edu.utp.isc.david.prestamos.persistencia1.Cooperativa;
import co.edu.utp.isc.david.prestamos.presentacion.ultils.VPrestamos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author david
 */
public class ControladorMenu implements ActionListener{
    private static ControladorMenu instance;
    VPrestamos vista;
    
    
    private ControladorMenu(){
       
    }
    public void setVista(VPrestamos vista){
        this.vista = vista;
    }
    
    public static ControladorMenu getInstance(){
        if(instance == null){
            instance = new ControladorMenu();
        }
        return instance;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
            switch(e.getActionCommand()){
                case"Nuevo cliente":
                    vista.getCf().setVisible(true);
                    break;
                case "Info economica":
                    info();
                    break;
                case "Salir":
                    System.exit(1);
                    break;
                case "Timer":
                    vista.getT().setVisible(true);
                    break;
                   
            }
    }

    private void info() {
        Cooperativa coop = Cooperativa.getInstance();
        JOptionPane.showMessageDialog(null,"Dinero Disponble: " + String.format("%.2f", coop.getDineroParaPrestar())+ 
                "\nDinero Prestado " + String.format("%.2f", coop.getDineroPrestado(), "Info",
                        JOptionPane.INFORMATION_MESSAGE));
    }
    
}
