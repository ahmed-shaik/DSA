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

        public static int height(Node root) {
            if (root == null) {
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);
            return Math.max(lh, rh) + 1;
        }

        public static int countNode(Node root) {
            if (root == null) {
                return 0;
            }
            int lh = countNode(root.left);
            int rh = countNode(root.right);
            return 1 + lh + rh;
        }

        public static int sumOfNodes(Node root) {
            if (root == null) {
                return 0;
            }
            int lh = sumOfNodes(root.left);
            int rh = sumOfNodes(root.right);
            return root.data + lh + rh;
        }

        public static int diameter1(Node root) {
            if (root == null) {
                return 0;
            }
            int ld = diameter1(root.left);
            int rd = diameter1(root.right);
            int lh = height(root.left);
            int rh = height(root.right);
            return Math.max(Math.max(ld, rd), lh + rh + 1);
        }

        static class Info {
            int h;
            int d;

            Info(int h, int d) {
                this.h = h;
                this.d = d;
            }
        }

        public static Info diameter2(Node root) {
            if (root == null) {
                return new Info(0, 0);
            }
            Info leftInfo = diameter2(root.left);
            Info rightInfo = diameter2(root.right);
            int height = Math.max(leftInfo.h, rightInfo.h) + 1;
            int diameter = Math.max(Math.max(leftInfo.d, rightInfo.d), leftInfo.h + rightInfo.h + 1);
            return new Info(height, diameter);
        }

        public static boolean isSubtree(Node root1, Node root2) {
            if (root1 == null) {
                return false;
            }
            // If root1's value matches root2's value, check if the two trees are identical
            if (root1.data == root2.data) {
                if (isIdentical(root1, root2)) {
                    return true;
                }
            }
            // Otherwise, check the left and right subtrees of root1
            return isSubtree(root1.left, root2) || isSubtree(root1.right, root2);
        }

        // Helper function to check if two trees are identical
        public static boolean isIdentical(Node root1, Node root2) {
            if (root1 == null && root2 == null) {
                return true;
            }
            if (root1 == null || root2 == null || root1.data != root2.data) {
                return false;
            }
            return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
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

        // clalculate height of the tree
        System.out.println("Height of the tree: " + tree.height(root));

        // Count no. of nodes in the tree
        System.out.println("No. of nodes:" + tree.countNode(root));

        // sum of all nodes in the tree
        System.out.println("Sum of all nodes: " + tree.sumOfNodes(root));

        // diameter of the tree
        // The diameter of a tree is the longest path between any two leaves in the
        // tree.
        System.out.println("Diameter of the tree: " + tree.diameter1(root));

        // subtree of another tree
        int subRootNodes[] = { 2, 4, -1, -1, 5, -1, -1 };
        Node subRoot = tree.buildTree(subRootNodes);

        // Check if subRoot is a subtree of root
        boolean result = tree.isSubtree(root, subRoot);
        System.out.println("Is subRoot a subtree of root? " + result);
    }
}
