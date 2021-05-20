package leetcode.str.easy.validPalindrome_125;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPalindrome("0P"));
    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     */
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        s = s.toLowerCase();
        char[] sChars = s.toCharArray();
        int left = 0;
        int right = sChars.length - 1;
        // 0P
        while (left < right) {
            if (!((sChars[left] >= 'a' && sChars[left] <= 'z') || (sChars[left] >= '0' && sChars[left] <= '9'))) {
                left++;
                continue;
            }
            if (!((sChars[right] >= 'a' && sChars[right] <= 'z') || (sChars[right] >= '0' && sChars[right] <= '9'))) {
                right--;
                continue;
            }
            if (sChars[left] != sChars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
