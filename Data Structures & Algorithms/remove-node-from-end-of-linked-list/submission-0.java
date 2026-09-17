/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode leading = head;
        ListNode trailing = new ListNode(0, head);
        int count = 0;

        while (leading.next != null) {
            leading = leading.next;
            count++;
            if (count >= n) {
                trailing = trailing.next;
            }
        }

        if (trailing.next == head) head = head.next;
        else trailing.next = trailing.next.next;

        return head;
    }
}
