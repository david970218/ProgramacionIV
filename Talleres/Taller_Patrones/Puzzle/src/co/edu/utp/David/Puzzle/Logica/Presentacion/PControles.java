/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.David.Puzzle.Logica.Presentacion;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author david_perez
 */
public class PControles extends JPanel{
      private final JButton abajo,
            arriba,
            derecha,
            izquierda,
            desordenar;
    private final JLabel espacio1,
            espacio2;
    
    public PControles(){
        this.setLayout(new GridLayout(3,3,0,0));
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
        this.add(new JLabel(""));
        desordenar = new JButton("Reset");
        desordenar.setActionCommand("Desordenar");
        this.add(desordenar);
        this.add(new JLabel(""));
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

    public JButton getDesordenar() {
        return desordenar;
    }
    
    
}
