package DesignPatterns.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public interface Subject {

    List<Observer> observers = new ArrayList<>();

    public void register(Observer observer);
    public void unRegister(Observer observer);
    public void notifyObserver();
}
