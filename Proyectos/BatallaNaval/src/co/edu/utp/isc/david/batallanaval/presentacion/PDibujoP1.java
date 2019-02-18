/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.david.batallanaval.presentacion;

import co.edu.utp.isc.david.batallanaval.presentacion.Persistencia2.Juego;
import co.edu.utp.isc.david.batallanaval.presentacion.Persistencia2.Jugador;
import java.awt.Color;
import java.awt.Graphics;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

/**
 *
 * @author Usuario UTP
 */
public class PDibujoP1 extends JPanel implements Observer{
    Jugador player1;
    Juego juego;
    public PDibujoP1(){
        this.setSize(15*30 + 1 ,15*30 + 1);
        
    }
  
    @Override
    public void paint(Graphics g){
        if(player1 != null){
            int[][] maze = player1.getMaze();
                 for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if(maze[i][j] == 0)
                g.setColor(Color.cyan);
                if(maze[i][j] == -1)
                g.setColor(Color.gray);
                if(maze[i][j] > 4)
                g.setColor(Color.white);
                if(maze[i][j] == 1)
                g.setColor(Color.red);
                if(maze[i][j] == 2)
                g.setColor(Color.pink);
                if(maze[i][j] == 3)
                g.setColor(Color.ORANGE);
                if(maze[i][j] == 4)
                g.setColor(Color.BLUE);
                 
                
                g.fillRect(30*j, 30*i, 30, 30);
                g.setColor(Color.BLACK);
                g.drawRect(30 * j,30 * i, 30, 30);
            }
        }
             
        
        }
    }
    
   
    
    @Override
    public void update(Observable o, Object o1) {
         juego = (Juego) o;
         player1 = juego.getPlayer1();
         repaint();
    }

    
}
