package BinaryTree.Easy;

import java.util.ArrayList;
import java.util.List;

public class PreOrder {
    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {

            List<Integer> li = new ArrayList<>();

            preOrder(root, li);

            return li;
        }

        public static void preOrder(TreeNode node, List<Integer> li) {

            if (node == null)
                return;

            li.add(node.val);
            preOrder(node.left, li);
            preOrder(node.right, li);
        }

    }
}
