/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    int carry = 0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyNode = new ListNode(0);
        ListNode p = l1, q = l2, prt = dummyNode;

        while(true) {
            if (p == null && q == null) break;
            if (p != null && q == null) {
                if(p.val +carry <= 9)  {
                    prt.next = new ListNode(p.val +carry);
                    carry = 0;
                } else {
                    prt.next = new ListNode(p.val +carry - 10);
                    carry = 1;
                }
            }
            if (q != null && p == null) {
                if(q.val +carry <= 9)  {
                    prt.next = new ListNode(q.val +carry);
                    carry = 0;
                } else {
                    prt.next = new ListNode(q.val +carry - 10);
                    carry = 1;
                }
            }

            if (q != null && p != null) {
                if(p.val + q.val +carry <= 9) {
                    prt.next = new ListNode(q.val + p.val +carry);
                    carry = 0;
                } else {
                    prt.next = new ListNode(q.val + p.val + carry -10);
                    carry = 1;
                }
            }
            if (carry == 1) {
                prt.next.next = new ListNode(carry);
            }
            if (p != null)p = p.next;
            if (q != null)q = q.next;
            prt = prt.next;
        }
        return dummyNode.next;
    }
//===================Solution 2================================
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummyNode = new ListNode(0);
        ListNode p = l1, q = l2, prt = dummyNode;

        while(p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + carry;
            carry = sum/10;
            prt.next = new ListNode(sum % 10);
            sum = 0;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
            prt = prt.next;
        }
        if (carry == 1) {
            prt.next = new ListNode(carry);
        }
        return dummyNode.next;
    }
}