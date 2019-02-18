/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.david.batallanaval.presentacion;

import co.edu.utp.isc.david.batallanaval.presentacion.Persistencia2.Juego;
import co.edu.utp.isc.david.batallanaval.presentacion.Persistencia2.Jugador;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

/**
 *
 * @author Usuario UTP
 */
public class PInformacion extends JPanel implements Observer{
    Jugador jugador , com;
    Juego juego;
    
    public PInformacion(){
        this.setSize(15*30 * 2 + 15 , 60);
    }
    @Override
    public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0, 0, 15*30 * 2 + 15,60);
        g.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        g.setColor(Color.black);
        g.drawString(jugador.getName(), 0,15);
        g.drawString("Movimientos" + ": " + jugador.getMoves() , 0,30);
        g.drawString("Aciertos" + ": " + jugador.getShoots() , 0,45);
        g.drawString(com.getName(), 15*30  + 15,15);
        g.drawString("Movimientos" + ": " + com.getMoves() , 15*30 + 15,30);
        g.drawString("Aciertos" + ": " + com.getShoots() , 15*30 + 15,45);
    }

    @Override
    public void update(Observable o, Object o1) {
        juego = (Juego) o;
        jugador = juego.getPlayer1();
        com = juego.getCOM();
        repaint();
    }
}
