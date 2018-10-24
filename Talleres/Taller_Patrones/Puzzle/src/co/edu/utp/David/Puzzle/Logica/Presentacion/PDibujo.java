/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.David.Puzzle.Logica.Presentacion;

import co.edu.utp.David.Puzzle.Logica.Ficha;
import co.edu.utp.David.Puzzle.Logica.Juego;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

/**
 *
 * @author david_perez
 */
public class PDibujo extends JPanel implements Observer{
    private Object objObservable;
    
    @Override
    public void paint(Graphics g){
      Juego juego = (Juego)objObservable;
      g.setColor(Color.red);
      g.fillRect(0,0,this.getWidth(),this.getHeight());
        for (Ficha ficha:juego.getFichas()) {
            g.drawImage(ficha.getImagen(),ficha.getX() *90,ficha.getY() *90,90,90, this);
        }
      
    }
    
    
    
    @Override
    public void update(Observable o, Object arg) {
        objObservable = arg;
        this.repaint();
    }
    
}
