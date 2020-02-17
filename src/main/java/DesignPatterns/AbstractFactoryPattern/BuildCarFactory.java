package DesignPatterns.AbstractFactoryPattern;

public class BuildCarFactory {

    private BuildCarFactory()
    {

    }
    public static Car buildCar(CarType type)
    {
        Car car = null;
        // We can add any GPS Function here which
        // read location property somewhere from configuration
        // and use location specific car factory
        // Currently I'm just using INDIA as Location
        Location location = Location.INDIA;

        switch(location)
        {
            case USA:
                car = USAFactory.buildCar(type);
                break;

            case INDIA:
                car = IndiaFactory.buildCar(type);
                break;

            default:
                car = DefaultFactory.buildCar(type);

        }

        return car;

    }
}
