package List.SinglyLinkedList;

public class EmployeeLinkedList {

    private EmployeeNode head;
    private int size;

    public void addToFront(Employee employee) {
        EmployeeNode newNode = new EmployeeNode(employee);
        newNode.setNext(head); //set next to be old head
        head = newNode;
        size++;
    }

    public EmployeeNode removeFromFront() {
        if (isEmpty()) {
            return null;
        }
        EmployeeNode removedNode = head;
        head = head.getNext(); //head now points to the 2nd item in the list
        size--;
        removedNode.setNext(null);
        return removedNode;

    }
    public int getSize() {
        return size;
    }
    public boolean isEmpty() {
        return head == null;
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

    public void atToTail() { }
    public void removeAtTail() { }
    public void addAtIndex() {
    }
    public void deleteAtIndex() {
    }



}
