package BinaryTree.Medium;

import java.util.ArrayList;

import BinaryTree.Medium.BinaryTreeLevelOrderTraversal.TreeNode;

public class LowestCommonAncestorofaBinaryTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            ArrayList<TreeNode> l1 = new ArrayList<>();
            ArrayList<TreeNode> l2 = new ArrayList<>();
            getPath(root, p, l1);
            getPath(root, q, l2);
            int i = 0;
            for (; i < l1.size() && i < l2.size(); i++) {
                if (l1.get(i) != l2.get(i)) {
                    break;
                }
            }
            return l1.get(i - 1);
        }

        public static boolean getPath(TreeNode root, TreeNode n1, ArrayList<TreeNode> l1) {
            if (root == null) {
                return false;
            }
            l1.add(root);
            if (root == n1) {
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
    }

    class Solution2 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode n1, TreeNode n2) {
            if (root == null || root == n1 || root == n2) {
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, n1, n2);
            TreeNode right = lowestCommonAncestor(root.right, n1, n2);
            if (right == null) {
                return left;
            }
            if (left == null) {
                return right;
            }
            return root;
        }
    }
}
