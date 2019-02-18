/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.david.batallanaval.presentacion;

import co.edu.utp.isc.david.batallanaval.presentacion.Persistencia1.Controlador;
import co.edu.utp.isc.david.batallanaval.presentacion.Persistencia2.Juego;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

/**
 *
 * @author utp
 */
public class Tablero extends JPanel implements Observer {
    MouseEvent e,e1;
    Juego juego;
    Controlador c;
    
    public void setControlador(Controlador c){
        this.addMouseListener(c);
    }
   /* 
    public void paint(Graphics g){
      
       if(juego != null){

       int [][] maze = juego.getMaze();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if(maze[i][j] == 0 || maze[i][j] == 1 || maze[i][j] == 2)
                g.setColor(Color.cyan);
                if(maze[i][j] == -1)
                g.setColor(Color.gray);
                if(maze[i][j] == 3)
                g.setColor(Color.ORANGE);
                
                g.fillRect(30*j, 30*i, 30, 30);
                g.setColor(Color.BLACK);
                g.drawRect(30 * j,30 * i, 30, 30);
            }
        }
        if(e1!= null){
        int x = (int) Math.floorDiv(e1.getX(), 30);
         x *=30;
          int y = (int) Math.floorDiv(e1.getY(), 30);
         y *=30;
         g.setColor(Color.red);
         g.fillRect(x, y, 30, 30);
            System.out.println(x + " " + y );
         g.setColor(Color.BLACK);
         g.drawRect(x, y, 30, 30);
            
        }
        
        
        
    }
    
    }
    
   

    public void update(MouseEvent e) {
        this.e = e;
        int x = (int) Math.floorDiv(e.getX(), 30);
        int y = (int) Math.floorDiv(e.getY(), 30);
        juego.shot(y, x);
        repaint();
    }

    @Override
    public void update(Observable o, Object arg) {
        this.juego = (Juego) o;
        
        repaint();
    }

    public void update2(MouseEvent e) {
        e1 = e;
        repaint();
    }
*/

    @Override
    public void update(Observable o, Object o1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
