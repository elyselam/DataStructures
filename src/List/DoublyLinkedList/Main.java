package List.DoublyLinkedList;

/*
pro: operation at front and end of list in O(1)

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

        lst.removeFromFront();
        System.out.println(lst.getSize());
        lst.printList();



    }
}
