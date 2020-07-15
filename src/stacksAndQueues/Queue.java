package stacksAndQueues;

public class Queue {
    public static void main(String[] args) {

    }

    private static class Node {
        private int data;
        private Node next;
        private Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;

    public boolean isEmpty() {
        return head == null;
    }
    public int peek() {
        return head.data;
    }
    public void add(int data) {
       Node node = new Node(data);
       //keep going
       if (tail != null) {
           tail.next = node;
       }
       tail = node; //update the tail
        //if empty, assign node as head
        if (head == null) {
            head = node;
        }

    }
    public int remove() {
        //remove from the front
        int data = head.data;
        head = head.next;
        //if head is null, tail has to be null too
        if (head == null) {
            tail = null;
        }
        return data;
    }
}
