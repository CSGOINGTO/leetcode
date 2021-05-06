package leetcode.linkedList.medium.addTwoNumbers_2;

import leetcode.linkedList.ListNode;

public class Solution {

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carried = 0;
        ListNode newHead = new ListNode(0);
        newHead.next = l1;
        ListNode doHead = newHead;
        int tmpValue = 0;
        while (l1 != null || l2 != null) {
            tmpValue = l1.val + l2.val + carried;
            carried = tmpValue / 10;
            l1.val = tmpValue % 10;
            l1 = l1.next;
            l2 = l2.next;
            doHead = doHead.next;
        }
        while (l1 != null) {
            tmpValue = l1.val + carried;
            carried = tmpValue / 10;
            l1.val = tmpValue % 10;
            l1 = l1.next;
            doHead = doHead.next;
        }
        while (l2 != null) {
            tmpValue = l2.val + carried;
            carried = tmpValue / 10;
            doHead.next = l2;
            l2.val = tmpValue % 10;
            l2 = l2.next;
            doHead = doHead.next;
        }
        if (carried == 1) {
            doHead.next = new ListNode(1);
        }
        return newHead.next;
    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        int carried = 0;
        int tmpValue = 0;
        ListNode newHead = new ListNode(0);
        ListNode doHead = newHead;
        while (l1 != null | l2 != null) {
            // 判断l1/l2是否为null，如果为null则对应的值为0
            tmpValue = l1 == null ? 0 : l1.val;
            tmpValue += (l2 == null ? 0 : l2.val) + carried;
            // 每次都生成一个新的节点
            doHead.next = new ListNode(tmpValue % 10);
            // 重置进位标识
            carried = tmpValue / 10;
            doHead = doHead.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        // 如果遍历结束之后，进位标识还为1的话，则生成一个新的值为1的节点
        if (carried == 1) {
            doHead.next = new ListNode(1);
        }
        return newHead.next;
    }
}
