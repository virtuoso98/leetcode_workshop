/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean checkSame(TreeNode p, TreeNode q) {
        /* If they are both null then they're equal */
        if (p == null && q == null) return true;
        
        /* If one is defined and one is null, they're not equal */
        if (p == null || q == null) return false;
        
        /* Both nodes are defined and equal */
        if (q.val == p.val) return true;
        
        /* Both defined and not equal */
        return false;
    }
    
    public boolean isSymmetric(TreeNode root) {
        /* Initiate queue */
        Queue<TreeNode> queue = new LinkedList<>();
        /* Enqueue left node, then right node. No need to check root */
        queue.offer(root.right);
        queue.offer(root.left);
        
        while (!(queue.isEmpty())) {
            System.out.println(queue);
            
            /* Dequeue from node then its mirrored node */
            TreeNode nodeP = queue.poll();
            TreeNode nodeQ = queue.poll();
            
             /* If any mirror nodes are not the same, tree not symmetrical */
            if (!(checkSame(nodeP, nodeQ))) return false;
            
            /* Take note to enqueue nodes in mirror order! */
            if (nodeP != null) {
                queue.offer(nodeP.left);
                queue.offer(nodeQ.right);
                queue.offer(nodeP.right);
                queue.offer(nodeQ.left);
            }
        }

        /* If this part reached, all mirror nodes checked to be the same. */
        return true;
    }
}