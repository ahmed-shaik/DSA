package BinaryTree.Easy;

import BinaryTree.Easy.BinaryTreePreOrderTraversal.TreeNode;

public class DiameterofBinaryTree {
    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }

    public static int diameter1(TreeNode root) {
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

    public static Info diameter2(TreeNode root) {
        if (root == null) {
            return new Info(0, 0);
        }
        Info leftInfo = diameter2(root.left);
        Info rightInfo = diameter2(root.right);
        int height = Math.max(leftInfo.h, rightInfo.h) + 1;
        int diameter = Math.max(Math.max(leftInfo.d, rightInfo.d), leftInfo.h + rightInfo.h + 1);
        return new Info(height, diameter);
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
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int d[] = new int[1];
        height(root, d);
        return d[0];
    }

    public static int height(TreeNode root, int d[]) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left, d);
        int rh = height(root.right, d);
        d[0] = Math.max(d[0], lh + rh);
        return Math.max(lh, rh) + 1;
    }
}