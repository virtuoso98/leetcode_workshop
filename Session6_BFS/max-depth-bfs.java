/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

class Solution {
    public int maxDepth(TreeNode root) {
        /* If root node undefined, just return 0 */
        if (root == null)
            return 0;
        int maxDepth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        /* Root as the first element */
        queue.offer(root);

        while (!(queue.isEmpty())) {
            /* Increase level by 1 when new level traversed */
            maxDepth++;
            /* Find number of nodes in that level */
            int levelNodes = queue.size();
            /* Dequeue nodes equivalent to number of nodes in level */
            for (int i = 0; i < levelNodes; i++) {
                TreeNode node = queue.poll();
                /* Append child nodes if defined */
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return maxDepth;
    }
}