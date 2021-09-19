# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isSameTree(self, p: TreeNode, q: TreeNode) -> bool:
        # If both nodes are null, then tree structure is identical
        if not p and not q:
            return True
        # If 1 of 2 nodes is null (other has value), tree structure differs
        if not p or not q:
            return False
        
        # If value of nodes are different, then they aren't the same
        if p.val != q.val:
            return False
        
        # Recurse to left and right and check. && Used since all nodes must be equal.
        return (self.isSameTree(p.left, q.left) and
            self.isSameTree(p.right, q.right))