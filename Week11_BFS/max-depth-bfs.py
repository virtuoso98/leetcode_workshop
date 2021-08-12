# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque

class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        # If root node undefined, just return 0
        if not root:
            return 0
        
        queue = deque()
        # root as the first element
        queue.append(root)
        depth = 0
        
        while len(queue) > 0:
            # Increase level by 1 when new level is traversed
            depth += 1
            # Find number of nodes in that level
            levelNodes = len(queue)
            # Dequeue nodes equivalent to number of nodes in level
            for _ in range(levelNodes):
                # dequeue node
                node = queue.popleft()
                # Append child nodes if defined
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
        return depth