package leetcode.str.easy.longestPalindrome_409;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 0;
        boolean isAdd = false;
        Map<Character, Integer> map = new HashMap<>();
        char[] sChars = s.toCharArray();
        for (char c : sChars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            // 个数为偶数，不用处理
            if (entry.getValue() % 2 == 0) {
                res += entry.getValue();
            } else {
                // 如果为奇数，则将奇数字符的个数少加一个
                res += (entry.getValue() - 1);
                // 个数为奇数的字符可以放到结果字符的中间，这样最终的结果需要+1
                isAdd = true;
            }
        }
        return isAdd ? res + 1 : res;
    }
}
