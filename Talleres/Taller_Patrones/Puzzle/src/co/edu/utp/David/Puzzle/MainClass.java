/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.David.Puzzle;

import co.edu.utp.David.Puzzle.Logica.Juego;
import co.edu.utp.David.Puzzle.Logica.Presentacion.FPrincipal;
import co.edu.utp.David.Puzzle.Modelo_Vista_Controlador.*;

/**
 *
 * @author david_perez
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vista vista = new FPrincipal();
        Juego modelo = new Juego(4,4);
        Controlador controlador = new Controlador(vista,modelo);
        vista.setControlador(controlador);
        vista.arranca();
        
    }
    
}
