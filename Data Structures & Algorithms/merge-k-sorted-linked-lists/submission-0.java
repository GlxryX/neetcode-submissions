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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        boolean finish = false;
        while (!finish) {
            int min = Integer.MAX_VALUE;
            int index = 0;

            int empty = 0;

            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    empty++;
                    continue;
                }
                int currVal = lists[i].val;
                if (currVal < min) {
                    min = currVal;
                    index = i;
                }
            }

            if (empty == lists.length) {
                finish = true;
                continue;
            }

            curr.next = lists[index];
            lists[index] = lists[index].next;
            curr.next.next = null;
            curr = curr.next;
        }

        return head.next;
    }
}
