package DemoAnnotation;

public class MainClass {

    public static void main(String[] args) {
        Car car = new Car("Ford", "F150", "2018");
        JsonSerializer serializer = new JsonSerializer();
        serializer.serialize(car);
    }
}
