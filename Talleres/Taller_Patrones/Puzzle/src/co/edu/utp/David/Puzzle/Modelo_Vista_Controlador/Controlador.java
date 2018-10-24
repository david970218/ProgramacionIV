/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.David.Puzzle.Modelo_Vista_Controlador;

import co.edu.utp.David.Puzzle.Logica.Juego;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 *
 * @author david_perez
 */
public class Controlador implements ActionListener,KeyListener{
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
            case Vista.DESORDENAR:
               desordenar();
                break;
        
        }
    }

    private void desordenar(){
        for (int i = 0; i < 1000; i++) {
            int numero = (int) (Math.random() * 3);
            switch(numero){
                case 0:
                    modelo.derecha();
                    break;
                case 1:
                    modelo.arriba();
                    break;
                case 2:
                    modelo.izquierda();
                case 3:
                    modelo.abajo();
                    break;
                    
            }
        }
        modelo.reiniciarMovimientos();
        modelo.notificar();
 
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode() - 37){
            case 0:
              modelo.izquierda();
              break;
            case 1:
               modelo.arriba();
               break;
            case 2:
                modelo.derecha();
                break;
            case 3:
                modelo.abajo();
                break;
            case -29:
                this.desordenar();
                break;
             
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
