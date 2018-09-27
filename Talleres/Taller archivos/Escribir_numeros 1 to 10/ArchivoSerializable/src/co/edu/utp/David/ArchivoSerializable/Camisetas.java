/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.David.ArchivoSerializable;

import java.io.Serializable;

/**
 *
 * @author utp
 */
public class Camisetas implements Serializable {
    private final String color;
    private final String talla;
    private final String marca;
    
    Camisetas(String color, String talla , String marca)
    {
        this.color = color;
        this.marca = marca;
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public String getTalla() {
        return talla;
    }

    public String getMarca() {
        return marca;
    }

    @Override
    public String toString() {
        return "Camisetas{" + "color=" + color + ", talla=" + talla + ", marca=" + marca + '}';
    }
    
    
    
}
