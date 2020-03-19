package com.pattern.design.observer.obs1;

public class Demo {
    public static void main(String[] args) {
        ConcreteSubject cs = new ConcreteSubject();
        cs.registeSubject(new ConcreteOberverOne());
        cs.registeSubject(new ConcreteOberverTwo());
        cs.notifySubjects(new Message());
    }
}
