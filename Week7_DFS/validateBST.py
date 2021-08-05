# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def validateHelper(self, node: TreeNode, lowBound, highBound) -> bool:
        if not node:
            return True
        
        if (lowBound != None and node.val <= lowBound or 
            highBound != None and node.val >= highBound):
            return False
        
        validateLeft = self.validateHelper(node.left, lowBound, node.val)
        validateRight = self.validateHelper(node.right, node.val, highBound)
        
        return validateLeft and validateRight
    
    def isValidBST(self, root: TreeNode) -> bool:
        return self.validateHelper(root, None, None)