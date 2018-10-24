/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Cell.h
 * Author: david_perez
 *
 * Created on 16 de octubre de 2018, 10:12 PM
 */

#ifndef CELL_H
#define CELL_H
#include <vector>
class Cell;


#include "Observable.h"
#include "Observer.h"

class Observer<Cell>;
class Observable<Cell>;
template <class >
class Cell : public Observer , public Observable{
    private:
    public:
        void addObserver(Observer o){}
        void update(Object o);
        
        std::vector<Observer> observadores;
};


#endif /* CELL_H */

