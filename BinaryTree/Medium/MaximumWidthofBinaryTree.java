
package BinaryTree.Medium;

import java.util.*;

import BinaryTree.Medium.BinaryTreeLevelOrderTraversal.TreeNode;

public class MaximumWidthofBinaryTree {
    class Pair {
        TreeNode curr;
        int num;

        Pair(TreeNode curr, int num) {
            this.curr = curr;
            this.num = num;
        }
    }

    class Solution {
        public int widthOfBinaryTree(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int ans = 0;
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(root, 0));
            while (!q.isEmpty()) {
                int n = q.size();
                int first = 0, last = 0;
                for (int i = 0; i < n; i++) {
                    int id = q.peek().num;
                    TreeNode curr = q.remove().curr;
                    if (i == 0) {
                        first = id;
                    }
                    if (i == n - 1) {
                        last = id;
                    }
                    if (curr.left != null) {
                        q.add(new Pair(curr.left, 2 * id + 1));
                    }
                    if (curr.right != null) {
                        q.add(new Pair(curr.right, 2 * id + 2));
                    }
                }
                ans = Math.max(ans, last - first + 1);
            }
            return ans;
        }
    }

}
