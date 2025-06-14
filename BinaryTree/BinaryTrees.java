package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

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

        public static void levelOrder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            queue.add(null);
            while (!queue.isEmpty()) {
                Node curr = queue.remove();
                if (curr == null) {
                    System.out.println();
                    if (queue.isEmpty()) {
                        break;
                    } else {
                        queue.add(null);
                    }
                } else {
                    System.out.print(curr.data + " ");
                    if (curr.left != null) {
                        queue.add(curr.left);
                    }
                    if (curr.right != null) {
                        queue.add(curr.right);
                    }
                }
            }
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
        System.out.print("Preorder: ");
        tree.preOrder(root);
        System.out.println();
        // Ineorder - left,root , right
        System.out.print("Inorder: ");
        tree.inOrder(root);
        System.out.println();
        // Postorder - left,right ,root
        System.out.print("Postorder: ");
        tree.postOrder(root);
        System.out.println();
        // level order traversal
        System.out.println("levelorder: ");
        tree.levelOrder(root);
    }
}
