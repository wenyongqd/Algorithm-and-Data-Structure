/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode nummyNode = new ListNode(-1);
        ListNode cur = nummyNode;

        while (l1 != null && l2 != null) {

            cur.next = (l1.val <= l2.val) ? new ListNode(l1.val) : new ListNode(l2.val);
            cur = cur.next;
            if ( l1.val <= l2.val) {
                l1 = l1.next;
            } else {
                l2 = l2.next;
            }
        }
        cur.next = (l1 != null) ? l1 : l2;
        return nummyNode.next;

    }
}