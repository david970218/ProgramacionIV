/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.david.batallanaval.presentacion.Persistencia2;

import java.util.Observable;
import javax.swing.JOptionPane;


/**
 *
 * @author utp
 */
public class Juego extends Observable {

      Jugador player1;
      Jugador COM;
   
private final  int COMTURN = 0, PLAYERTURN = 1;
    private boolean desactivarMouse;
    int turn = 1;
    
   
    public Juego(String namePlayer1){
        player1 = new Jugador(namePlayer1);
        COM = new Jugador("COM");
        
    }
       
     public void notificar(){
        this.setChanged();
        this.notifyObservers(null);
    }    

    public Jugador getPlayer1() {
        return player1;
    }

    public Jugador getCOM() {
        return COM;
    }
    
    public void reiniciarJuego(String name){
        player1 = new Jugador(name);
        COM = new Jugador("COM");
        this.notificar();
    
    };
    
    public void shotPlayer1(int x , int y){
        int[][] maze = COM.getMaze();
        if(maze[x][y] != -1 && maze[x][y] != 5 && maze[x][y] != 6 && maze[x][y] != 7 && maze[x][y] != 8){
        if(COM.shot(x, y)){
            
             turn = PLAYERTURN;
             player1.setMoves(player1.getMoves() + 1);
             player1.setShoots(player1.getShoots() + 1);
             ganador();
        }else{
            turn = COMTURN;
            player1.setMoves(player1.getMoves() + 1);
            actualizarTurno();
            ganador();
        }
        notificar();
        }
    }
    
    public void shotCOM(int x , int y){
        if(player1.shot(x, y)){
             turn = COMTURN;
             ganador();
        }else
            turn = PLAYERTURN;
            ganador();
        notificar();
    }



    public void actualizarTurno() {
        if(turn == COMTURN){
            desactivarMouse = true;
            notificar();
            while(turn == COMTURN){
                int x = (int) ( Math.random() *15);
                int y = (int) ( Math.random() *15);
                int [][] mazep = player1.getMaze();
                System.out.println(x + "*" + y);
                if(mazep[x][y] !=  -1 && mazep[x][y] != 3){
                   if(player1.shot(x, y)){
                        COM.setMoves(COM.getMoves() + 1);
                        COM.setShoots(COM.getShoots()+1);
                        turn = COMTURN;
                        ganador();
                        
                     }else{
                        turn = PLAYERTURN;
                        COM.setMoves(COM.getMoves() + 1);
                        desactivarMouse = false;
                        ganador();
                        break;
                   }
                        
                }
                
            }
            notificar();
        }
        else
            desactivarMouse = false;
    }

    public boolean isDesactivarMouse() {
        return desactivarMouse;
        
    }
       
    public void ganador(){
        if(player1.getShoots() == 24)
            mensaje(player1 , COM);
        else
            if(COM.getShoots() == 24)
                mensaje(COM , player1);
        
            
    }
    private void mensaje(Jugador player , Jugador enemy) {
     this.notificar();
     JOptionPane.showMessageDialog(null, "Jugador Ganador: "+ player.getName()
                +"\n numero de fallos: " + (player.getMoves() - player.getShoots())
                +"\n numero de aciertos enemigo: " + enemy.getShoots()
                    , "Fin del Juego", JOptionPane.PLAIN_MESSAGE);
     this.reiniciarJuego(player1.getName());
    }
   
    
 
    
    
}


