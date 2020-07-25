package LinkedLists.CircularLinkedList;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
public class Circular {
    Node last;
//    public CircularLinkedList(Node last) {
//        this.last = last;
//        if (this.last != null) {
//            this.last.next = last;
//        }
//    }
    /*
    1 -> 2 -> 3 -> 1
     */

    void addToEnd(int data) {
        Node n = new Node(data);
        if (last == null) {
            n.next = n;
        } else {
            n.next = last.next;
            last.next = n;
        }
        last = n;
    }
}


