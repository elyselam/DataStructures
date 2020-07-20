package List.EmployeeExample;

/*
vector == synchronized arrayList
 */
public class Main {
    public static void main(String[] args) {

        Employee e1 = new Employee("a", "b",1);
        Employee e2 = new Employee("c", "d",2);
        Employee e3 = new Employee("e", "f",3);

        EmployeeLinkedList lst = new EmployeeLinkedList();
        lst.addToFront(e1);
        lst.addToFront(e2);
        lst.addToFront(e3);
        lst.printList();
        System.out.println(lst.getSize());


//        List<Employee> employeeList = new ArrayList<>();
//        employeeList.add(new Employee("elyse", "lam", 123));
//        employeeList.add(new Employee("e", "l", 456));
//        employeeList.add(new Employee("louie", "boogie", 789));
//        employeeList.add(new Employee("sausage", "lam", 111));
//
//        employeeList.forEach(e -> System.out.println(e));
//        System.out.println(employeeList.get(1));
//        System.out.println(employeeList.isEmpty());
//
//        employeeList.set(1, new Employee("elsie", "l", 234));
//        employeeList.forEach(e -> System.out.println(e));
////        employeeList.add(3, new Employee())
//
//        Employee[] employeeArray = employeeList.toArray(new Employee[employeeList.size()]);
//        for (Employee employee: employeeArray) {
//            System.out.println(employee);
//        }
//
//        System.out.println(employeeList.contains(new Employee("b", "s", 22)));
//        System.out.println(employeeList.indexOf(new Employee("e", "l", 456)));

    }
}
