/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.David.Puzzle.Logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;


/**
 *
 * @author david_perez
 */
public class Juego extends Observable {
     public final static int DETENIDO = -1,
    DERECHA = 0,
    ARRIBA = 1,
    IZQUIERDA = 2,
    ABAJO = 3;
    private ArrayList<Ficha> fichas;
    private Ficha vacio;
    private int m,
        n;
    private int movimientos;
    
    public void reiniciarMovimientos(){
        movimientos = 0;
    }
    public Juego(int m , int n){
        this.m = m; 
        this.n = n;
        fichas = new ArrayList<Ficha>();
        cargarFichas();
        this.movimientos = 0;
    }
    
    public int getMovimientos(){
        return movimientos;
    }
    
    public ArrayList<Ficha> getFichas() {
        return fichas;
    }

    public Ficha getVacio() {
        return vacio;
    }
    
    

    private void cargarFichas() {
        File archivo = new File("sr/fichas.txt");
        try{
            FileReader fr = new FileReader(archivo);
            Scanner read = new Scanner(fr); 
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int x = read.nextInt();
                    if(x == 0)
                        vacio = new Ficha(j,i,x);
                    else
                        fichas.add(new Ficha(j,i,x));
                }
            }
        }catch(IOException e){}
    }
    
    public boolean derecha(){
        if(!this.colisionBorde(Juego.DERECHA))
        {
            for(Ficha ficha:fichas){
               if(ficha.getY() == vacio.getY() &&
                  ficha.getX() == vacio.getX() - 1){
                   vacio.cambiarPosicion(ficha);
                   movimientos++;
                   break;
               }
            }
            this.notificar();
            return true;
        }
        return false;
    }
    
    
    public boolean izquierda(){
        if(!this.colisionBorde(Juego.IZQUIERDA))
        {
            for(Ficha ficha:fichas){
               if(ficha.getY() == vacio.getY() &&
                  ficha.getX() == vacio.getX() + 1){
                   vacio.cambiarPosicion(ficha);
                   movimientos++;
                   break;
               }
            }
            this.notificar();
            return true;
        }
        return false;
    }
    
    
    public boolean arriba(){
        if(!this.colisionBorde(Juego.ARRIBA))
        {
            for(Ficha ficha:fichas){
               if(ficha.getY() == vacio.getY() + 1 &&
                  ficha.getX() == vacio.getX()){
                   vacio.cambiarPosicion(ficha);
                   movimientos++;
                   break;
               }
            }
            this.notificar();
            return true;
        }
        return false;
    }
    
    public boolean abajo(){
        if(!this.colisionBorde(Juego.ABAJO))
        {
            for(Ficha ficha:fichas){
               if(ficha.getY() == vacio.getY() -1 &&
                  ficha.getX() == vacio.getX()){
                   vacio.cambiarPosicion(ficha);
                   movimientos++;
                   break;
               }
            }
            this.notificar();
            return true;
        }
        return false;
    }
    
    private boolean colisionBorde(int direccion){
        if((direccion == Juego.DERECHA && vacio.getX() == 0) ||
          (direccion == Juego.IZQUIERDA && vacio.getX() == n - 1)||
          (direccion == Juego.ABAJO && vacio.getY() == 0)||
          (direccion == Juego.ARRIBA && vacio.getY() == m - 1))
                return true;
        return false;
    }
    
    public void notificar(){
        setChanged();
        notifyObservers(this);
    }
    
}
