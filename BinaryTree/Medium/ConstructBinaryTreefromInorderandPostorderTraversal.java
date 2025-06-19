package BinaryTree.Medium;

import java.util.HashMap;

import BinaryTree.Medium.BinaryTreeLevelOrderTraversal.TreeNode;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
    class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            HashMap<Integer, Integer> inorderIndexMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                inorderIndexMap.put(inorder[i], i);
            }
            return buildTreeFromPostIn(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1,
                    inorderIndexMap);
        }

        private TreeNode buildTreeFromPostIn(int[] inorder, int inorderStart, int inorderEnd,
                int[] postorder, int postorderStart, int postorderEnd,
                HashMap<Integer, Integer> inorderIndexMap) {
            if (postorderStart > postorderEnd || inorderStart > inorderEnd) {
                return null;
            }

            int rootVal = postorder[postorderEnd];
            TreeNode root = new TreeNode(rootVal);

            int rootInInorder = inorderIndexMap.get(rootVal);
            int leftSubtreeSize = rootInInorder - inorderStart;

            root.left = buildTreeFromPostIn(inorder, inorderStart, rootInInorder - 1,
                    postorder, postorderStart, postorderStart + leftSubtreeSize - 1,
                    inorderIndexMap);
            root.right = buildTreeFromPostIn(inorder, rootInInorder + 1, inorderEnd,
                    postorder, postorderStart + leftSubtreeSize, postorderEnd - 1,
                    inorderIndexMap);

            return root;
        }
    }

}
