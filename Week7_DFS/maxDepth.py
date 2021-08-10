# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        # Base case: Null root has 0 depth
        if not root:
            return 0
        else:
            leftDepth = self.maxDepth(root.left)
            rightDepth = self.maxDepth(root.right)
            # Root with value has depth of 1
            # Return maximum of the 2 subdepths
            return 1 + max(leftDepth, rightDepth)