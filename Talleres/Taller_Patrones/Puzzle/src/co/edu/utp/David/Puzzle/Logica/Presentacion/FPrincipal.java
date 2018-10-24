/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.David.Puzzle.Logica.Presentacion;

import co.edu.utp.David.Puzzle.Logica.Juego;
import co.edu.utp.David.Puzzle.Modelo_Vista_Controlador.Controlador;
import co.edu.utp.David.Puzzle.Modelo_Vista_Controlador.Vista;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author david_perez
 */
public class FPrincipal extends JFrame implements Vista{
    private Juego juego;
    private PDibujo panelDibujo;
    private PInformacion panelInformacion;
    private PControles panelControles;
    
    public FPrincipal(){
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(360,510);
        this.setResizable(false);
        this.setTitle("Puzzle");
        this.setLayout(new BorderLayout());
        
        panelInformacion = new PInformacion();
        panelDibujo = new PDibujo();
        panelControles = new PControles();
        this.add(panelInformacion , BorderLayout.NORTH);
        this.add(panelDibujo,BorderLayout.CENTER);
        this.add(panelControles,"South");
    }
    
    public Juego getJuego(){
        return juego;
    }

    @Override
    public void setControlador(Controlador c) {
        this.panelControles.getAbajo().addActionListener(c);
        this.panelControles.getArriba().addActionListener(c);
        this.panelControles.getDerecha().addActionListener(c);
        this.panelControles.getIzquierda().addActionListener(c);
        this.panelControles.getDesordenar().addActionListener(c);
        this.setFocusable(true);
        this.addKeyListener(c);
        
        juego = c.getModelo();
        juego.addObserver(panelDibujo);
        juego.addObserver(panelInformacion);
        juego.notificar();
    }

    @Override
    public void arranca() {
        this.setVisible(true);
    }
}
