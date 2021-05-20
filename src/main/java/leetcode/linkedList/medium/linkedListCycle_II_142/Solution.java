package leetcode.linkedList.medium.linkedListCycle_II_142;

import leetcode.linkedList.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(-4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;
        solution.detectCycle1(l1);
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        Set<ListNode> nodeSet = new HashSet<>();
        while (head != null) {
            if (nodeSet.contains(head)) {
                return head;
            }
            nodeSet.add(head);
            head = head.next;
        }
        return null;
    }

    public ListNode detectCycle1(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fastNode = head;
        ListNode slowNode = head;
        while (true) {
            if (fastNode == null || fastNode.next == null) return null;
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            if (fastNode == slowNode) break;
        }
        fastNode = head;
        while (fastNode != slowNode) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
        return fastNode;
    }
}
