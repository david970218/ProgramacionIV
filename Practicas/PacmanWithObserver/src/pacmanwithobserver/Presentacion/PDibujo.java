/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanwithobserver.Presentacion;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import pacmanwithobserver.Logica.Bloque;
import pacmanwithobserver.Logica.Galleta;
import pacmanwithobserver.Logica.Juego;

/**
 *
 * @author david_perez
 */
public class PDibujo extends JPanel implements Observer{
    private Object objObservable;
    
    @Override
    public void paint(Graphics g){
        Juego juego = (Juego)this.objObservable;
        g.setColor(new Color(20,20,20));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        System.out.println(this.getWidth() + " " + this.getHeight());
        for(Bloque bloque: juego.getBloques()){
            g.drawImage(bloque.getImage(),bloque.getX() * 20,
                        bloque.getY()*20,20,20, this);
        }
        for (Galleta galleta:juego.getGalletas()) {
            g.drawImage(galleta.getImage(),galleta.getX() * 20,
                        galleta.getY()*20,20,20, this);
        }
        g.drawImage(juego.getComegalletas().getImage(),
                    juego.getComegalletas().getX() * 20,
                    juego.getComegalletas().getY()*20,20,20, this);
    }

    @Override
    public void update(Observable o, Object arg) {
        this.objObservable = arg;
        this.repaint();
    }


}
