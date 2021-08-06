/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

class Solution {
    public void pathSumAux(TreeNode node, int target, List<Integer> path, List<List<Integer>> res) {
        if (node == null)
            return;

        path.add(node.val);

        if (target == node.val && node.left == null && node.right == null) {
            res.add(path);
            return;
        }

        this.pathSumAux(node.left, target - node.val, new ArrayList<>(path), res);
        this.pathSumAux(node.right, target - node.val, new ArrayList<>(path), res);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        this.pathSumAux(root, targetSum, path, res);
        return res;
    }
}