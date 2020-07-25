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
    void insertAfterRecursive(Node curr, int insertAfter, int data) {
        if (curr == null) return;
        //if the data matches what's given
        if (curr.data == insertAfter) {
            //create new node
            Node n = new Node(data);
            //as long as it's not the last node
            if (curr.next != null) {
                //take the next node's previous pointer and point to our new node
                curr.next.prev = n;
                //our new node's next is now set to curr.next
                n.next = curr.next;
            }
            //this curr.next is the last node, so assign it to new node
            curr.next = n;
            n.prev = curr; //new node's previous pointer is the current
        } else {
            //repeats process for every node after
            insertAfterRecursive(curr.next, insertAfter, data);
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
    Node deleteLast() {
       Node curr = head;
       if (head == null || head.next == null) {
           head = null;
           return curr; //return head
       }
       //if it's not the last node, then skip one node
       while (curr.next != null) {
           curr = curr.next;
           size--;
       }
       //if it's the last node,
        // then set the previous node's next point to point to null
       size--;
        return curr.prev.next = null;
    }

    Node deleteStart() {
        Node toDelete = head;
        if (head == null || head.next == null) {
            head = null;
            return toDelete; //return head
        }
        head = head.next;
        head.prev = null;
        return toDelete;

    }


    public static void main(String[] args) {
       Node n = new Node(1);
        DoublyLinkedList l = new DoublyLinkedList(n);
        l.addToEnd(2);
        l.addToEnd(3);
        l.addToEnd(4);
        l.addToEnd(5);
        l.addToStart(1);
        l.deleteLast();

        System.out.println(l.head);
    }




}

