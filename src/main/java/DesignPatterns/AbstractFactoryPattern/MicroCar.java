package DesignPatterns.AbstractFactoryPattern;

public class MicroCar extends Car {

    public MicroCar(Location location)
    {
        super(CarType.MICRO, location);
        construct();
    }

    public void construct() {
        System.out.println("Connecting to luxury car");
    }
}