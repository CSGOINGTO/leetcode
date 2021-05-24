package leetcode.str.medium.stringToIntegerAtoi_8;

public class Solution {

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    public int myAtoi(String s) {
        if (s == null) return 0;
        s = s.trim();
        if (s.length() == 0) return 0;
        char[] sChars = s.toCharArray();
        int res = 0;
        int flag = 1;
        int i = 1;
        int target = Integer.MAX_VALUE / 10;
        if (sChars[0] == '-') {
            flag = -1;
        } else if (sChars[0] != '+') {
            i = 0;
        }
        for (; i < sChars.length; i++) {
            if (sChars[i] < '0' || sChars[i] > '9') {
                break;
            }
            if ((res > target) || (res == target && sChars[i] > '7')) {
                return flag == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res * 10 + (sChars[i] - '0');
        }
        return res * flag;
    }
}
