package List.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("elyse", "lam", 123));
        employeeList.add(new Employee("e", "l", 456));
        employeeList.add(new Employee("louie", "boogie", 789));
        employeeList.add(new Employee("sausage", "lam", 111));

        employeeList.forEach(e -> System.out.println(e));
        System.out.println(employeeList.get(1));
        System.out.println(employeeList.isEmpty());

        employeeList.set(1, new Employee("elsie", "l", 234));
        employeeList.forEach(e -> System.out.println(e));
//        employeeList.add(3, new Employee())

        Employee[] employeeArray = employeeList.toArray(new Employee[employeeList.size()]);
        for (Employee employee: employeeArray) {
            System.out.println(employee);
        }

        System.out.println(employeeList.contains(new Employee("b", "s", 22)));
        System.out.println(employeeList.indexOf(new Employee("e", "l", 456)));

    }
}
