/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanwithobserver.Modelo_Vista_Controlador;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pacmanwithobserver.Logica.Juego;

/** 
 *
 * @author david_perez
 */
public class Controlador implements ActionListener{
    private Vista vista;
    private Juego modelo;
    public Controlador(Vista vista, Juego modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
    }

    public Juego getModelo() {
        return modelo;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case Vista.ARRIBA:
                modelo.arriba();
                break;
            case Vista.ABAJO:
                modelo.abajo();
                break;
            case Vista.DERECHA:
                modelo.derecha();
                break;
            case Vista.iZQUIERDA:
                modelo.izquierda();
                break;
        }
    }
    
}
