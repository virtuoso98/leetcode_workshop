# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        q = [root]
        right = []
        while q:
            width = len(q)
            for i in range(width):
                node = q.pop(0)
                if i == 0:
                    right.append(node.val)
                if node.right:
                    q.append(node.right)
                if node.left:
                    q.append(node.left)
        
        return right