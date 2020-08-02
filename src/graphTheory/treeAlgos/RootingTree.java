package graphTheory.treeAlgos;
import java.util.*;

//Rooting: useful on undirected tree
public class RootingTree {
    public static class TreeNode {
        private int id;
        private TreeNode parent;
        private List<TreeNode> children;

        public TreeNode(int id) {
            this.id = id;
        }

        //given an ID, and a parent, createa a new node with (id, parent, list of nodes)
        public TreeNode(int id, TreeNode parent) {
            this.id = id;
            this.parent = parent;
            children = new LinkedList<>();//need to choose an implementation, not just an List interface
        }
        //varargs: 0 to multiple TreeNode objects can be passed in
        public void addChildren(TreeNode... nodes){
            for (TreeNode node : nodes) {
                children.add(node);
            }
        }

        public int getId() {
            return id;
        }

        public TreeNode getParent() {
            return parent;
        }

        public List<TreeNode> getChildren() {
            return children;
        }


        @Override
        public String toString() {
            return "TreeNode{" +
                    "id=" + id +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNode treeNode = (TreeNode) o;
            return id == treeNode.id;
        }






        //build with children, and root
        public static TreeNode rootTree(List<List<Integer>> graph, int rootId) {
            //using constructor on line 11, where root id = 0, parent = null, children empty list
            TreeNode root = new TreeNode(rootId);
            //return the graph, where root's parent = null
            return buildTree(graph, root);
        }
        //depth first build recursively
        private static TreeNode buildTree(List<List<Integer>> graph, TreeNode node) {
            //childId is within list of childIds
            for (int childId : graph.get(node.getId())) {
                //skip nodes that points back to parent
                if (node.getParent() != null && childId == node.getParent().getId()) {
                    continue;
                }
                //each child is created new with its id, and parent node
                //using the constructor public TreeNode(int id, TreeNode parent) on line 16
                TreeNode child = new TreeNode(childId, node);
                //adding a child to the existing children list of the parent node
                node.addChildren(child);
                //repeat process on that child
                buildTree(graph, child);
            }
            //node is root
            return node;
        }
    }
}
