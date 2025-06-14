package BinaryTree;

public class BinaryTrees {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            this.data = item;
            this.left = this.right = null;
        }
    }

    static class BinaryTree {
        static int i = -1;

        public static Node buildTree(int[] nodes) {
            i++;
            if (nodes[i] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[i]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        public static void preOrder(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void inOrder(Node root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        public static void postOrder(Node root) {
            if (root == null) {
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        // Tree is an heirarachical data structure that consists of nodes, where each
        // node has a value and can have zero or more child nodes. The topmost node is
        // called the root, and nodes with no children are called leaves. Trees are used
        // in various applications such as databases, file systems, and more.
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        // System.out.println(root.data);

        // traversal
        // Preorder - root, left, right
        tree.preOrder(root);
        System.out.println();
        // Ineorder - left,root , right
        tree.inOrder(root);
        System.out.println();
        // Postorder - left,right ,root
        tree.postOrder(root);
    }
}
