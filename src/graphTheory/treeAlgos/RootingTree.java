package graphTheory.treeAlgos;
import java.util.*;

//Rooting: useful on undirected tree
public class RootingTree {
    public static class TreeNode {
        private int id;
        private TreeNode parent;
        private List<TreeNode> children;

        public TreeNode(int id) {
            this.id = id; //this(id, null); if we want to call the 2nd constructor
            children = new LinkedList<>();
        }

        //given an ID, and a parent, createa a new node with (id, parent, list of nodes)
        public TreeNode(int id, TreeNode parent) {
            this.id = id;
            this.parent = parent;
            children = new LinkedList<>();//need to choose an implementation, not just an List interface
        }

        //varargs: 0 to multiple TreeNode objects can be passed in
        public void addChildren(TreeNode... nodes) {
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


        private static List<List<Integer>> createGraph(int n) {
            List<List<Integer>> graph = new ArrayList<>(n);
            for (int i = 0; i < n; i++) graph.add(new LinkedList<>());
            return graph;
        }

        private static void addUndirectedEdge(List<List<Integer>> graph, int from, int to) {
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        public static void main(String[] args) {

            List<List<Integer>> graph = createGraph(9);
            addUndirectedEdge(graph, 0, 1);
            addUndirectedEdge(graph, 2, 1);
            addUndirectedEdge(graph, 2, 3);
            addUndirectedEdge(graph, 3, 4);
            addUndirectedEdge(graph, 5, 3);
            addUndirectedEdge(graph, 2, 6);
            addUndirectedEdge(graph, 6, 7);
            addUndirectedEdge(graph, 6, 8);

            // Rooted at 6 the tree should look like:
            //           6
            //      2    7     8
            //    1   3
            //  0    4 5
            TreeNode root = rootTree(graph, 6);

            // Layer 0: [6]
            System.out.println(root);
            // Layer 1: [2, 7, 8]
            System.out.println(root.children);

            // Layer 2: [1, 3]
            System.out.println(root.children.get(0).children);

            // Layer 3: [0], [4, 5]
            System.out.println(
                    root.children.get(0).children.get(0).children
                            + ", "
                            + root.children.get(0).children.get(1).children);
        }

        /*TreeNode{id=6}
[TreeNode{id=2}, TreeNode{id=7}, TreeNode{id=8}]
[TreeNode{id=1}, TreeNode{id=3}]
[TreeNode{id=0}], [TreeNode{id=4}, TreeNode{id=5}]

         */
    }
}

