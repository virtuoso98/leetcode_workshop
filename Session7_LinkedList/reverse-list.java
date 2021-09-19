/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        /**
         * If you do not understand this solution, please 
         * please use a piece of paper and marker to make
         * life easier for you!
         */

        /* Pointer to output Reversed Linked List */
        ListNode prev = null;
        /* Pointer to current Linked List */
        ListNode curr = head;

        while (curr != null) {
            /* Store temporary reference to next node */
            ListNode cacheNext = curr.next;
            /* Reversal of reference order occurs here */
            curr.next = prev;
            prev = curr;
            /* give curr back the reference to next node */
            curr = cacheNext;
        }

        return prev;
    }
}