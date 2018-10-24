/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanwithobserver.Logica;

/**
 *
 * @author david_perez
 */
public class Jugador extends Elemento {
    
    public Jugador(int x, int y) {
        super(x, y, "img/pacman.gif");
    }
    
    public void arriba(){
        this.y-=1;
    }
    public void abajo(){
        this.y+=1;
    }
    public void derecha(){
        this.x+=1;
    }
    public void izquierda(){
        this.x-=1;
    }
}
