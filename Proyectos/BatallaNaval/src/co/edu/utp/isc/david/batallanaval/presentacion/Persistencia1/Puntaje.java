/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.david.batallanaval.presentacion.Persistencia1;

import co.edu.utp.isc.david.batallanaval.presentacion.Persistencia2.Jugador;

/**
 *
 * @author david_perez
 */
public class Puntaje {
    private final Jugador player1;
    private final Jugador COM;
    private final int puntaje;
    
    public Puntaje(Jugador player1, Jugador COM){
        this.player1 = player1;
        this.COM = COM;
        puntaje = player1.getShoots() - COM.getShoots();
    }
    
    
    
    public int getPuntaje() {
        return puntaje;
    }
    
}
