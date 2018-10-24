/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanwithobserver.Presentacion;

/**
 *
 * @author david_perez
 */
import pacmanwithobserver.Logica.*;
import javax.swing.*;
import java.awt.*;
import pacmanwithobserver.Modelo_Vista_Controlador.Controlador;
import pacmanwithobserver.Modelo_Vista_Controlador.Vista;


public class FPrincipal extends JFrame implements Vista{
    private Juego juegoPacman;
    private PDibujo panelDibujo;
    private PControles panelControles;
    private PInformacion panelInformacion;
    
    public FPrincipal(){
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setSize(205,300);
        this.setTitle("Pacman");
        this.setLayout(new BorderLayout());
        this.panelDibujo = new PDibujo();
        this.add(panelDibujo,BorderLayout.CENTER);
        this.panelControles = new PControles();
        this.add(panelControles,BorderLayout.SOUTH);
        this.panelInformacion = new PInformacion();
        this.add(panelInformacion , BorderLayout.NORTH);

    }

    public Juego getJuego() {
        return juegoPacman;
    }

    @Override
    public void setControlador(Controlador c) {
        this.panelControles.getAbajo().addActionListener(c);
        this.panelControles.getArriba().addActionListener(c);
        this.panelControles.getDerecha().addActionListener(c);
        this.panelControles.getIzquierda().addActionListener(c);
        this.juegoPacman = c.getModelo();
        this.juegoPacman.addObserver(this.panelDibujo);
        this.juegoPacman.addObserver(this.panelInformacion);
        this.juegoPacman.notificar();
    }

    @Override
    public void arranca() {
        this.setVisible(true);
    }

   
    
}
