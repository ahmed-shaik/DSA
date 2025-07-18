package BinaryTree.Easy;

import BinaryTree.Easy.BinaryTreePreOrderTraversal.TreeNode;

public class SubtreeofAnotherTree {
    class Solution {
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if (root == null) {
                return false;
            }
            if (root.val == subRoot.val) {
                if (isIdentical(root, subRoot)) {
                    return true;
                }
            }
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        public boolean isIdentical(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null) {
                return true;
            }
            if (root1 == null || root2 == null || root1.val != root2.val) {
                return false;
            }
            return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
        }
    }

}
