/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1);
        int excess = 0;
        ListNode ptrAns = ans;

        while (l1 != null || l2 != null || excess != 0) {
            int l1val = l1 == null ? 0 : l1.val;
            int l2val = l2 == null ? 0 : l2.val;

            int total = l1val + l2val + excess;
            excess = total / 10;
            ptrAns.next = new ListNode(total % 10);

            ptrAns = ptrAns.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        return ans.next;
    }
}