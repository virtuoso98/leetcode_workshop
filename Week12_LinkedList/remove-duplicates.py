# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        if not head:
            return None
        
        fast = head.next
        slow = head
        
        while fast:
            if fast.val == slow.val:
                slow.next = fast.next
                fast = fast.next
            else:
                fast = fast.next
                slow = slow.next
                
        return head