package LinkedLists.DoublyLinkedList;

class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=>" + next +
                '}';
    }
}

public class DoublyLinkedList {
    Node head;
    int size;

    public DoublyLinkedList(Node head) {
        this.head = head;
        this.size = 1;
    }
    void addToEnd(int data) {
        Node n = new Node(data);
       if (head == null) {
           head = n;
       } else {
           Node curr = head;
           while (curr.next != null) {
               curr = curr.next;
           }
           curr.next = n;
           n.prev = curr;
           size++;
       }
    }
    void addToStart(int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
        } else {
            n.next = head;
            head.prev = n;
            head = n;
            size++;
        }
    }

    public static void main(String[] args) {
       Node n = new Node(1);
        DoublyLinkedList l = new DoublyLinkedList(n);
        l.addToEnd(2);
        l.addToEnd(3);
        l.addToEnd(4);
        l.addToEnd(5);
        System.out.println(l.head);
    }




}

