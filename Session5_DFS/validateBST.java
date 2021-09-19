/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

class Solution {
    /**
     * validateHelper is a recursive function that traverses the
     * tree DFS-style and records the Lower Bound and Upper Bound 
     * of whatever the node shoulld be.
     */
    public boolean validateHelper(TreeNode node, Integer min, Integer max) {
        /**
         * Tried using Integer.MAX_VALUE to no avail. Some Int type
         * problem, so I chose to use null instead. Anyhow, empty node
         * does not influence whether BST is valid or not
         */  
        if (node == null)
            return true;

        /**
         * If bounds are defined and node value lies outside these 
         * bounds, then return false
         */
        if ((min != null && node.val <= min) || (max != null && node.val >= max))
            return false;

        /* To be a valid BST, all nodes must be valid. */
        return (validateHelper(node.left, min, node.val) && validateHelper(node.right, node.val, max));
    }

    public boolean isValidBST(TreeNode root) {
        /* Initialize recursion with null bounds (root always valid) */
        return validateHelper(root, null, null);
    }
}