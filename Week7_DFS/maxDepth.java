/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

class Solution {
    public int maxDepth(TreeNode root) {
        /* Base case: Null root has 0 depth */
        if (root == null)
            return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        /**
         * Root with value has depth of 1
         * Return maximum of 2 subdepths
         */
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
