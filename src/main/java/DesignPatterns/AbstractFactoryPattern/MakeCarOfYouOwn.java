package DesignPatterns.AbstractFactoryPattern;

public class MakeCarOfYouOwn {

    public static void main(String[] args) {
        System.out.println(BuildCarFactory.buildCar(CarType.LUXURY));
    }
}
