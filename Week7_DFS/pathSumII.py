# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def pathSumLocal(self, currSum, currPath, node, acc, targetSum):
        if not node:
            return

        if (not node.left and not node.right
            and currSum + node.val == targetSum):
            acc.append(currPath + [node.val])

        if node.left:
            self.pathSumLocal(currSum + node.val, currPath + [node.val], node.left, acc, targetSum)

        if node.right:
            self.pathSumLocal(currSum + node.val, currPath + [node.val], node.right, acc, targetSum)
    
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        acc = []
                
        self.pathSumLocal(0, [], root, acc, targetSum)
        return acc