/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

class Solution {
    /**
     * Disclaimer: This isn't the best method because I'm recreating
     * an array after every call. There is a slightly better method
     * using backtracking, but I'll not go through that here since
     * I did not teach it.
     */
    public void pathSumAux(TreeNode node, int target, List<Integer> path, List<List<Integer>> res) {
        /* Null node can't produce desired path sum */
        if (node == null)
            return;

        path.add(node.val);

        /* Reached a leaf and hit target sum */
        if (target == node.val && node.left == null && node.right == null) {
            res.add(path);
            return;
        }

        /* traverse to child nodes and subtract from remainder */
        this.pathSumAux(node.left, target - node.val, new ArrayList<>(path), res);
        this.pathSumAux(node.right, target - node.val, new ArrayList<>(path), res);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        /* Pass accumulator by reference */
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        this.pathSumAux(root, targetSum, path, res);
        return res;
    }
}