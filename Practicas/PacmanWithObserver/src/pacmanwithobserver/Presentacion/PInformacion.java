/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanwithobserver.Presentacion;

import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pacmanwithobserver.Logica.Juego;

/**
 *
 * @author david_perez
 */
public class PInformacion extends JPanel implements Observer{

    private JLabel puntos;
    
    public PInformacion(){
        this.setLayout(new FlowLayout());
        this.setBorder(BorderFactory.createTitledBorder("Puntaje"));
        this.puntos = new JLabel("Puntos: ");
        this.add(puntos);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        this.puntos.setText("Puntos: " +((Juego)arg).getPuntos()*10);   
   
    }
    
}
