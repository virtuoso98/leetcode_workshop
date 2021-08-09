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
        if (p == null && q == null) return true;
        
        if (p == null || q == null) return false;
        
        if (q.val == p.val) return true;
        
        return false;
    }
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        
        while (!(queue.isEmpty())) {
            System.out.println(queue);
            
            TreeNode nodeP = queue.poll();
            TreeNode nodeQ = queue.poll();
            
            if (!(checkSame(nodeP, nodeQ))) return false;
            
            if (nodeP != null) {
                queue.offer(nodeP.right);
                queue.offer(nodeQ.right);
                queue.offer(nodeP.left);
                queue.offer(nodeQ.left);
            }
        }
        return true;
    }
}