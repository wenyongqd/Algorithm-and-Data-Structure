/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode p = head;
        // ListNode  res = new ListNode(0);
        int res;
        while (p != null && p.next != null) {
            res = p.next.val;
            p.next.val = p.val;
            p.val = res;
            p = p.next.next;
        }
        if ( head ==null || head.next == null) {
            return head;
        }
        return head;
    }
}