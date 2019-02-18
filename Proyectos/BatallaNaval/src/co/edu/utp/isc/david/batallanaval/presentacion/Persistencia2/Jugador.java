/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.david.batallanaval.presentacion.Persistencia2;

/**
 *
 * @author Usuario UTP
 */
public class Jugador {
    private int[][] maze = new int[15][15];
    private String name;
    private int moves, shoots;
    
    Jugador(String name){
        llenarMaze();
        this.name = name;
        moves = 0;
        shoots = 0;
    }
    
    private void llenarMaze1() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                maze[i][j]=0;
            }
        }
        for (int i = 0; i < 20; i++) {
            if(i < 10){
              int x = (int) (Math.random() * 15);
              int y = (int) (Math.random() * 15);
              while(true){
                  if(maze[x][y] == 0){
                      maze[x][y] = 1;
                      break;
                  }
                    x = (int) (Math.random() * 15);
                    y = (int) (Math.random() * 15);
                  }
            }else if(i >= 10 && i < 15){
                
                int x = (int) (Math.random() * 15);
                int y = (int) (Math.random() * 15);
                while(true){
    
                  if(maze[x][y] == 0 && x+1 < 15  && x-1 > 0 ){
      
                      if(maze[x+1][y] == 0){
                         if((x+2 < 15 && maze[x+2][y] == 0 && x-1 > 0 && maze[x-1][y] == 0 ) &&
                             (y+1 < 14 && maze[x][y+1] == 0 && maze[x+1][y+1] == 0) &&
                             (y-1 > 0 && maze[x][y-1] == 0 && maze[x+1][y-1] == 0)){
                          maze[x][y] = 2;
                          maze[x+1][y] = 2;
                          break;
                         }
                          
                      
                      }else if(maze[x-1][y] == 0){
                      
                           if((x-2 > 0 && maze[x-2][y] == 0 && x+1 < 15 && maze[x+1][y] == 0) &&
                             (y+1 < 14 && maze[x][y+1] == 0 && maze[x-1][y+1] == 0) &&
                             (y-1 > 0 && maze[x][y-1] == 0 && maze[x-1][y-1] == 0)){
                          maze[x][y] = 2;
                          maze[x-1][y] = 2;
                          break;
                         }
                      }
                  }  
                  x = (int) (Math.random() * 15);
                  y = (int) (Math.random() * 15);
              }
            
            }else{
                int x = (int) (Math.random() * 15);
                int y = (int) (Math.random() * 15);
                while(true){
    
                  if(maze[x][y] == 0 && y+1 < 15  && y-1 > 0 ){
      
                      if(maze[x][y+1] == 0){
                      
                          if((y+2 < 15 && maze[x][y+2] == 0 && y - 1 > 0 && maze[x][y-1] == 0) &&
                             (x+1 < 14 && maze[x+1][y] == 0 && maze[x+1][y+1] == 0) &&
                             (x-1 > 0 && maze[x-1][y] == 0 && maze[x-1][y+1] == 0)){
                          maze[x][y] = 2;
                          maze[x][y+1] = 2;
                          break;
                         }
                      
                      }else if(maze[x][y-1] == 0){
                      
                         if((y-2 < 15 && maze[x][y-2] == 0 && y+1 < 15 && maze[x][y+1] == 0) &&
                             (x+1 < 14 && maze[x+1][y] == 0 && maze[x+1][y-1] == 0) &&
                             (x-1 > 0 && maze[x-1][y] == 0 && maze[x-1][y-1] == 0)){
                          maze[x][y] = 2;
                          maze[x][y-1] = 2;
                          break;
                         }
                      }
                  }  
                  x = (int) (Math.random() * 15);
                  y = (int) (Math.random() * 15);
              }
            }
        }
     
     
    }
    
    public void llenarMaze(){
        for (int i = 0; i < 13; i++) {
            if(i == 0){
                int x = (int) (Math.random() * 15);
                int y = (int) (Math.random() * 15);
                int dir = (int) (Math.random() * 2);
                
                while(true){
                    if(dir == 0){
                         if (maze[y][x] == 0 && x+3 < 15) {
                             for (int j = 0; j < 4; j++) {
                                 maze[y][x + j] = 4;
                             }
                             
                             break;
                        }else if(maze[y][x] == 0 && x-3 > 0){
                             for (int j = 0; j < 4; j++) {
                                 maze[y][x - j] = 4;
                             }
                                
                                break;
                            }
                            
                        
                    }else {
                         if (maze[y][x] == 0 && y+3 < 15) {
                             for (int j = 0; j < 4; j++) {
                                 maze[y + j][x] = 4;
                             }
                             
                             break;
                        }else if(maze[y][x] == 0 && y-3 > 0){
                             for (int j = 0; j < 4; j++) {
                                 maze[y - j][x] = 4;
                             }
                                
                                break;
                            }
                    }
                    
                     x = (int) (Math.random() * 15);
                     y = (int) (Math.random() * 15);
                     dir = (int) (Math.random() * 2);
                }
            }else if(i > 0 && i < 3){
                    int x = (int) (Math.random() * 15);
                    int y = (int) (Math.random() * 15);
                    int dir = i%2;
                    while(true){
                        if(dir == 0){
                            if (x+ 2 < 15 && maze[y][x] == 0 && maze[y][x + 1] == 0 &&
                                 maze[y][x+2] ==0){
                                 for (int j = 0; j < 3; j++) {
                                    maze[y][x + j] = 3;
                                }

                                break;
                           }else if(x - 2 > 0 && maze[y][x] == 0 && maze[y][x - 1] == 0 &&
                                 maze[y][x-2] == 0){
                                for (int j = 0; j < 3; j++) {
                                    maze[y][x - j] = 3;
                                }
                                   break;
                               }
                    }else {
                         if (y + 2< 15 && maze[y][x] == 0 && maze[y+1][x] == 0 &&
                              maze[y + 2][x] == 0) {
                             for (int j = 0; j < 3; j++) {
                                 maze[y + j][x] = 3;
                             }
                             
                             break;
                        }else if(y - 2 < 15 && maze[y][x] == 0 && maze[y - 1][x] == 0 &&
                              maze[y - 2][x] ==0 ){
                             for (int j = 0; j < 3; j++) {
                                 maze[y - j][x] = 3;
                             }
                                break;
                            }
                    }
                    
                     x = (int) (Math.random() * 15);
                     y = (int) (Math.random() * 15);
                     
                }
                        
                        
                    } else if(i > 2 && i < 7){
                    int x = (int) (Math.random() * 15);
                    int y = (int) (Math.random() * 15);
                    int dir = i%2;
                    while(true){
                        if(dir == 0){
                            if (x+1 < 15 && maze[y][x] == 0 && maze[y][x + 1] == 0){
                                 for (int j = 0; j < 2; j++) {
                                    maze[y][x + j] = 2;
                                }

                                break;
                           }else if(x-2 > 0 && maze[y][x] == 0 && maze[y][x - 1] == 0 ){
                                for (int j = 0; j < 2; j++) {
                                    maze[y][x - j] = 2;
                                }
                                   break;
                               }
                    }else {
                         if (y + 2< 15 && maze[y][x] == 0 && maze[y+1][x] == 0) {
                             for (int j = 0; j < 2; j++) {
                                 maze[y + j][x] =2;
                             }
                             
                             break;
                        }else if(y - 2 < 15 && maze[y][x] == 0 && maze[y - 1][x] == 0){
                             for (int j = 0; j < 2; j++) {
                                 maze[y - j][x] = 2;
                             }
                                break;
                            }
                    }
                    
                     x = (int) (Math.random() * 15);
                     y = (int) (Math.random() * 15);
                     
                }
               } else if(i > 6 && i < 13){
                   int x = (int) (Math.random() * 15);
                  int y = (int) (Math.random() * 15);
                  while(true){
                      if(maze[y][x] == 0){
                          maze[y][x] = 1;
                          break;
                      } 
                       x = (int) (Math.random() * 15);                       
                       y = (int) (Math.random() * 15);


                  }
               }
            }
        }
    

    

    public int[][] getMaze() {
        return maze;
    }

    public String getName() {
        return name;
    }

    public int getMoves() {
        return moves;
    }

 

    public void setName(String name) {
        this.name = name;
    }

    public void setMoves(int moves) {
        this.moves = moves;
    }

   public boolean shot(int x, int y){
        if(maze[x][y] == 0){
            maze[x][y] = -1;
            
            return false;
        }
        
        if(maze[x][y] == 1) {
            maze[x][y] = 5;
            return true;
        }
        
        if (maze[x][y] == 2) {
           maze[x][y] = 6;
           return true;
        }
        
        if (maze[x][y] == 3) {
            maze[x][y] = 7;
            return true;
       } 
        
       if (maze[x][y] == 4) {
           maze[x][y] = 8;
           return true;
       }
        return false;
             
   }

   public void mostrarMaze() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                System.out.print(maze[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public int getShoots() {
        return shoots;
    }

    public void setShoots(int shoots) {
        this.shoots = shoots;
    }
 
    
}
