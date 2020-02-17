package DesignPatterns.ObserverPattern;

public class StockObserver implements Observer {

    private StockGrabber stockGrabber;

    private double arvindPrice;
    private double raymondPrice;

    int observerId;

    static int observerCount = 0;

    public StockObserver(StockGrabber stockGrabber) {
        this.stockGrabber = stockGrabber;
        observerId = ++observerCount;
        System.out.println("New Observer " + observerId);
        stockGrabber.register(this);
    }

    public void update(double  arvindPrice, double raymondPrice) {
        this.arvindPrice = arvindPrice;
        this.raymondPrice = raymondPrice;
        printStockPrice();
    }

    private void printStockPrice() {
        System.out.println("observer " + observerId + ", arvindPrice : " + arvindPrice  + ", raymondPrice : " + raymondPrice);
    }

}
