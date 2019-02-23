/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.david.prestamos.persistencia2;

import co.edu.utp.isc.david.prestamos.persistencia1.Cooperativa;
import co.edu.utp.isc.david.prestamos.persistencia1.Persona;
import co.edu.utp.isc.david.prestamos.persistencia1.Prestamo;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author david
 */
public class Controlador{
    private static Controlador instance;
    
    public static Controlador getInstance(){
        if(instance == null)
            instance = new Controlador();
        return instance;
    }
    
    
    private Controlador(){};
    
    public void guardarPersona(int CC , String name , String flast, 
                          String slast , String movil , String house){
        Persona p; 
        if(house.equals("")){
              p = new Persona(CC,name, flast , slast, movil);
              System.out.println("hola");
         }else
              p = new Persona(CC,name, flast , slast, movil,house);
        
        if(!Operaciones.getInstance().save(p)){
            JOptionPane.showMessageDialog(null, "Parece que algo salio mal revisa tus campos\n"
                    + "Puede ser que la cedula ya este reguistrada",
                    "Error Desconocido", JOptionPane.ERROR_MESSAGE);
        }
        
        
      
        
    }
  
    public Persona consultaPorCC(int CC){
          Persona p = (Persona) 
          Operaciones.getInstance().uniqueResult("FROM Persona WHERE cedula = " + CC);
          return p;
     }
      
    public void Solicitud(Persona p, double monto , int cuotas){
        Cooperativa coop = Cooperativa.getInstance();
        Date fechaSolicitud = new Date();
        fechaSolicitud.setYear(coop.getFecha().getYear());
        fechaSolicitud.setMonth(coop.getFecha().getMonth());
        fechaSolicitud.setDate(coop.getFecha().getDate());
        double interes = 0.2;
        double valorCuota = ((monto * interes) + monto)/ cuotas;
        
        if(fechaSolicitud.getDate() >= 20){
            fechaSolicitud.setMonth(fechaSolicitud.getMonth() + 1);
            fechaSolicitud.setDate(1);
        }else{
            fechaSolicitud.setDate(fechaSolicitud.getDate() + 1);
        }
        Prestamo prs = new Prestamo(coop.getCantidadPrestamos() + 1 ,
            p,
            monto,
            fechaSolicitud,
            0,
            new Date(0,0,0),
            valorCuota,
            cuotas,
            0,
            new Date(0,0,0),
            new Date(0,0,0),
            0
            );
        
        
        if(Operaciones.getInstance().save(prs)){
           coop.setCantidadPrestamos(coop.getCantidadPrestamos() + 1);
            System.out.println(coop.getCantidadPrestamos());
           JOptionPane.showMessageDialog    
           (null,"Su Solicitud ha sido creada Y sera revisada el \n" + fechaSolicitud, "Confirmar",
           JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

    