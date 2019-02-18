/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.david.batallanaval.presentacion;

import co.edu.utp.isc.david.batallanaval.presentacion.Persistencia1.Controlador;
import co.edu.utp.isc.david.batallanaval.presentacion.Persistencia2.Juego;
import co.edu.utp.isc.david.batallanaval.presentacion.Persistencia2.Jugador;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

/**
 *
 * @author Usuario UTP
 */
public class PDibujoCOM extends JPanel implements Observer{
      
  
    Jugador player;
    Juego juego;
    MouseEvent e,e1;
    Controlador c;
    public PDibujoCOM()
    {
         this.setSize(15*30 + 1,15*30 + 1);
    }
    
    public void setControlador(Controlador c){
        this.addMouseListener(c);
    }
    @Override
    public void paint(Graphics g){
        if(player != null){
            int[][] maze = player.getMaze();
                 for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if(maze[i][j] == 0 || maze[i][j] == 1 || maze[i][j] == 2 || maze[i][j] == 3 || maze[i][j] == 4)g.setColor(Color.cyan);
                if(maze[i][j] == -1) g.setColor(Color.gray);
                if(maze[i][j] == 5) g.setColor(Color.red);
                if(maze[i][j] == 6) g.setColor(Color.pink);
                if(maze[i][j] == 7) g.setColor(Color.orange);
                if(maze[i][j] == 8) g.setColor(Color.BLUE);
                
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
    
    public void update(MouseEvent e){
        this.e = e;
        int x = (int) Math.floorDiv(e.getX(), 30);
        int y = (int) Math.floorDiv(e.getY(), 30);
        juego.shotPlayer1(y, x);
        repaint();
    }
    
    @Override
    public void update(Observable o, Object o1) {
         juego = (Juego) o;
         if(juego.isDesactivarMouse()){
             this.setEnabled(false);
         }else
             this.setEnabled(true);
         player = juego.getCOM();
         repaint();
    }

}
