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
    public Circular(Node last) {
        this.last = last;
        if (this.last != null) {
            this.last.next = last; //
        }
        //head -> last -> n
        //1 -> 2 -> 3 -> 1
        last = new Node(2);
        Node n = new Node(3);
        //new node's is placed in between 2 and 1
        // new node's next pointer points to what tail points to
        n.next = last.next;
        //tail's pointer now points at new node
        //2 -> 3
        last.next = n;
        //new node is now the tail
        last = n;
    }


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


