# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque

class Solution:
    def checkSame(self, p: TreeNode, q: TreeNode) -> bool:
        """
        Auxilary Function to check if 2 nodes are the same.
        """

        # If they are both null, then they're equal
        if not p and not q:
            return True
        
        # If one is defined and one is null, they're not equal
        if not q or not p:
            return False
        
        # Both nodes are defined and equal
        if q.val == p.val:
            return True
        
        # Both defined and not equal
        return False
    
    def isSymmetric(self, root: TreeNode) -> bool:
        # Inititate queue
        queue = deque()
        # Enqueue left node, then right node. No need to check root
        queue.append(root.left)
        queue.append(root.right)
        
        while len(queue) != 0:
             # Dequeue from node then its mirrored node 
            nodeP = queue.popleft()
            nodeQ = queue.popleft()
            
            # If any mirror nodes are not the same, tree not symmetrical
            if not self.checkSame(nodeP, nodeQ):
                return False
            
            # Take note to enqueue nodes in mirror order!
            if nodeP:
                queue.append(nodeP.right)
                queue.append(nodeQ.left)
                queue.append(nodeP.left)
                queue.append(nodeQ.right)
        
        # If this part reached, all mirror nodes checked to be the same
        return True