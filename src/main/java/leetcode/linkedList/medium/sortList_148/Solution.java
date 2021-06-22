package leetcode.linkedList.medium.sortList_148;

import leetcode.linkedList.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public ListNode sortList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        list.sort((o1, o2) -> {
            return o1.val - o2.val;
        });
        for (int i = 0; i < list.size(); i++) {
            if (i < list.size() - 1) {
                list.get(i).next = list.get(i + 1);
            } else {
                list.get(i).next = null;
            }
        }
        return list.get(0);
    }

    public ListNode sortList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slowNode = head;
        ListNode fastNode = head.next;
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        ListNode tmpList = slowNode.next;
        slowNode.next = null;
        ListNode left = sortList1(head);
        ListNode right = sortList1(tmpList);
        ListNode newHead = new ListNode(-1);
        ListNode doHead = newHead;
        while (left != null && right != null) {
            if (left.val < right.val) {
                doHead.next = left;
                left = left.next;
            } else {
                doHead.next = right;
                right = right.next;
            }
            doHead = doHead.next;
        }
        doHead.next = left != null ? left : right;
        return newHead.next;
    }
}
