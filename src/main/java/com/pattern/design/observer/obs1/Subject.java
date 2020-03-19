package com.pattern.design.observer.obs1;

/**
 * 主题
 */
public interface Subject {
    void registeSubject(Observer obs);
    void removeSubject(Observer obs);
    void notifySubjects(Message message);
}
