package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
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

        static class Infoo {
            int hd; // horizontal distance
            Node node;

            Infoo(int hd, Node node) {
                this.hd = hd;
                this.node = node;
            }
        }

        public static void topView(Node root) {
            Queue<Infoo> q = new LinkedList<>();
            HashMap<Integer, Node> map = new HashMap<>();
            int min = 0, max = 0;
            q.add(new Infoo(0, root));
            map.put(0, root);
            while (!q.isEmpty()) {
                int n = q.size();
                for (int i = 0; i < n; i++) {
                    Infoo curr = q.remove();
                    if (!map.containsKey(curr.hd)) {
                        map.put(curr.hd, curr.node);
                    }
                    if (curr.node.left != null) {
                        q.add(new Infoo(curr.hd - 1, curr.node.left));
                        min = Math.min(min, curr.hd - 1);
                    }
                    if (curr.node.right != null) {
                        q.add(new Infoo(curr.hd + 1, curr.node.right));
                        max = Math.max(max, curr.hd + 1);
                    }
                }
            }
            for (int i = min; i <= max; i++) {
                if (map.containsKey(i)) {
                    System.out.print(map.get(i).data + " ");
                }
            }
        }

        public static void bottomView(Node root) {
            Queue<Infoo> q = new LinkedList<>();
            HashMap<Integer, Node> map = new HashMap<>();
            int min = 0, max = 0;
            q.add(new Infoo(0, root));
            map.put(0, root);
            while (!q.isEmpty()) {
                int n = q.size();
                for (int i = 0; i < n; i++) {
                    Infoo curr = q.remove();
                    map.put(curr.hd, curr.node); // Update the node at this horizontal distance
                    if (curr.node.left != null) {
                        q.add(new Infoo(curr.hd - 1, curr.node.left));
                        min = Math.min(min, curr.hd - 1);
                    }
                    if (curr.node.right != null) {
                        q.add(new Infoo(curr.hd + 1, curr.node.right));
                        max = Math.max(max, curr.hd + 1);
                    }
                }
            }
            for (int i = min; i <= max; i++) {
                if (map.containsKey(i)) {
                    System.out.print(map.get(i).data + " ");
                }
            }
        }

        public static void kthLevel(Node root, int k, int i) {
            if (root == null) {
                return;
            }
            if (k == i) {
                System.out.print(root.data + " ");
                return;
            }
            kthLevel(root.left, k, i + 1);
            kthLevel(root.right, k, i + 1);
        }

        public static Node lowestCommonAncestor(Node root, int n1, int n2) {
            ArrayList<Node> l1 = new ArrayList<>();
            ArrayList<Node> l2 = new ArrayList<>();
            getPath(root, n1, l1);
            getPath(root, n2, l2);
            int i = 0;
            for (; i < l1.size() && i < l2.size(); i++) {
                if (l1.get(i) != l2.get(i)) {
                    break;
                }
            }
            return l1.get(i - 1);
        }

        public static boolean getPath(Node root, int n1, ArrayList<Node> l1) {
            if (root == null) {
                return false;
            }
            l1.add(root);
            if (root.data == n1) {
                return true;
            }
            boolean left = getPath(root.left, n1, l1);
            boolean right = getPath(root.right, n1, l1);
            if (left || right) {
                return true;
            }
            l1.remove(l1.size() - 1);
            return false;
        }

        public static Node lca2(Node root, Node n1, Node n2) {
            if (root == null || root == n1 || root == n2) {
                return root;
            }
            Node left = lca2(root.left, n1, n2);
            Node right = lca2(root.right, n1, n2);
            if (right == null) {
                return left;
            }
            if (left == null) {
                return right;
            }
            return root;
        }

        public static int minDist(Node root, int n1, int n2) {
            Node lca = lowestCommonAncestor(root, n1, n2);
            return distanceFromLCA(lca, n1) + distanceFromLCA(lca, n2);
        }

        public static int distanceFromLCA(Node root, int n1) {
            if (root == null) {
                return -1;
            }
            if (root.data == n1) {
                return 0;
            }
            int left = distanceFromLCA(root.left, n1);
            int right = distanceFromLCA(root.right, n1);
            if (left == -1 && right == -1) {
                return -1;
            } else if (left == -1) {
                return right + 1;
            } else {
                return left + 1;
            }
        }

        public static Node KthAncestor(Node root, int n1, int k) {
            ArrayList<Node> list = new ArrayList<>();
            findAncestors(root, n1, list);
            return list.get(list.size() - 1 - k);
        }

        public static boolean findAncestors(Node root, int n1, ArrayList<Node> list) {
            if (root == null) {
                return false;
            }
            list.add(root);
            if (root.data == n1) {
                return true;
            }
            boolean left = findAncestors(root.left, n1, list);
            boolean right = findAncestors(root.right, n1, list);
            if (left || right) {
                return true;
            }
            list.remove(list.size() - 1);
            return false;
        }

        public static int KthAncestor2(Node root, int n, int k) {
            if (root == null) {
                return -1;
            }
            if (root.data == n) {
                return 0;
            }
            int left = KthAncestor2(root.left, n, k);
            int right = KthAncestor2(root.right, n, k);
            if (left == -1 && right == -1) {
                return -1;
            }
            int max = Math.max(left, right);
            if (max + 1 == k) {
                System.out.println("Kth Ancestor of " + n + " is: " + root.data);
            }
            return max + 1;
        }

        public static int sumTree(Node root) {
            if (root == null) {
                return 0;
            }
            int left = sumTree(root.left);
            int right = sumTree(root.right);
            int data = root.data;
            int nl = root.left == null ? 0 : root.left.data;
            int nr = root.right == null ? 0 : root.right.data;
            root.data = left + right + nl + nr;
            return data;
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
        // Node subRoot = tree.buildTree(subRootNodes);

        // Check if subRoot is a subtree of root
        // boolean result = tree.isSubtree(root, subRoot);
        // System.out.println("Is subRoot a subtree of root? " + result);

        // Top view
        System.out.println("Top view of the tree: ");
        tree.topView(root);
        System.out.println();

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);
        root2.right.left = new Node(6);
        root2.right.right = new Node(7);
        /*
         * 1
         * / \
         * 2 3
         * / \ / \
         * 4 5 6 7
         */
        // Print kth level
        System.out.print("Elements: [");
        tree.kthLevel(root2, 2, 1);
        System.out.println("]");

        // lowest comon ancestor
        System.out.println("lca: " + tree.lowestCommonAncestor(root2, 7, 6).data);

        // /min distance
        System.out.println("Min dist:" + tree.minDist(root2, 4, 5));

        // kth ancestor
        System.out.println("kth Ancestor: " + tree.KthAncestor(root2, 6, 2).data);
        // kth ancestor 2
        System.out.print("Kth Ancestor 2: ");
        tree.KthAncestor2(root2, 5, 2);

        // Sum tree
        tree.sumTree(root2);
        tree.levelOrder(root2);
    }
}
