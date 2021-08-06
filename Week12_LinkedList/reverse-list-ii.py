# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverseBetween(self, head: ListNode, left: int, right: int) -> ListNode:
        
        # Nothing to reverse
        if left == right:
            return head
        
        node = temp = ListNode(0)
        node.next = head
        
        i = 1
        while i < left:
            temp = temp.next
            i += 1        
        
        current = temp.next
        while left < right:
            t = current.next
            current.next = t.next
            t.next = temp.next
            temp.next = t
            left += 1
        
        return node.next