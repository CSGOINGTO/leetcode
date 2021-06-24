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
        System.out.println(solution.deleteDuplicates(l1));
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
}
