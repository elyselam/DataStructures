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
        size++;
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
        }
        size++;
    }

    Node deleteAtIndex(int idx) {
        int i = 0;
        Node curr = head;
        if (head == null) return null;
        if (idx > size) {
            throw new IndexOutOfBoundsException();
        }
        while (i < idx - 1) { //at the node before we want to delete
            curr = curr.next;
            i++;
        }
        Node temp = curr.next; //save the deleted item to return
        curr.next = curr.next.next; //skip the next to the one after it
        size--;
        return temp;
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

    Node deleteNthFromEnd(int n) {
        Node fast = head;
        Node slow = head;
        // 1->2->3->4->5, n = 2
        //fast = 3
        // now fast = 4
        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }
//      now fast = 5, slow = 2
//          fast = 5, slow = 3, break out of loop
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //slow skips 4 and now at 5
        slow.next = slow.next.next;
        size--;
        return slow.next;
    }

    //fast and slow pointers eventually collide if loop points back to itself
    boolean hasCycle() {
        if (head == null) return false;
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null && slow != null) {
            if (fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

    Node reverseLinkedList() {
        Node prevNode = null;
        while(head!=null) {
            Node nextNode = head.next;
            head.next = prevNode;
            prevNode = head;
            head = nextNode;
        }
        return prevNode;
    }


    public static void main(String[] args) {
        Node n = new Node(1);
        LinkedList l = new LinkedList(n);
        l.addToEnd(1);
        l.addToEnd(2);
        l.addToEnd(3);
        l.addToEnd(4);
        l.addToEnd(5);
//        l.addToStart(3);
//        l.addToStart(5);
//        l.addAtIndex(100, 1);
//        System.out.println(l.head);
//        System.out.println(l.size);
//        System.out.println(l.deleteAtIndex(2));
//        System.out.println(l.size);
//        l.deleteNthFromEnd(2); //removes 4
        System.out.println(l.reverseLinkedList());
//        Node curr = l.head;
//        while(curr != null) {
//            System.out.println(curr);
//            curr = curr.next;
//        }
    }
}
