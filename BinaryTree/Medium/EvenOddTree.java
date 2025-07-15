package BinaryTree.Medium;

import java.util.ArrayList;
import java.util.Queue;

public class EvenOddTree {
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
        public boolean isEvenOddTree(TreeNode root) {
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            int l = 0;
            while (!q.isEmpty()) {
                int n = q.size();
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    TreeNode curr = q.poll();
                    list.add(curr.val);
                    if (curr.left != null) {
                        q.offer(curr.left);
                    }
                    if (curr.right != null) {
                        q.offer(curr.right);
                    }
                }
                if (!check(list, l)) {
                    return false;
                }
                l++;
            }
            return true;
        }

        public static boolean check(ArrayList<Integer> list, int l) {
            if (l % 2 == 0) {
                if (list.get(0) % 2 == 0) {
                    return false;
                }
                for (int i = 1; i < list.size(); i++) {
                    if (list.get(i) % 2 == 0 || list.get(i) <= list.get(i - 1)) {
                        return false;
                    }
                }
            } else {
                if (list.get(0) % 2 != 0) {
                    return false;
                }
                for (int i = 1; i < list.size(); i++) {
                    if (list.get(i) % 2 != 0 || list.get(i) >= list.get(i - 1)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
