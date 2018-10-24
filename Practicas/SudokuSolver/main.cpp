/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * File:   main.cpp
 * Author: david_perez
 *
 * Created on 16 de octubre de 2018, 11:38 PM
 */


#include <vector>
#include <iostream>
#include <list>
#include <array>
#include <string.h>
using namespace std;
class Object{
public:
    int valor = 0;
    Object(){}
    Object(int valor){
        this->valor = valor;
    }
};
class Observer;

class Observable{
    public:
        virtual void Notify(Object *) = 0;
        virtual void addObserver(Observer *) = 0;
};

class Observer{
    public:
        virtual void update(Object *, Observable *){}
};

class Cell : public Observer , public Object , public Observable{
private:
    list<Observer *> *observadores = new list<Observer *>;
    list<int> *values = new list<int>;
    bool isSolved = false;
    int row,col;
public:
    Cell(int row,int col){
        this->row = row;
        this->col = col;
        for(int i = 1; i<=9; i++){
            values->push_front(i);
        }
    }
    void update(Object *o, Observable *x){
        int value;
        for(list<int>::iterator i = values->begin(); i != values->end(); ++i){
            value = *i;
            if(value == o->valor){
                values->erase(i);
                break;
            }
        }
        if(!isSolved && values->size() == 1){
            value = values->front();
            setValue(value);
        }

    }
    void Notify(Object *o){
        Observer *x;
        for(list<Observer *>::iterator i = observadores->begin(); i != observadores->end(); ++i){
            x =(*i);
            x->update(o,this);
        }
    }
    
    int getValue(){
        if(values->size()== 1){
            return values->front();
        }
        return 0;
    }
    
    void addObserver(Cell *cells[9][9]){
        for(int i = 0; i<9 ; i++){
            for(int j = 0 ; j< 9 ; j++){
              bool isSame = (i == row) && (j == col);
              bool isSameline = (i == row) || (j == col);
              bool isSecondary = (i/3 == row /3) && (j/3 == col/3);
              if(!isSame && (isSameline || isSecondary)){
                  addObserver(cells[i][j]);
              }
            }
        }
    }
    
    void setValue(int value){
        if(value != 0){
            values->clear();
            values->push_front(value);          
            isSolved = true;
            Notify(new Object(value));
        }
    }
    void addObserver(Observer *o){
        observadores->push_front(o);
    }
    
    
    
};

class Sudoku{
public:
    Cell *cells[9][9];
    Sudoku(){
        for(int i = 0; i<9;i++){
            for(int j = 0; j<9 ; j++){
                cells[i][j] = new Cell(i,j);
            }
        }
        
        for(int i = 0; i<9;i++){
            for(int j = 0; j<9 ; j++){
                cells[i][j]->addObserver(cells);
            }
        }
    }
    
    void setUp(int puzzle[9][9]){
        for(int i = 0; i<9;i++){
            for(int j = 0; j<9 ; j++){
                cells[i][j]->setValue(puzzle[i][j]);
            }
        }
    }
    
    int getCellValue(int i,int j){
        return cells[i][j]->getValue();
    }
    
    string toString(){
       string tosstring = "";
      
       for (int j = 0; j < 9; j++){
        for (int i = 0; i < 9; i++) {
            tosstring += to_string(getCellValue(j,i));
            if(i == 2 || i == 5){
                tosstring += "  ";
            }else
                if(i == 8){
                    tosstring += '\n';
                }
            }
            if(j == 2 || j == 5){
                tosstring += '\n';
            }
        }
       return tosstring;
    }
};

int main(int argc, char *argv[]) {
       int  puzzle[9][9]= {

{1, 0, 0, 0, 0, 0, 0, 0, 0},

{0, 0, 0, 0, 0, 0, 0, 0, 0},

{0, 0, 0, 0, 0, 0, 0, 0, 0},

{0, 0, 0, 0, 0, 0, 0, 0, 0},

{0, 0, 0, 0, 0, 0, 0, 0, 0},

{0, 0, 0, 0, 0, 0, 0, 0, 0},

{0, 0, 0, 0, 0, 0, 0, 0, 0},

{0, 0, 0, 0, 0, 0, 0, 0, 0},

{0, 0, 0, 0, 0, 0, 0, 0, 0}

};
     Sudoku *sudoku = new Sudoku();
     sudoku->setUp(puzzle);
     cout<<sudoku->toString()<<" hola";
}
