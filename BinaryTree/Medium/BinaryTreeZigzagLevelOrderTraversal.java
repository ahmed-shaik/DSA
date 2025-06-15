package BinaryTree.Medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

import BinaryTree.Medium.BinaryTreeLevelOrderTraversal.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> zigzag = new ArrayList<>();
            if (root == null)
                return zigzag;
            Queue<TreeNode> q = new ArrayDeque<>();
            q.add(root);
            boolean leftToRight = true;
            while (!q.isEmpty()) {
                int n = q.size();
                List<Integer> levelList = new ArrayList<Integer>();
                for (int i = 0; i < n; i++) {
                    TreeNode node = q.remove();
                    levelList.add(node.val);
                    if (node.left != null)
                        q.add(node.left);
                    if (node.right != null)
                        q.add(node.right);
                }
                if (!leftToRight) {
                    Collections.reverse(levelList);
                }
                zigzag.add(levelList);
                leftToRight = !leftToRight;
            }
            return zigzag;
        }
    }
}
