package Tree;

//all nodes on left is smaller or equal to the right
//given tree has no dupes, so no equal
//linear time
//space: if balanced tree: O(log(n))



/*
Binary Tree: each node has 2 child nodes
make finding a node very fast
Balanced: insert() & search(): O(logn)
Unbalanced Tree: insert() & search(): O(n) bc just a long line
 */
public class BinarySearchTree {
    public static void main(String[] args) {

    }
    class Node {
        int data;
        Node left;
        Node right;


        boolean checkBST(Node root, int min, int max) {
            if (root == null) {
                return true;
            }
            if (root.data < min || root.data > max) {
                return false;
            }
            //left can smallest or one value smaller than the root
            return checkBST(root.left, min, root.data - 1) && checkBST(root.right, root.data + 1, max);

        }
        boolean checkBST(Node root) {
            return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
    }

}

