/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanwithobserver.Modelo_Vista_Controlador;

import pacmanwithobserver.Logica.Juego;





/**
 *
 * @author david_perez
 */
public interface Vista{
    void setControlador(Controlador c);
    void arranca();
    Juego getJuego();
    public static final String ARRIBA = "^",
            ABAJO = "v",
            DERECHA = ">",
            iZQUIERDA = "<";
    
}
