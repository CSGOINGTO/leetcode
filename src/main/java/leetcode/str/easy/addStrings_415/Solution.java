package leetcode.str.easy.addStrings_415;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.addStrings1("456", "77"));
    }

    // "11"
    // "123"
    // "134"
    public String addStrings(String num1, String num2) {
        char[] num1_chars = num1.toCharArray();
        char[] num2_chars = num2.toCharArray();
        int flag = 0;
        StringBuilder sb = new StringBuilder();
        int i = Math.min(num1_chars.length - 1, num2_chars.length - 1);
        int nums1Len = num1_chars.length - 1;
        int nums2Len = num2_chars.length - 1;
        for (; i >= 0; i--) {
            int sum = num1_chars[nums1Len--] + num2_chars[nums2Len--] - '0' - '0' + flag;
            flag = sum / 10;
            sb.append(sum % 10);
        }
        while (nums1Len >= 0) {
            int sum = num1_chars[nums1Len--] - '0' + flag;
            flag = sum / 10;
            sb.append(sum % 10);
        }
        while (nums2Len >= 0) {
            int sum = num2_chars[nums2Len--] - '0' + flag;
            flag = sum / 10;
            sb.append(sum % 10);
        }
        if (flag == 1) sb.append("1");
        return sb.reverse().toString();
    }

    public String addStrings1(String num1, String num2) {
        char[] num1_chars = num1.toCharArray();
        char[] num2_chars = num2.toCharArray();
        int flag = 0;
        int num1Len = num1_chars.length - 1;
        int num2Len = num2_chars.length - 1;
        StringBuilder sb = new StringBuilder();
        while (num1Len >= 0 || num2Len >= 0) {
            int n1 = num1Len < 0 ? 0 : num1_chars[num1Len--] - '0';
            int n2 = num2Len < 0 ? 0 : num2_chars[num2Len--] - '0';
            int tmp = n1 + n2 + flag;
            flag = tmp / 10;
            sb.append(tmp % 10);
        }
        if (flag == 1) sb.append("1");
        return sb.reverse().toString();
    }

}
