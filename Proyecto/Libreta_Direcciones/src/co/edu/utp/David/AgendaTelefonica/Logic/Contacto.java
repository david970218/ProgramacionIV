/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.David.AgendaTelefonica.Logic;
import co.edu.utp.David.AgendaTelefonica.Archivos.AdministradorArchivos;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author David
 */
public class Contacto implements Serializable {
    private String nombre,direccion,primera,segundoa,alias,email;
    private boolean toDelete;
    private String[] tiposnumero,numeroT;
    private static  File archivo = new File("Contactos.txt");
    public Contacto(String[] args , String[] tiposnumero, String[] numeroT) {
        this.nombre = args[1];
        this.primera = args[2];
        this.segundoa = args[3];
        this.alias = args[4];
        this.direccion = args[5];
        this.email = args[6];
        this.tiposnumero = tiposnumero;
        this.numeroT = numeroT;
        this.toDelete = false;
    }

    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setPrimera(String primera) {this.primera = primera;}
    public void setSegundoa(String segundoa) {this.segundoa = segundoa;}
    public void setAlias(String alias) {this.alias = alias;}
    public void setEmail(String email) {this.email = email;}
    public void setDireccion(String direccion) {this.direccion = direccion;}
    public void setTiposnumero(String[] tiposnumero) {this.tiposnumero = tiposnumero;}
    public void setNumeroT(String[] numeroT) {this.numeroT = numeroT;}
    public void setToDelete(boolean toDelete) {this.toDelete = toDelete;}
    public String getNombre() {return nombre;}
    public String getPrimera() {return primera;}
    public String getSegundoa() {return segundoa;}
    public String getAlias() {return alias;}
    public String getEmail() {return email;}
    public String[] getTiposnumero() {return tiposnumero;}
    public String[] getNumeroT() {return numeroT;}
    public static File getArchivo() {return archivo;}
    public String getDireccion() {return direccion;}
    public boolean isToDelete() {return toDelete;}

    @Override
    public String toString() {
        String aux = "";
        aux += nombre + ';'
                + primera + ";"
                + segundoa + ";"
                + alias + ";"
                + direccion+";"
                + email + ";";
        int a = 1;
       while(a < 6){
            aux += tiposnumero[a] + ":" + numeroT[a] + ";";
            a++;
           }
        return aux;
    }
    
    public boolean equalst(Contacto cmp){
        int a = 1;
        String[] aux = cmp.getNumeroT();
        while(!numeroT[a].equals("")){
            for(int i = 1; i<6 ; i++){
                if(aux[i].equals(""))
                    break;
                if(numeroT[a].equals(aux[i]))
                    return true;
            }
            a++;
        }
        return false;
    }
    
    public boolean isGuardable(){
        Contacto[] lista;
        if(archivo.exists()){
            lista = (Contacto[]) AdministradorArchivos.leerArchivoSerializable(archivo);
        for(int i = 1; i< 10000;i++){
            if(lista[i] == null)
                break;
            if(this.equalst(lista[i]))
                return false;
        }
        }
        return true;
    }
    
    public boolean guardarContacto(){
        
        try {
            if(this.isGuardable())
            {
                AdministradorArchivos.llenarArchivoSerializable(archivo, this);
                return true;
            }
        } catch (FileNotFoundException ex){}
        return false;
    }
    
    private static int contarObjc(Object[] count){
        int a =1;
        int contador = 0;
        while(count[a] != null){
            a++;
            contador++;
        }
        return contador;
    }

    public static boolean guardarListaContacto(Contacto[] contactos){
        int a = 1;
        Contacto[] existencias;
        if(contactos[1] != null){
            existencias = AdministradorArchivos.leerArchivoSerializable(archivo);
        int contador = contarObjc(existencias);
        contador +=1;
        while(contactos[a] != null){
            int b = 1;
            boolean noesta = true;
               if(existencias[1] != null){
                while(existencias[b] != null){
                    if(contactos[a].equalst(existencias[b])){    
                        noesta = false;
                        break;
                    }
                    b++;
                }
                if(noesta){
                    existencias[contador] = contactos[a];
                    contador++;
                }
                
            }
            else{
                   existencias[1] = contactos[1];
                   contador++;
               }
               a++;
        }
        guardarEnArchivo(existencias);
        return true;
        }
        return false;
    }
    
    private static void guardarEnArchivo(Contacto[] contactos){
        int a = 1;
        try {
            AdministradorArchivos.LimpiarArchivo(archivo);
        } catch (IOException ex) {}
        while(contactos[a] != null){
            if(!contactos[a].isToDelete()){
                try {
                    AdministradorArchivos.llenarArchivoSerializable(archivo,contactos[a]);
                    
                } catch (FileNotFoundException ex){}
                
            }
            a++;
        }
    }
    
    
    
    
}
