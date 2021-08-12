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
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode cacheNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = cacheNext;
        }

        return prev;
    }
}