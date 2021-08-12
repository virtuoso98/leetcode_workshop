# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        """
        If you do not understand this solution, please
        please use a piece of paper and marker to make
        life easier for you!
        """
        # Pointer to output Linked List
        prev = None
        # Pointer to current Linked List
        curr = head
        
        while curr:
            cacheNext = curr.next
            curr.next = prev
            prev = curr
            curr = cacheNext
            
        return prev