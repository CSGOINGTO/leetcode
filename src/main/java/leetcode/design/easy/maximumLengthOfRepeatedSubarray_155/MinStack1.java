package leetcode.design.easy.maximumLengthOfRepeatedSubarray_155;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MinStack1 {

    private Deque<Integer> stack = new LinkedList<>();

    private Deque<Integer> helpStack = new LinkedList<>();

    /**
     * initialize your data structure here.
     */
    public MinStack1() {
    }

    public void push(int val) {
        stack.push(val);
        if (helpStack.isEmpty() || helpStack.peek() >= val) {
            helpStack.push(val);
        }
    }

    public void pop() {
        if (!stack.isEmpty() && stack.pop().equals(helpStack.peek())) {
            helpStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return helpStack.peek();
    }
}
