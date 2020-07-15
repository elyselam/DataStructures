package Tree;

public class Node {
    public static void main(String[] args) {
        Node n = new Node(2);
        n.insert(1);
        n.insert(3);
        n.insert(4);
        n.insert(5);
        //n.inOrder(); //1,2,3,4,5
        n.preOrder(); //2,1,3,4,5
        n.postOrder(); //1,3,4,5,2
    }
    Node left, right;
    int data;

    public Node(int data) {
        this.data = data;
    }

    public void insert(int value) {
        if (value <= data) {
            if (left == null) {
                left = new Node(value);
            } else {
                left.insert(value); //push down recursion stack
            }
        } else {
            if (right == null) {
                right = new Node(value);
            } else {
                right.insert(value);
            }
        }
    }
    public boolean contains(int value) {
        if (value == data) {
            return true;
        } else if (value < data) {
            if (left == null) {
                return false;
            } else {
                return left.contains(value);
            }
        } else {
            if (right == null) {
                return false;
            } else {
                return right.contains(value);
            }
        }
    }
    public void inOrder() {
        if (left != null) {
            left.inOrder();
        }
        System.out.println(data);
        if (right != null) {
            right.inOrder();
        }
    }
    public void preOrder() {

        System.out.println(data);
        if (left != null) {
            left.inOrder();
        }
        if (right != null) {
            right.inOrder();
        }
    }

    public void postOrder() {
        if (left != null) {
            left.inOrder();
        }
        if (right != null) {
            right.inOrder();
        }
        System.out.println(data);
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
