package DesignPatterns.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class StockGrabber implements Subject {

    private double arvindPrice;
    private double raymondPrice;

    List<Observer> observers = new ArrayList<>();

    public void register(Observer observer) {
        observers.add(observer);
    }

    public void unRegister(Observer observer) {
        int index = observers.indexOf(observer);
        System.out.println("Unregister the observer " + (index+1));
        observers.remove(observer);
    }

    public void notifyObserver() {
        for(Observer o : observers) {
            o.update(arvindPrice, raymondPrice);
        }
    }

    public double getArvindPrice() {
        return arvindPrice;
    }

    public void setArvindPrice(double arvindPrice) {
        this.arvindPrice = arvindPrice;
        notifyObserver();
    }

    public double getRaymondPrice() {
        return raymondPrice;
    }

    public void setRaymondPrice(double raymondPrice) {
        this.raymondPrice = raymondPrice;
        notifyObserver();
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
        notifyObserver();
    }
}
