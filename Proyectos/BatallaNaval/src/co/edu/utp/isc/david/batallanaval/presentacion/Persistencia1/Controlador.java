/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.david.batallanaval.presentacion.Persistencia1;

import co.edu.utp.isc.david.batallanaval.presentacion.PDibujoCOM;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author utp
 */
public class Controlador implements MouseListener{
    private PDibujoCOM tablero;
    
    public Controlador(PDibujoCOM tablero){
        this.tablero = tablero;
    }

  
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        tablero.update(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
      ;
    }

    @Override
    public void mouseExited(MouseEvent e) {
       
    }
    
}
