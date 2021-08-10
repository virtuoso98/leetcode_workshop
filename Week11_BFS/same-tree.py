# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def checkSame(self, p: TreeNode, q: TreeNode) -> bool:
        """
        Auxxilary Function to check if 2 nodes are the same.
        """

        # If 
        if not p and not q:
            return True
        
        if not q or not p:
            return False
        
        if q.val == p.val:
            return True
        
        return False
    
    def isSameTree(self, p: TreeNode, q: TreeNode) -> bool:
        queue = []
        queue.append(p)
        queue.append(q)
        while len(queue) != 0:
            # Not a great way to write. use deque from collections instead.
            nodeP = queue.pop(0)
            nodeQ = queue.pop(0)
            
            if not self.checkSame(nodeP, nodeQ):
                return False
            
            if nodeP:
                queue.append(nodeP.right)
                queue.append(nodeQ.right)
                queue.append(nodeP.left)
                queue.append(nodeQ.left)
            
        return True