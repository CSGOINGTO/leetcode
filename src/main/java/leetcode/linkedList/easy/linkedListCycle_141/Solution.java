package leetcode.linkedList.easy.linkedListCycle_141;

import leetcode.linkedList.ListNode;

public class Solution {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;
        Solution solution = new Solution();
        System.out.println(solution.hasCycle(l1));
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode listNode = head.next.next;
        while (listNode != null && listNode.next != null) {
            if (listNode == head) return true;
            listNode = listNode.next.next;
            head = head.next;
        }
        return false;
    }
}
