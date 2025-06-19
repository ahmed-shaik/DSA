package BinaryTree.Medium;

import java.util.*;

import BinaryTree.Medium.BinaryTreeLevelOrderTraversal.TreeNode;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            Map<Integer, Integer> inMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                inMap.put(inorder[i], i);
            }
            return buildTreeHelper(preorder, 0, preorder.length - 1, 0, inorder.length - 1, inMap);
        }

        public TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd,
                int inStart, int inEnd, Map<Integer, Integer> inMap) {
            if (preStart > preEnd || inStart > inEnd) {
                return null;
            }
            int rootVal = preorder[preStart];
            TreeNode root = new TreeNode(rootVal);
            int rootIndex = inMap.get(rootVal);
            int leftSize = rootIndex - inStart;
            root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftSize, inStart, rootIndex - 1, inMap);
            root.right = buildTreeHelper(preorder, preStart + leftSize + 1, preEnd, rootIndex + 1, inEnd, inMap);
            return root;
        }
    }

}