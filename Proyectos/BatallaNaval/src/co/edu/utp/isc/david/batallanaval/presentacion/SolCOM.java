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
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

/**
 *
 * @author utp
 */
public class SolCOM extends JFrame implements Observer {
    Juego juego;
    Controlador c;
    
    public SolCOM(){
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        this.setSize(15*30,15*30+31);
        this.setResizable(false);
    }
    @Override
    public void paint(Graphics g){
       
       if(juego != null){

       int [][] maze = juego.getCOM().getMaze();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
               
                if(maze[i][j] != 0 && maze[i][j] != -1)
                g.setColor(Color.ORANGE);
                if(maze[i][j] == -1 || maze[i][j] == 0)
                g.setColor(Color.WHITE);
                
                g.fillRect(30*j , 30*i + 31, 30, 30);
                g.setColor(Color.BLACK);
                g.drawRect(30 * j,30 * i +31 , 30, 30);
            }
        }
        
        
        
        
    }
    
    }
    

    @Override
    public void update(Observable o, Object arg) {
        this.juego = (Juego) o;
        repaint();
    }

   

}
