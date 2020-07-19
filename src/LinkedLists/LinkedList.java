package LinkedLists;

import com.sun.org.apache.xml.internal.dtm.ref.DTMAxisIterNodeList;

public class LinkedList<E> {

    //inner class to restrict access
    class Node<E> {
        E data;
        Node<E> next;
        public Node(E obj) {
            data = obj;
            next = null;
        }
    }
    private Node<E> head;
    private int currentSize; //O(1) access to size of list, w/out it, we have O(n)

    public LinkedList(){
        head = null;
        currentSize = 0;
    }
    /*
    boundary conditions:
    1) is empty
    2) has single element
    3) adding/removing from front
    4) adding/removing from end
    5) working in middle
      */

    public void addFirst(E obj) {
        Node<E> node = new Node<E>(obj);
        node.next = head; //scoot head one spot over
        //so now head is the new node
        head = node;
        currentSize++;
    }

    public void addLast(E obj) {
        Node<E> node = new Node<E>(obj);
        if (head == null) {
            head = node;
            currentSize++;
            return;
        }
        //temp points at data, keeps moving until null
        Node<E> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        //add when reaches null
        temp.next = node;
        currentSize++;
    }





}
