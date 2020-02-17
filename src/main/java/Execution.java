import java.util.HashMap;
import java.util.Map;

public class Execution {

    public static void main(String[] a) {
        Employee e1 = new Employee("123");
        Employee e2 = new Employee("123");

        System.out.println(e1 == e2);
        System.out.println(e1.equals(e2));
        Map<Employee,Double > empRating = new HashMap<>();
        empRating.put(e1, new Double(3.8));
        empRating.put(e2, new Double(3.9));

        System.out.println(empRating.size());

    }
}
