package leetcode.design.easy.maximumLengthOfRepeatedSubarray_155;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
    }

    private Deque<Integer> stack = new LinkedList<>();

    private Queue<Integer> priorityStack = new PriorityQueue<>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int val) {
        stack.push(val);
        priorityStack.offer(val);
    }

    public void pop() {
        if (!stack.isEmpty()) {
            int res = stack.pop();
            priorityStack.remove(res);
        }
    }

    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        return -1;
    }

    public int getMin() {
        if (!priorityStack.isEmpty()) {
            return priorityStack.peek();
        }
        return -1;
    }
}
