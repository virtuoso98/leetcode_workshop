# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Please use this library if you'd like to implement queues.
# It's more efficient than using arrays! 
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
    
    def isSameTree(self, p: TreeNode, q: TreeNode) -> bool:
        # Inititate queue
        queue = deque()
        # enqueue left node, then right node
        queue.append(p)
        queue.append(q)
        while len(queue) != 0:
            # dequeue left node, then right node
            nodeP = queue.popleft()
            nodeQ = queue.popleft()
            
            # If nodes are not the same, tree not equal
            if not self.checkSame(nodeP, nodeQ):
                return False
            
            # If node is defined, then left and right
            # child won't return an error
            if nodeP:
                queue.append(nodeP.right)
                queue.append(nodeQ.right)
                queue.append(nodeP.left)
                queue.append(nodeQ.left)

        # If this part reached, All nodes checked to be same.  
        return True