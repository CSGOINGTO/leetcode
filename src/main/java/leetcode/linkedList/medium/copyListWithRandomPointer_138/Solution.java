package leetcode.linkedList.medium.copyListWithRandomPointer_138;

import leetcode.linkedList.Node;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);
        n1.next = n2;
        n1.random = null;
        n2.next = n3;
        n2.random = n1;
        n3.next = n4;
        n3.random = n5;
        n4.next = n5;
        n4.random = n3;
        n5.random = n1;
        Solution solution = new Solution();
        solution.copyRandomList1(n1);
    }

    public Node copyRandomList1(Node head) {
        if (head == null) return head;
        Node currHead = head;
        Node newHead = new Node(0);
        Node doHead = newHead;
        // 1 -> n1 -> 2 -> n2 -> 3 -> n3 -> ^
        // newHead ：0 -> n1 -> n2 -> n3 -> ^
        while (currHead != null) {
            Node tmpNode = currHead.next;
            currHead.next = new Node(currHead.val);
            currHead.next.next = tmpNode;
            currHead = tmpNode;
        }
        currHead = head;
        while (currHead != null) {
            if (currHead.random != null) {
                currHead.next.random = currHead.random.next;
            }
            currHead = currHead.next.next;
        }
        currHead = head;
        while (currHead != null && currHead.next != null) {
            doHead.next = currHead.next;
            doHead = doHead.next;
            currHead.next = currHead.next.next;
            currHead = currHead.next;
        }
        return newHead.next;
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node newNode = new Node(-1);
        Node doNode = newNode;
        Node curHead = head;
        while (head != null) {
            Node node = new Node(head.val);
            map.put(head, node);
            doNode.next = node;
            doNode = doNode.next;
            head = head.next;
        }
        doNode = newNode.next;
        while (doNode != null) {
            doNode.random = map.get(curHead.random);
            doNode = doNode.next;
            curHead = curHead.next;
        }
        return newNode.next;
    }
}
