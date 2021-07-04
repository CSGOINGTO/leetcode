package leetcode.linkedList.medium.removeDuplicatesFromSortedList_II_82;

import leetcode.linkedList.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        System.out.println(solution.deleteDuplicates1(l1));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        List<ListNode> list = new ArrayList<>();
        ListNode slowNode = head;
        ListNode fastNode = head.next;
        boolean isRepeat = false;
        while (slowNode != null) {
            while (fastNode != null && fastNode.val == slowNode.val) {
                fastNode = fastNode.next;
                isRepeat = true;
            }
            if (!isRepeat) list.add(slowNode);
            slowNode.next = fastNode;
            slowNode = slowNode.next;
            if (fastNode != null) fastNode = fastNode.next;
            isRepeat = false;
        }
        if (list.isEmpty()) return null;
        ListNode newHead = new ListNode(-1);
        ListNode doHead = newHead;
        for (ListNode node : list) {
            doHead.next = node;
            doHead = doHead.next;
        }
        doHead.next = null;
        return newHead.next;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = new ListNode(-1);
        ListNode doHead = newHead;
        while (head != null) {
            while (head != null && head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            if (head == null) {
                doHead.next = head;
                break;
            }
            if ((head != null && head.next != null && head.val != head.next.val) || (head != null && head.next == null)) {
                doHead.next = head;
                doHead = doHead.next;
            }
            head = head.next;
        }
        doHead.next = null;
        return newHead.next;
    }

    public ListNode deleteDuplicates3(ListNode head) {
        ListNode newHead = new ListNode(-1);
        ListNode doHead = newHead;
        while (head != null) {
            // 进入循环时，确保了 head 不会与上一节点相同
            if (head.next == null || head.val != head.next.val) {
                doHead.next = head;
                doHead = head;
            }
            // 如果 head 与下一节点相同，跳过相同节点
            while (head.next != null && head.val == head.next.val) head = head.next;
            head = head.next;
        }
        doHead.next = null;
        return newHead.next;
    }
}
