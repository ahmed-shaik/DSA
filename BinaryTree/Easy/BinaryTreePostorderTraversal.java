package BinaryTree.Easy;

import java.util.ArrayList;
import java.util.List;

import BinaryTree.Easy.BinaryTreePreOrderTraversal.TreeNode;

public class BinaryTreePostorderTraversal {
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
        public List<Integer> postorderTraversal(TreeNode root) {
            ArrayList<Integer> list = new ArrayList<>();
            helper(list, root);
            return list;
        }

        public void helper(ArrayList<Integer> list, TreeNode root) {
            if (root == null) {
                return;
            }
            helper(list, root.left);
            helper(list, root.right);
            list.add(root.val);
        }
    }
}
