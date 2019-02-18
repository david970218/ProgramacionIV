/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.david.batallanaval.presentacion;

import co.edu.utp.isc.david.batallanaval.presentacion.Persistencia1.ControladorMenu;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import co.edu.utp.isc.david.batallanaval.presentacion.Persistencia1.Vista;
import javax.swing.WindowConstants;

public class MiFrame extends JFrame  implements Observer , Vista{
    PJuego pJuego;
    SolCOM solucion;
    MenuBar menu;
    public MiFrame(){
        pJuego = new PJuego();
        solucion = new SolCOM();
        initGUI();
        pJuego.getJuego().addObserver(this);
        pJuego.getJuego().addObserver(solucion);
        pJuego.getJuego().notificar();
        
    }

    private void initGUI() {
        add(pJuego);
        menu = new MenuBar();
        setJMenuBar(menu);
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.setSize(927, 575);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    
    
    public void actualizarPantalla(){ 
        
SwingUtilities.updateComponentTreeUI(this);


} 

    @Override
    public void update(Observable o, Object o1) {
        actualizarPantalla();
        
    }

    @Override
    public PJuego getPJuego() {
        return pJuego;
    }

    @Override
    public void setControlador(ControladorMenu c) {
        menu.getReinicio().addActionListener(c);
        menu.getSolucion().addActionListener(c);
        menu.getInfo().addActionListener(c);
        menu.getAyuda().addActionListener(c);
        menu.getSalir().addActionListener(c);
    }
    
    @Override
    public SolCOM getSolCom(){
        return solucion;
        
    }
 

  
    
   
}
