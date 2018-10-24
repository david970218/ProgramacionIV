/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.David.Puzzle.Logica;

/**
 *
 * @author david_perez
 */
public class Ficha extends Elemento {
    private final int numero;

    public Ficha(int x, int y , int numero) {
        super(x,y,"img/"+numero+".jpg");
        this.numero = numero;
    }

    public int getNumero() {
       return numero; 
    }
    public void cambiarPosicion(Ficha f){
        int xaux = f.getX(),
            yaux = f.getY();
        f.setX(this.x);
        f.setY(this.y);
        this.setX(xaux);
        this.setY(yaux);
    }
    
}
