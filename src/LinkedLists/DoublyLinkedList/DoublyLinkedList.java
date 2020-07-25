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
                //", next=>" + next +
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
           Node toDelete = head;
           while (toDelete.next != null) {
               toDelete = toDelete.next;
           }
           toDelete.next = n;
           n.prev = toDelete;
           size++;
       }
    }
    void insertAfterRecursive(Node toDelete, int insertAfter, int data) {
        if (toDelete == null) return;
        //if the data matches what's given
        if (toDelete.data == insertAfter) {
            //create new node
            Node n = new Node(data);
            //as long as it's not the last node
            if (toDelete.next != null) {
                //take the next node's previous pointer and point to our new node
                toDelete.next.prev = n;
                //our new node's next is now set to toDelete.next
                n.next = toDelete.next;
            }
            //this toDelete.next is the last node, so assign it to new node
            toDelete.next = n;
            n.prev = toDelete; //new node's previous pointer is the toDeleteent
        } else {
            //repeats process for every node after
            insertAfterRecursive(toDelete.next, insertAfter, data);
        }
    }

    //O(1)
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
       Node toDelete = head;
       if (head == null || head.next == null) {
           head = null;
           return toDelete; //return head
       }
       //if it's not the last node, then skip one node
       while (toDelete.next != null) {
           toDelete = toDelete.next;
       }
       //if it's the last node,
        // then set the previous node's next point to point to null
       if (toDelete.next == null) {
           size--;
           toDelete.prev.next = null;
       }
       return toDelete;
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

    Node deleteAfter(int data) {
        Node toDelete = head;
        /* null<- head:3 -> prev <-5->next ->prev <-7->next -> null
         if want to delete after data=3
         */
        while(toDelete != null && toDelete.data != data) {

            if (toDelete.data == data) {
                toDelete = toDelete.next;
                return null;
            }
        }
        if (toDelete != null) {
            //if 5 is not the last node
            if (toDelete.next != null) {
                //set 7's previous pointer to be 5's previous, which is 3
                toDelete.next.prev = toDelete.prev;
                size--;
            }
            //if it's 3 is the last node, then just set 3's next pointer to point to 7
            toDelete.prev.next = toDelete.next;
            size--;
        }
        return toDelete;
    }






    public static void main(String[] args) {
       Node n = new Node(1);
        DoublyLinkedList l = new DoublyLinkedList(n);
        l.addToEnd(2);
        l.addToEnd(3);
        l.addToEnd(4);
        l.addToEnd(5);
        l.deleteAfter(2);

        //System.out.println(l.head);
//        System.out.println(l.size);
//        System.out.println(l.deleteLast());
        System.out.println(l.deleteAfter(2));

    }




}

/*Node{data=1, next=>Node{data=1, next=>Node{data=2, next=>Node{data=3, next=>Node{data=4, next=>null}}}}}
5

 */