/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.david.prestamos.persistencia2;

import co.edu.utp.isc.david.prestamos.persistencia1.Cooperativa;
import co.edu.utp.isc.david.prestamos.persistencia1.Persona;
import co.edu.utp.isc.david.prestamos.persistencia1.Prestamo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;

/**
 *
 * @author david
 */
public class PagosYSolicitudes implements Serializable{
    private Cooperativa coop;
    private final int APROBADO = 1, 
                      ESTUDIO = 0,
                      RECHAZADO = -1, 
                      PAGADO = 2;
    
    
    
    
    public void update(Cooperativa o) {
        coop = (Cooperativa) o;
        revisarTodoslosCreditos();
    }

    private void revisarTodoslosCreditos() {
        ArrayList<Prestamo> prs;
        
        prs = (ArrayList<Prestamo> ) Operaciones.getInstance().multipleResult("FROM Prestamo");
      
        Iterator i = prs.iterator();
        while(i.hasNext()){
            Prestamo p = (Prestamo) i.next();
            switch(p.getEstadoDeAprobacion()){
                case ESTUDIO:
                    hacerEstudio(p);
                    break;
                case APROBADO:
                    comprobarPago(p);
                    break;
                case RECHAZADO:
                    break;
                case PAGADO:
                    break;
            }
        }
        
    }

    private void hacerEstudio(Prestamo p) {
      if(esFecha(p.getFechaDeSolicitud())){
        if(coop.getDineroParaPrestar() - p.getCantidad() >= 0){
          int saldoPendiente = 0;
          ArrayList prs =(ArrayList<Prestamo> ) Operaciones.getInstance().multipleResult
                          ("FROM Prestamo WHERE CC_Solicitante = " +
                          p.getPersona().getCedula());
          Iterator i = prs.iterator();
          while(i.hasNext()){
              Prestamo x = (Prestamo) i.next();
              if(x.getEstadoDeAprobacion() == APROBADO)
                    saldoPendiente += calularSaldoPendiente(x);
          }
          if(saldoPendiente < 15_000_000 && saldoPendiente + p.getCantidad() < 15_000_000){
              p.setEstadoDeAprobacion(APROBADO);
              Date newdate = new Date();
              newdate.setYear(coop.getFecha().getYear());
              newdate.setMonth(coop.getFecha().getMonth());
              if(p.getCantidad() > 1_000_000)
                    newdate.setDate(coop.getFecha().getDate() + 10);
              else
                  newdate.setDate(coop.getFecha().getDate() + 7);
  
              p.setFechaEntrega(newdate);
              Date newdate2 = new Date();
              newdate2.setYear(coop.getFecha().getYear());
              newdate2.setMonth(coop.getFecha().getMonth());
              newdate2.setDate(coop.getFecha().getDate() + newdate.getDate() + (30 * p.getCantidadCuotas()));
              Date newdate3 = new Date();
              newdate3.setYear(coop.getFecha().getYear());
              newdate3.setMonth(coop.getFecha().getMonth());
              newdate3.setDate(newdate.getDay() + 30);
              p.setProximaCuota(newdate3);
              p.setFechaDeDevolucion(newdate2);
              p.setSaldoPendiente(p.getCantidad() + (p.getCantidad() * 0.2));
              Operaciones.getInstance().save(p);
              JOptionPane.showMessageDialog(null, "La solicitud con nr  " + p.getNumPrestamo() + 
                      "\nCon numero de cc: " + p.getPersona().getCedula() +"\nha sido aprobada\n"
                              + "Y sera entregada el " + p.getFechaEntrega(), "Informacion"
                      , JOptionPane.INFORMATION_MESSAGE);
          }
          else{
            p.setEstadoDeAprobacion(-1);
              JOptionPane.showMessageDialog(null, "La solicitud con nr  " + p.getNumPrestamo() + 
                      "\n ha sido rechazada porque ya excedio el saldo maximo que una persona puede deber", "Informacion"
                      ,JOptionPane.ERROR_MESSAGE);
          }
      }else{
            p.setEstadoDeAprobacion(-1);
              JOptionPane.showMessageDialog(null, "La solicitud con nr  " + p.getNumPrestamo() + 
                      "\n ha sido rechazada por falta de fondos", "Informacion"
                      ,JOptionPane.ERROR_MESSAGE);
          }
    }
    
    }
    
    private boolean esFecha(Date fecha ){
        Date fechacoop = coop.getFecha();
        if(fechacoop.getYear() == fecha.getYear() && 
           fecha.getMonth() == fechacoop.getMonth() && 
            fecha.getDate() == fechacoop.getDate())
             return true;
        return false;
    }
    
    private double calularSaldoPendiente(Prestamo p){
        double cantidad = p.getSaldoPendiente();
        return cantidad;
    }

    private void comprobarPago(Prestamo p) {
        if(esFecha(p.getProximaCuota())){
            p.setCuotasPagadas(p.getCuotasPagadas() + 1);
            coop.setDineroParaPrestar(p.getValorCuota() + coop.getDineroParaPrestar());
            
            coop.setDineroPrestado(coop.getDineroPrestado() - (p.getCantidad()/p.getCantidadCuotas())
            );
            
            if(p.getCuotasPagadas() != p.getCantidadCuotas()){
                p.getProximaCuota().setDate(p.getProximaCuota().getDate() + 30 );
                JOptionPane.showMessageDialog(null,
                        p.getPersona().getCedula() + " Identificado con cedula: " + 
                        p.getPersona().getCedula() + "\nha pagado su cuota\n"
                        + "proxima cuota: " + p.getProximaCuota());
                        p.setSaldoPendiente(p.getSaldoPendiente() - p.getValorCuota());
            }else{
                p.setEstadoDeAprobacion(PAGADO);
                 JOptionPane.showMessageDialog(null,
                        p.getPersona().getCedula() + " Identificado con cedula: " + 
                        p.getPersona().getCedula() + "\nha pagado su credito Completamente");
                        p.setSaldoPendiente(0);
                        
            }
            
            
        }else if(esFecha(p.getFechaEntrega())){
           
            Persona x = p.getPersona();
            JOptionPane.showMessageDialog(null, "Se le entrega el monto de : " + p.getCantidad() + 
                      "\nPor concepto de prestamos bajo el numero de identificaion  de prestamo " + p.getNumPrestamo() +
                      "\na :" + x.getCedula(), 
                      "Informacion" , JOptionPane.INFORMATION_MESSAGE );
             
              coop.setDineroParaPrestar(coop.getDineroParaPrestar() - p.getCantidad());
              coop.setDineroPrestado(coop.getDineroPrestado() + p.getCantidad());
              
              
        }
        Operaciones.getInstance().save(p);    
        coop.notificar();
         
    }
    
}
