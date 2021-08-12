# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        # If List null, there are already no duplicates
        if not head:
            return None
        
        # Fast pointer to traverse for duplicates
        fast = head.next
        # Slow pointer to remove references to duplicates
        slow = head
        

        while fast:
            # Make sure slow.next != fast to remove duplicate
            if fast.val == slow.val:
                slow.next = fast.next
                fast = fast.next
            else:
                # No duplicates, slow doesn't need to change
                fast = fast.next
                slow = slow.next
                
        return head