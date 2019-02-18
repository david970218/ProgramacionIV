/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.david.batallanaval.presentacion.Persistencia1;

import co.edu.utp.isc.david.batallanaval.presentacion.Persistencia2.Juego;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author david
 */
public class ControladorMenu implements ActionListener {
    Vista vista;

    public ControladorMenu(Vista vista) {
        this.vista = vista;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand() == "Reiniciar"){
            reiniciarJuego();
        }else if(e.getActionCommand() == "Ver Mapa")
                verSolucion();
        else if(e.getActionCommand() == "Acerca de")
                informacion();
        else if(e.getActionCommand() == "Salir")
            System.exit(0);
        else if(e.getActionCommand() == "Ayuda")
            ayuda();
    }

    private void reiniciarJuego() {
        String name;
        name = JOptionPane.showInputDialog("Nombre: ");
        if(name == null) name = "no name";
        vista.getPJuego().getJuego().reiniciarJuego(name);
    }

    private void ayuda(){
          String file = "Archivos\\Reglas.docx";
        try {
          Runtime.getRuntime().exec("cmd /c start " + file);
        } catch (Exception e) {
            System.err.println("a");
        }
    }
    private void verSolucion() {
        vista.getSolCom().setVisible(true);
    }

    private void informacion() {
        JOptionPane.showMessageDialog((Component) vista, "Acerca de desarrollo\n"
                + "Nombre Desarrollador: David Perez\n"
                + "Febrero 2019\n\n"
                + "Estudiante Ingenieria de sistemas y computacion\n"
                + "Universidad tecnologica de pereira (UTP)", "Informacion", 
        JOptionPane.INFORMATION_MESSAGE);
    }
    
}
