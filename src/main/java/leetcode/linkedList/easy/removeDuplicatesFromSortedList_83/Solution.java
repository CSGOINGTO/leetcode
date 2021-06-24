package leetcode.linkedList.easy.removeDuplicatesFromSortedList_83;

import leetcode.linkedList.ListNode;

public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = head;
        while (head != null) {
            while (head.next != null && head.val == head.next.val) {
                head.next = head.next.next;
            }
            head = head.next;
        }
        return res;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fastNode = head.next;
        ListNode slowNode = head;
        while (slowNode != null) {
            while (fastNode != null && fastNode.val == slowNode.val) {
                fastNode = fastNode.next;
            }
            slowNode.next = fastNode;
            slowNode = slowNode.next;
        }
        return head;
    }
}
