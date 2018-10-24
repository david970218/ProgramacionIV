/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanwithobserver.Presentacion;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pacmanwithobserver.Logica.Juego;

/**
 *
 * @author david_perez
 */
public class PControles extends JPanel implements Observer {
    private final JButton abajo,
            arriba,
            derecha,
            izquierda;
    private final JLabel espacio1,
            espacio2;
    
    public PControles(){
        this.setLayout(new GridLayout(2,3,0,0));
        this.setBorder(BorderFactory.createTitledBorder(
        "Controles:->"));
        this.espacio1 = new JLabel("");
        this.add(espacio1);
        this.arriba = new JButton("^");
        this.add(arriba);
        this.espacio2 = new JLabel("");
        this.add(espacio2);
        this.izquierda = new JButton("<");
        this.add(izquierda);
        this.abajo = new JButton("v");
        this.add(abajo);
        this.derecha = new JButton(">");
        this.add(derecha);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public JButton getAbajo() {
        return abajo;
    }

    public JButton getArriba() {
        return arriba;
    }

    public JButton getDerecha() {
        return derecha;
    }

    public JButton getIzquierda() {
        return izquierda;
    }
    
   
    
}
