package leetcode.linkedList.easy.palindromeLinkedList_234;

import leetcode.linkedList.ListNode;

public class Solution {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        Solution s = new Solution();
        System.out.println(s.isPalindrome(l1));
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slowNode = head;
        ListNode fastNode = head;
        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        if (fastNode != null) slowNode = slowNode.next;
        ListNode secondHead = reverse(slowNode);
        while (secondHead != null) {
            if (secondHead.val != head.val) return false;
            secondHead = secondHead.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode tmpNode = head.next;
            head.next = newHead;
            newHead = head;
            head = tmpNode;
        }
        return newHead;
    }
}
