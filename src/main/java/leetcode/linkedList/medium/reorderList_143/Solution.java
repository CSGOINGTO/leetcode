package leetcode.linkedList.medium.reorderList_143;

import leetcode.linkedList.ListNode;
import leetcode.linkedList.ListNodeTemplate;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.reorderList(ListNodeTemplate.getList());
        System.out.println(ListNodeTemplate.getList());
    }

    public void reorderList(ListNode head) {
        if (head == null) return;
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            ListNode leftNode = list.get(left);
            ListNode rightNode = list.get(right);
            if (left == right) {
                leftNode.next = null;
                break;
            }
            if (left + 1 == right) {
                rightNode.next = null;
            } else {
                rightNode.next = leftNode.next;
            }
            leftNode.next = rightNode;
            left++;
            right--;
        }
    }
}
