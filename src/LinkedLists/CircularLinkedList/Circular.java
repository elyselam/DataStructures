package LinkedLists.CircularLinkedList;

import java.util.concurrent.Callable;

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
//                ", next=" + next +
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
            n.next = n; //make last node reference itself
        } else {
            //if not last, make new node's next pointer point at whatever last is pointing at
            n.next = last.next;
            //then make last point to new node
            last.next = n;
        }
        last = n; //now the new node is the last
    }

    void addToStart(int data) {
        Node n = new Node(data);
        if (last == null) {
            n.next = n; //if nothing in list, node next references itself
            last = n; //and it's becomes tail
        } else { //if list not empty
            n.next = last.next; //new node's points to tail
            last.next = n; //tail's points to node as it becomes the head
        }
    }

    void addAfter(int insertAfter, int data) {
        if (last != null) {
            Node curr = last;
            while (curr != last) {
                if (curr.data == insertAfter) {
                    Node n = new Node(data);
                    n.next = curr.next;
                    curr.next = n;
                    break;
                }
                curr = curr.next;
            }
        }
    }

//    Node deleteLast() {
//        Node toDelete = last;
//        if (last == null || last.next == last) {
//
//        }
//    }




    public static void main(String[] args) {
        Node n = new Node(1);
        Circular l = new Circular(n);
        l.addToEnd(100);

        Node curr = l.last;
        while(curr != null) {
            System.out.println(curr);
            curr = curr.next;
        }
    }
}


