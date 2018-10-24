/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.David.Puzzle.Logica;

import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author david_perez
 */
public class Elemento {
    protected int x,y;
    protected final Image imagen;

    public Elemento(int x, int y, String imagen) {
        this.x = x;
        this.y = y;
        this.imagen = Toolkit.getDefaultToolkit().getImage(imagen);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
