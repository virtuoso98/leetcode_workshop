/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

class Solution {
    public boolean validateHelper(TreeNode node, Integer min, Integer max) {
        /* Tried using Integer.MAX_VALUE to no avail */
        if (node == null)
            return true;

        if ((min != null && node.val <= min) || (max != null && node.val >= max))
            return false;

        return (validateHelper(node.left, min, node.val) && validateHelper(node.right, node.val, max));
    }

    public boolean isValidBST(TreeNode root) {
        return validateHelper(root, null, null);
    }
}