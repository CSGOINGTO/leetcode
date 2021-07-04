package leetcode.linkedList.easy.palindromeLinkedList_234;

import leetcode.linkedList.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        Solution s = new Solution();
        System.out.println(s.isPalindrome(l1));
    }

    // todo：错误解法
    public boolean isPalindrome(ListNode head) {
        Deque<ListNode> queue = new LinkedList<>();
        while (head != null) {
            if (!queue.isEmpty() && head.val != queue.peek().val) {
                queue.push(head);
            } else {
                queue.pop();
            }
            head = head.next;
        }
        return queue.size() == 0;
    }
}
