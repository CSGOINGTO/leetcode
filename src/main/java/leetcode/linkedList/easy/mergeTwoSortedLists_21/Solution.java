package leetcode.linkedList.easy.mergeTwoSortedLists_21;

import leetcode.linkedList.ListNode;

public class Solution {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(5);
        l4.next = l5;
        l5.next = l6;

        Solution solution = new Solution();
        System.out.println(solution.mergeTwoLists(l1, l4));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(-1);
        ListNode doHead = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                doHead.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                doHead.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            doHead = doHead.next;
        }
        if (l1 != null) {
            doHead.next = l1;
        }
        if (l2 != null) {
            doHead.next = l2;
        }
        return newHead.next;
    }
}
