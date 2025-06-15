package BinaryTree.Hard;

public class BinaryTreeMaximumPathSum {

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public int maxPathSum(TreeNode root) {
            int[] d = new int[1];
            d[0] = Integer.MIN_VALUE;
            height(root, d);
            return d[0];
        }

        public static int height(TreeNode root, int[] d) {
            if (root == null) {
                return 0;
            }

            int ls = Math.max(0, height(root.left, d));
            int rs = Math.max(0, height(root.right, d));

            d[0] = Math.max(d[0], ls + rs + root.val);

            return Math.max(ls, rs) + root.val;
        }
    }

}
