/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1);
        /* Whether adding 2 digits overflow into the next */
        int excess = 0;
        /* pointer that appends new digits to ans */
        ListNode ptrAns = ans;

        /**
         * If one of these conditions hold, we still need
         * to create new ListNodes
         */ 
        while (l1 != null || l2 != null || excess != 0) {
            /* digit vals are 0 if no more digits (values) */
            int l1val = l1 == null ? 0 : l1.val;
            int l2val = l2 == null ? 0 : l2.val;

            /* Sum of these 3 elements */
            int total = l1val + l2val + excess;
            /* Overflow digit if applicable */
            excess = total / 10;
            /* We're appending a node containing a number! */
            // ptrAns.next = total % 10 (number, not node) is wrong!!!
            ptrAns.next = new ListNode(total % 10);

            /* Move references to the next phase */
            ptrAns = ptrAns.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        /* Since head was -1 */
        return ans.next;
    }
}