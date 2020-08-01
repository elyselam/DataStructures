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

        public TreeNode(int id, TreeNode parent) {
            this.id = id;
            this.parent = parent;
            children = new LinkedList<>();
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

        public static TreeNode rootTree(List<List<Integer>> graph, int rootId) {
            TreeNode root = new TreeNode(rootId);
            return buildTree(graph, root);
        }
        //depth first search
        private static TreeNode buildTree(List<List<Integer>> graph, TreeNode node) {
            for (int childId : graph.get(node.getId())) {
                if (node.getParent() != null && childId == node.getParent().getId()) {
                    continue;
                }
                TreeNode child = new TreeNode(childId, node);
                node.addChildren(child);
                buildTree(graph, child);
            }
            return node;
        }



    }

}
