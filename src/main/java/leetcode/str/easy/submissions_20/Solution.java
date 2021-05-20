package leetcode.str.easy.submissions_20;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) return true;
        char[] sChars = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for (Character c : sChars) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else {
                if(stack.isEmpty() || c != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
