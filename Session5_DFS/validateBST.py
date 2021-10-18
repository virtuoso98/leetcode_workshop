# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def validateHelper(self, node: TreeNode, lowBound, highBound) -> bool:
        # Empty node does not influence whether BST is Valid
        if not node:
            return True
        
        # If Bounds are defined and node value lies outside these
        # bounds, then return false
        if (lowBound != None and node.val <= lowBound or 
            highBound != None and node.val >= highBound):
            return False
        
        """
        In a sense, lowBound and highBound are accumulators storing the 
        highest and lowest value seen so far during the traversal.
        """
        # Lower bound remains. However, left child node should be LOWER than parent value
        validateLeft = self.validateHelper(node.left, lowBound, node.val)
        # Upper bound remains. However, right child node should be HIGHER than parent value
        validateRight = self.validateHelper(node.right, node.val, highBound)
        
        # To be a valid BST, all nodes must be valid.
        return validateLeft and validateRight
    
    def isValidBST(self, root: TreeNode) -> bool:
        # Could also put -infinity and infintiy here to start the recursion
        # Root node is always a valid BST (No bounds to compare to)
        return self.validateHelper(root, None, None)