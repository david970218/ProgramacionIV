/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.david.prestamos.persistencia1;

import co.edu.utp.isc.david.prestamos.persistencia2.Memento;
import co.edu.utp.isc.david.prestamos.persistencia2.PagosYSolicitudes;
import java.io.Serializable;
import java.util.Date;
import java.util.Observable;

/**
 *
 * @author david
 */
public class Cooperativa extends Observable implements Serializable{
   private double dineroParaPrestar;
   private double dineroPrestado;
   private Date fecha;
   private static Memento memento = Memento.getInstance();
   private int cantidadPrestamos ;
   private PagosYSolicitudes controlador;
   
   
   private static Cooperativa cooperativa;
   private Cooperativa(){
       dineroParaPrestar = 6000000;
       dineroPrestado = 0;
       cantidadPrestamos = 0;
       fecha = new Date();
       memento.setState(this);
       
   }

    public void setControlador(PagosYSolicitudes controlador) {
        this.controlador = controlador;
    }

    public PagosYSolicitudes getControlador() {
        return controlador;
    }
    
    
   

    public void setCantidadPrestamos(int cantidadPrestamos) {
        this.cantidadPrestamos = cantidadPrestamos;
        notificar();
    }
   
   
   
    public double getDineroParaPrestar() {
        return dineroParaPrestar;
    }

    public double getDineroPrestado() {
        return dineroPrestado;
    }
    

    public Date getFecha() {
        return fecha;
    }

    public int getCantidadPrestamos() {
        return cantidadPrestamos;
    }
    
    

    public void setDineroParaPrestar(double dineroParaPrestar) {
        this.dineroParaPrestar = dineroParaPrestar;
        
    }

    public void setDineroPrestado(double dineroPrestado) {
        this.dineroPrestado = dineroPrestado;
    }

    public static Cooperativa getInstance(){
        
        if(cooperativa == null){
            cooperativa = memento.getState();
            if(cooperativa == null)
                cooperativa = new Cooperativa();
        }
        return cooperativa;
    }
    
    
   
    public void notificar(){
        memento.setState(this);
        this.setChanged();
        this.notifyObservers();
        
    }
    
    public void avanzarUnDia(){
        fecha.setDate(fecha.getDate() + 1);
        notificar();
        controlador.update(this);
        
    }
}
