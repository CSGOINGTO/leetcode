package leetcode.linkedList.easy.linkedListCycle_141;

import leetcode.linkedList.ListNode;

import java.util.HashSet;
import java.util.Set;

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
        System.out.println(solution.hasCycle1(l1));
    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     */
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

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) return false;
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
