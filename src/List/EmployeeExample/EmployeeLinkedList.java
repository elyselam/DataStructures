package List.EmployeeExample;

public class EmployeeLinkedList {

    private EmployeeNode head;
    private int size;

    public void addToFront(Employee employee) {
        EmployeeNode newNode = new EmployeeNode(employee);
        newNode.setNext(head); //set next to be old head
        head = newNode;
        size++;
    }
    public int getSize() {
        return size;
    }
    public void printList() {
        EmployeeNode current = head;
        System.out.println("head -> ");
        while (current != null) {
            System.out.println(current);
            System.out.println("->");
            current = current.getNext();
        }
        System.out.println("null");
    }
}
