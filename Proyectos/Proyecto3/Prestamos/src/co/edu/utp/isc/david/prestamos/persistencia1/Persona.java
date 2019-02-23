package co.edu.utp.isc.david.prestamos.persistencia1;
// Generated 22/02/2019 01:21:48 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Persona generated by hbm2java
 */
public class Persona  implements java.io.Serializable {


     private int cedula;
     private String nombre;
     private String primerapellido;
     private String segundoapellido;
     private String telefonoCasa;
     private String telefonoMovil;
     private Set prestamos = new HashSet(0);

    public Persona() {
    }

	
    public Persona(int cedula, String nombre, String primerapellido, String segundoapellido, String telefonoMovil) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.primerapellido = primerapellido;
        this.segundoapellido = segundoapellido;
        this.telefonoMovil = telefonoMovil;
    }
    public Persona(int cedula, String nombre, String primerapellido, String segundoapellido, String telefonoCasa, String telefonoMovil) {
       this.cedula = cedula;
       this.nombre = nombre;
       this.primerapellido = primerapellido;
       this.segundoapellido = segundoapellido;
       this.telefonoCasa = telefonoCasa;
       this.telefonoMovil = telefonoMovil;
       
    }
    
     public Persona(int cedula, String nombre, String primerapellido, String segundoapellido, String telefonoCasa, String telefonoMovil, Set prestamos) {
       this.cedula = cedula;
       this.nombre = nombre;
       this.primerapellido = primerapellido;
       this.segundoapellido = segundoapellido;
       this.telefonoCasa = telefonoCasa;
       this.telefonoMovil = telefonoMovil;
       this.prestamos = prestamos;
    }
   
    public int getCedula() {
        return this.cedula;
    }
    
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPrimerapellido() {
        return this.primerapellido;
    }
    
    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }
    public String getSegundoapellido() {
        return this.segundoapellido;
    }
    
    public void setSegundoapellido(String segundoapellido) {
        this.segundoapellido = segundoapellido;
    }
    public String getTelefonoCasa() {
        return this.telefonoCasa;
    }
    
    public void setTelefonoCasa(String telefonoCasa) {
        this.telefonoCasa = telefonoCasa;
    }
    public String getTelefonoMovil() {
        return this.telefonoMovil;
    }
    
    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }
    public Set getPrestamos() {
        return this.prestamos;
    }
    
    public void setPrestamos(Set prestamos) {
        this.prestamos = prestamos;
    }




}

