package BinaryTree.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    class Solution1 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (root == null) {
                return list;
            }
            Stack<TreeNode> s = new Stack<>();
            TreeNode node = root;
            while (true) {
                if (node != null) {
                    s.push(node);
                    node = node.left;
                } else {
                    if (s.isEmpty()) {
                        break;
                    }
                    node = s.pop();
                    list.add(node.val);
                    node = node.right;
                }
            }
            return list;
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
    class Solution2 {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (root == null) {
                return list;
            }
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();
            s1.push(root);
            while (!s1.isEmpty()) {
                root = s1.pop();
                s2.push(root);
                if (root.left != null) {
                    s1.push(root.left);
                }
                if (root.right != null) {
                    s1.push(root.right);
                }
            }
            while (!s2.isEmpty()) {
                list.add(s2.pop().val);
            }
            return list;
        }
    }
}
