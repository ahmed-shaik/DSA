package BinaryTree.Easy;

import BinaryTree.Easy.BinaryTreePreOrderTraversal.TreeNode;

public class BalancedBinaryTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public int height(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }

        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution2 {
        public boolean isBalanced(TreeNode root) {
            return maxDepth(root) != -1;
        }

        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int lh = maxDepth(root.left);
            if (lh == -1) {
                return -1;
            }
            int rh = maxDepth(root.right);
            if (rh == -1) {
                return -1;
            }
            if (Math.abs(lh - rh) > 1) {
                return -1;
            }
            return 1 + Math.max(lh, rh);
        }
    }
}
