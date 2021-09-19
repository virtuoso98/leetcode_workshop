# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def pathSumLocal(self, currSum, currPath, node, acc, targetSum):
        """
        Disclaimer: This isn't the best method because I'm recreating
        an array after every call. There is a slightly better method
        using backtracking, but I'll not go through that here since
        I did not teach it.
        """
        # Null node can't produce desired path sum
        if not node:
            return

        # Reached a leaf and hit target sum
        if (not node.left and not node.right
            and currSum + node.val == targetSum):
            acc.append(currPath + [node.val])

        # if node.left has a payload, traverse there and subtract from remainder
        if node.left:
            self.pathSumLocal(currSum + node.val, currPath + [node.val], node.left, acc, targetSum)

        # if node.right has a payload, traverse there and subtract from remainder
        if node.right:
            self.pathSumLocal(currSum + node.val, currPath + [node.val], node.right, acc, targetSum)
    
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        # Pass accumulator by reference
        acc = []
                
        self.pathSumLocal(0, [], root, acc, targetSum)
        return acc