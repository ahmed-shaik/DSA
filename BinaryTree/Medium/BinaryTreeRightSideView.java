package BinaryTree.Medium;

import java.util.ArrayList;
import java.util.List;

import BinaryTree.Medium.BinaryTreeLevelOrderTraversal.TreeNode;

public class BinaryTreeRightSideView {
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            recursionRight(root, 0, res);
            return res;
        }

        private void recursionRight(TreeNode root, int level, List<Integer> res) {
            if (root == null) {
                return;
            }
            if (res.size() == level) {
                res.add(root.val);
            }
            recursionRight(root.right, level + 1, res);
            recursionRight(root.left, level + 1, res);
        }
    }

}
