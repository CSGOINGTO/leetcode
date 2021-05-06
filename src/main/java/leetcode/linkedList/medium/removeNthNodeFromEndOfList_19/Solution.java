package leetcode.linkedList.medium.removeNthNodeFromEndOfList_19;

import leetcode.linkedList.ListNode;

public class Solution {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = null;
        l3.next = l4;
        l4.next = l5;
        Solution solution = new Solution();
        System.out.println(solution.removeNthFromEnd(l1, 2));
    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        // firstNode的前驱结点
        ListNode doHead = newHead;
        // 慢节点
        ListNode firstNode = head;
        // 快节点
        ListNode secondNode = firstNode;
        // 1->2->3->4->5->6->7->8  n = 2
        for (int i = 1; i <= n; i++) {
            secondNode = secondNode.next;
        }
        // 1->2->3 ... 7->8->null
        // doHead = 6 firstNode = 7 secondNode = null
        while (secondNode != null) {
            doHead = doHead.next;
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }
        // 删除firstNode
        doHead.next = firstNode.next;
        return newHead.next;
    }
}
