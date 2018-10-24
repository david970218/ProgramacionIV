/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanwithobserver;

import pacmanwithobserver.Logica.Juego;
import pacmanwithobserver.Modelo_Vista_Controlador.Controlador;
import pacmanwithobserver.Modelo_Vista_Controlador.Vista;
import pacmanwithobserver.Presentacion.FPrincipal;

/**
 *
 * @author david_perez
 */
public class PacmanWithObserver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vista vistaGame;
        Juego modelo = new Juego();
        vistaGame = new FPrincipal();
        Controlador controlador;
        controlador = new Controlador(vistaGame,modelo);
        vistaGame.setControlador(controlador);
        vistaGame.arranca();
    }
    
}
