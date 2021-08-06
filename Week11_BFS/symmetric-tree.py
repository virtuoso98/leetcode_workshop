# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def checkSame(self, p: TreeNode, q: TreeNode) -> bool:
        if not p and not q:
            return True
        
        if not q or not p:
            return False
        
        if q.val == p.val:
            return True
        
        return False
    
    def isSymmetric(self, root: TreeNode) -> bool:
        queue = []
        queue.append(root.left)
        queue.append(root.right)
        
        while len(queue) != 0:
            nodeP = queue.pop(0)
            nodeQ = queue.pop(0)
            
            if not self.checkSame(nodeP, nodeQ):
                return False
            
            if nodeP:
                queue.append(nodeP.right)
                queue.append(nodeQ.left)
                queue.append(nodeP.left)
                queue.append(nodeQ.right)
            
        return True