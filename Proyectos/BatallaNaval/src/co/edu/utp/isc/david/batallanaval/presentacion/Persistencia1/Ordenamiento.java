/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.david.batallanaval.presentacion.Persistencia1;

/**
 *
 * @author david_perez
 */

public abstract class Ordenamiento {
    public static void burbuja(Puntaje[] puntajes){
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 10 - i; j++) {
                if(puntajes[j].getPuntaje() < puntajes[j+ 1 ].getPuntaje()){
                    Puntaje aux = puntajes[j];
                    puntajes[j] = puntajes[j + 1];
                    puntajes[j+1] = aux;
                }
            }
        }
    }
}
