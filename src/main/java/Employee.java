//import lombok.AccessLevel;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.experimental.FieldDefaults;

import java.util.Objects;

public class Employee{

    String regNo;

    public Employee(String regNo) {
        this.regNo = regNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        System.out.println(this.regNo == ((Employee) o).regNo);
        return Objects.equals(regNo, employee.regNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regNo);
    }
}

