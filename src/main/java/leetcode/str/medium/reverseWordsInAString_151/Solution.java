package leetcode.str.medium.reverseWordsInAString_151;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseWords2("F R  I   E    N     D      S      "));
    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    public String reverseWords(String s) {
        String[] strArray = s.trim().split("[ ]+");
        Deque<String> queue = new LinkedList<>();
        for (String value : strArray) {
            queue.push(value);
        }
        StringBuilder sb = new StringBuilder(queue.size());
        while (!queue.isEmpty()) {
            sb.append(queue.pop());
            if (queue.size() > 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    public String reverseWords2(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        // 1. 去除多余的空格
        trim(stringBuilder, s);
        // 2. 翻转字符串
        reverseStr(stringBuilder, 0, stringBuilder.length() - 1);
        // 3. 翻转字符串中的每一个单词
        reverseWord(stringBuilder);
        return stringBuilder.toString();

    }

    private void reverseWord(StringBuilder stringBuilder) {
        int left = 0;
        int right = 0;
        while (right < stringBuilder.length()) {
            while (left < stringBuilder.length() && stringBuilder.charAt(left) == ' ') {
                left++;
                right++;
            }
            while (right < stringBuilder.length() && stringBuilder.charAt(right) != ' ') {
                right++;
            }
            reverseStr(stringBuilder, left, right - 1);
            left = right;
        }
    }

    private void reverseStr(StringBuilder stringBuilder, int left, int right) {
        while (left < right) {
            char tmp = stringBuilder.charAt(left);
            stringBuilder.setCharAt(left, stringBuilder.charAt(right));
            stringBuilder.setCharAt(right, tmp);
            left++;
            right--;
        }
    }

    private void trim(StringBuilder stringBuilder, String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < str.length() - 1 && str.charAt(left) == ' ') {
            left++;
        }
        while (right >= 0 && str.charAt(right) == ' ') {
            right--;
        }
        while (left <= right) {
            if (str.charAt(left) != ' ') {
                stringBuilder.append(str.charAt(left++));
            } else {
                while (left < right && str.charAt(left) == ' ') {
                    left++;
                }
                // 注意，因为right是一个合法的字符，因此，left位置处的字符不合法进入到这个判断时，会遍历到right的位置，当遍历到right位置时，还没有遍历完成，因此对于这种情况，还是需要在后面加一个空格的
                if (left <= right) {
                    stringBuilder.append(" ");
                }
            }
        }
    }
}
