package BinaryTree.Medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            ;
            if (root == null)
                return result;
            Queue<TreeNode> queue = new ArrayDeque<>();

            queue.add(root);
            while (!queue.isEmpty()) {
                List<Integer> levelList = new ArrayList<Integer>();
                int n = queue.size();
                for (int i = 0; i < n; i += 1) {
                    TreeNode temp = queue.poll();
                    levelList.add(temp.val);
                    if (temp.left != null)
                        queue.add(temp.left);
                    if (temp.right != null)
                        queue.add(temp.right);
                }
                result.add(levelList);
            }
            return result;
        }
    }
}
