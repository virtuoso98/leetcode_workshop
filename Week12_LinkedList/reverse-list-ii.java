/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right)
            return head;

        ListNode node = new ListNode(0);
        ListNode temp = node;
        node.next = head;

        int i = 1;
        while (i < left) {
            temp = temp.next;
            i++;
        }

        ListNode curr = temp.next;
        while (left < right) {
            ListNode t = curr.next;
            curr.next = t.next;
            t.next = temp.next;
            temp.next = t;
            left++;
        }

        return node.next;
    }
}