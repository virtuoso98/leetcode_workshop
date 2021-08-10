/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        /* If both nodes are null, then tree structure is identical */
        if (p == null && q == null) {
            return true;
        }

        /* If 1 of 2 nodes is null (other has value), tree structure differs */
        if (p == null || q == null) {
            return false;
        }

        /* If value of nodes are different, then they aren't the same */
        if (p.val != q.val) {
            return false;
        }

        /* Recurse to left and right and check. && Used since all nodes must be equal. */
        return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }
}