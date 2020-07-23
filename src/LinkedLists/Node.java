package LinkedLists;


public class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
    @Override
    public String toString() {
        return "Node {" +
                "data=" + data +
                ", next= " + next +
                '}';
    }
}

class LinkedList {
    Node head;
    int size;

    public LinkedList(Node head) {
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
            size++;
        }
    }
    void addToStart(int data) {
        Node n = new Node(data);
        n.next = head;
        head = n;
    }

    void addAtIndex(int data, int idx) {
        Node n = new Node(data);
        int i = 0;
        Node curr = head;
        while (i <= idx) {
            if (i == idx) {
                n.next = curr.next;
                      curr.next = n;
            }
            curr = curr.next;
            i++;
            size++;
        }
    }
    void deleteAtIndex(int data, int idx) {
        Node n = new Node(data);
        int i = 0;
        Node curr = head;
        while (i < idx) {
            if (i == idx-1) {
                curr.next = null;
                curr
            }
            curr.next = null;
            i++;
            size++;
        }
    }

    Node deleteLast() {
        Node curr = head;
        if (curr == null || curr.next == null) {
            head = null;
            return curr;
        }
        Node nextNode = curr.next;
        while (curr.next != null) {
            if (nextNode.next == null) {
                curr.next = null; //set to null
            }
            curr = nextNode; //hold this reference to return it later
            nextNode = nextNode.next; //null
        }
        return curr;
    }

    Node deleteStart() {
        if (head != null) {
            Node toDelete = head;
            head = head.next;
            return toDelete;
        }
        return null;
    }



    public static void main(String[] args) {
        Node n = new Node(1);

        LinkedList l = new LinkedList(n);
        l.addToEnd(2);
        l.addToStart(3);
        l.addToStart(5);
        l.addAtIndex(100, 1);
        System.out.println(l.head);




    }
}



/*
5, 3, 1, 2
5, 3, 100, 1, 2

Node {data=5, next=
                    Node {data=3, next=
                                        Node {data=1, next=
                                                         Node {data=2, next= null}}}}

Node {data=5, next=
                    Node {data=3, next=
                                        Node {data=100, next=
                                                            Node {data=1, next=
                                                                                Node {data=2, next= null}}}}}


 */