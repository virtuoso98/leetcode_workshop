/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        /* If list null, no duplicates everyday */
        if (head == null) {
            return head;
        }

        /* Fast pointer to traverse for duplicates */
        ListNode fast = head.next;
        /* Slow pointer to remove references to duplicates */
        ListNode slow = head;

        while (fast != null) {
            if (fast.val == slow.val) {
                /* Make sure slow.next != fast to remove duplicates */
                slow.next = fast.next;
                fast = fast.next;
            } else {
                /* No duplicates, slow doesn't need to change */
                fast = fast.next;
                slow = slow.next;
            }
        }

        /* Return re-wired head node */
        return head;
    }
}