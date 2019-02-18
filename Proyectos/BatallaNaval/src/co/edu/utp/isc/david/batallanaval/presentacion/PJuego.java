/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.david.batallanaval.presentacion;

import co.edu.utp.isc.david.batallanaval.presentacion.Persistencia1.Controlador;
import co.edu.utp.isc.david.batallanaval.presentacion.Persistencia2.Juego;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author david
 */
public class PJuego extends JPanel {
    private PDibujoCOM pDCom;
    private PDibujoP1 pDP1;
    private Controlador controlador;
    private Juego juego;
    private PInformacion panelInfo;

    public PJuego(){
        pDP1 = new PDibujoP1();
        pDCom = new PDibujoCOM();
        controlador = new Controlador(pDCom);
        panelInfo = new PInformacion();
        pDCom.setControlador(controlador);
        initGUI();
        juego =  new Juego(JOptionPane.showInputDialog("Ingresa tu Nombre: "));
        juego.addObserver(pDCom);
        juego.addObserver(pDP1);
        juego.addObserver(panelInfo);
        juego.notificar();
        
    }
    
    private void initGUI(){
        this.setLayout(null);
        this.add(panelInfo);
        this.add(pDCom);
        pDCom.setLocation(0,61);
        this.add(pDP1);
        pDP1.setLocation(15*30 + 15, 61);
    }
    
    
    
    public PDibujoCOM getpDCom() {
        return pDCom;
    }
    
    public PDibujoP1 getpDP1() {
        return pDP1;
    }

    public Controlador getControlador() {
        return controlador;
    }

    public Juego getJuego() {
        return juego;
    }

    public PInformacion getPanelInfo() {
        return panelInfo;
    }

    public void setpDCom(PDibujoCOM pDCom) {
        this.pDCom = pDCom;
    }

    public void setpDP1(PDibujoP1 pDP1) {
        this.pDP1 = pDP1;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public void setPanelInfo(PInformacion panelInfo) {
        this.panelInfo = panelInfo;
    }
    
    
    
}
