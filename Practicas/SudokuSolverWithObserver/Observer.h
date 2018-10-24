/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Observer.h
 * Author: david_perez
 *
 * Created on 16 de octubre de 2018, 10:07 PM
 */

#ifndef OBSERVER_H
#define OBSERVER_H

#include "Observable.h"

template <class Object>
class Observer{
    public:
        void update(Object o, Observable x) = 0;
};


#endif /* OBSERVER_H */

