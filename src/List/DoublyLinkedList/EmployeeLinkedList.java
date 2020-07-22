package List.DoublyLinkedList;

public class EmployeeLinkedList {

    private EmployeeNode head;
    private int size;
    private EmployeeNode tail; //points to last node. initialized to null

    public void addToFront(Employee employee) {
        EmployeeNode newNode = new EmployeeNode(employee);
        newNode.setNext(head); //set next to be old head
        //only have to worry about tail when list is empty
        if(head == null) {
            tail = newNode;
        } else {
            head.setPrevious(newNode); //if not empty
        }
        head = newNode; //
        size++;
    }

    public void addToEnd(Employee employee) {

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
            System.out.println("<->"); //points back
            current = current.getNext();
        }
        System.out.println("null");
    }


}
