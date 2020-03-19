package com.pattern.design.observer.obs1;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体主题
 */
public class ConcreteSubject implements Subject {

    List<Observer> observer = new ArrayList<Observer>();

    @Override
    public void registeSubject(Observer obs) {
        observer.add(obs);
    }

    @Override
    public void removeSubject(Observer obs) {
        observer.remove(obs);
    }

    @Override
    public void notifySubjects(Message message) {
        for(Observer obs:observer){
            obs.update(message);
        }
    }
}
