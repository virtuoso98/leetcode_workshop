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
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        /* Initiate queue */
        Queue<TreeNode> queue = new LinkedList<>();
        /* Enqueue left node, then right node. No need to check root */
        queue.offer(p);
        queue.offer(q);
        
        while (!(queue.isEmpty())) {
            System.out.println(queue);
            
            /* Dequeue left child node, then right child node */
            TreeNode nodeP = queue.poll();
            TreeNode nodeQ = queue.poll();
            
            /* If any nodes are not the same, tree not equal */
            if (!(checkSame(nodeP, nodeQ))) return false;
            
            /**
             * If node is defined, then left and right child
             * won't return an error
             */
            if (nodeP != null) {
                queue.offer(nodeP.right);
                queue.offer(nodeQ.right);
                queue.offer(nodeP.left);
                queue.offer(nodeQ.left);
            }
        }

        /* If this part reached, all nodes checked to be the same. */
        return true;
    }
}