package BinaryTree.Easy;

import BinaryTree.Easy.BinaryTreePreOrderTraversal.TreeNode;

public class SymmetricTree {
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            TreeNode left = root.left;
            invert(left);
            return symCheck(left, root.right);
        }

        public void invert(TreeNode root) {
            if (root == null) {
                return;
            }
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invert(root.left);
            invert(root.right);
        }

        public boolean symCheck(TreeNode n1, TreeNode n2) {
            if (n1 == null && n2 == null) {
                return true;
            }
            if (n1 == null || n2 == null || n1.val != n2.val) {
                return false;
            }
            return symCheck(n1.left, n2.left) && symCheck(n1.right, n1.right);
        }
    }

    class Solution2 {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return symCheck(root.left, root.right); // Check symmetry between left and right subtrees
        }

        public boolean symCheck(TreeNode n1, TreeNode n2) {
            if (n1 == null && n2 == null) {
                return true;
            }
            if (n1 == null || n2 == null || n1.val != n2.val) {
                return false;
            }
            // Compare left of n1 with right of n2 and right of n1 with left of n2
            return symCheck(n1.left, n2.right) && symCheck(n1.right, n2.left);
        }
    }

}
