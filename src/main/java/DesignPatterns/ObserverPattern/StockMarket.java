package DesignPatterns.ObserverPattern;

public class StockMarket {

    public static void main(String[] args) {
        StockGrabber stockGrabber = new StockGrabber();
        StockObserver stockObserver1 = new StockObserver(stockGrabber);
        stockGrabber.setRaymondPrice(740.23);
        stockGrabber.setArvindPrice(566.02);

        StockObserver stockObserver2 = new StockObserver(stockGrabber);
        stockGrabber.setRaymondPrice(230.63);
        stockGrabber.setArvindPrice(170.63);
    }
}
