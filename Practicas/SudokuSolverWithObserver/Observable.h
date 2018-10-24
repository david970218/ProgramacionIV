/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Observable.h
 * Author: david_perez
 *
 * Created on 16 de octubre de 2018, 10:09 PM
 */

#ifndef OBSERVABLE_H
#define OBSERVABLE_H
#include "Observer.h"
template <class Object>
class Observable{
    public: 
        void Notify(Object o) = 0;
        void addObserver(Observer o) = 0;
};


#endif /* OBSERVABLE_H */

