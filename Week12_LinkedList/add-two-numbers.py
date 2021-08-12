# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        ans = ListNode(-1)
        # Whether adding 2 digits overflow into the nex
        excess = 0
        # pointer that appends new digits to ans
        ptrAns = ans
        
        """
        If one of these conditions hold, we still need
        to create new ListNodes
        """
        while l1 or l2 or excess != 0:
            # Ternary operators can be used to write this
            # digit vals are 0 if no more digits (values)
            l1val = 0
            l2val = 0
            if l1:
                l1val = l1.val
            if l2:
                l2val = l2.val
            
            # Sum of these 3 elements
            total = l1val + l2val + excess
            excess = total // 10
            # We're appending a node containing a number.
            # ptrAns.next = total % 10 (number, not node) is wrong!
            ptrAns.next = ListNode(total % 10)
            
            # Please remember to change pointer reference!
            ptrAns = ptrAns.next
            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None
        
        # since head was initially placeholder -1
        return ans.next