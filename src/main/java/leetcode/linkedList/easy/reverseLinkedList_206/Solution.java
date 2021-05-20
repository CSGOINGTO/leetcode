package leetcode.linkedList.easy.reverseLinkedList_206;

import leetcode.linkedList.ListNode;

public class Solution {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = null;
        Solution solution = new Solution();
        System.out.println(solution.reverseList2(l1));
    }

    public ListNode reverseList(ListNode head) {
        ListNode res = null;
        while (head != null) {
            ListNode temp = head;
            // 备份原链表信息
            head = head.next;
            temp.next = res;
            res = temp;
        }
        return res;
    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     */
    public ListNode reverseList1(ListNode head) {
        // 1 -> 2 -> 3 -> 4
        ListNode newHead = null;
        while (head != null) {
            // 2
            ListNode tmpNode = head.next;
            head.next = newHead;
            newHead = head;
            // head 置为 2
            head = tmpNode;
        }
        return newHead;
    }

    /**
     * 递归
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        // 4-> 5->4-> 5 newHead = 5->4->^, head = 4
        // 3-> 4->3-> 4 newHead = 5->4->3->^, head = 3
        // 2-> 3->2-> 3 newHead = 5->4->3->2->^, head = 2
        // 1-> 2->1-> 2 newHead = 5->4->3->2->1->^, head = 1
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
