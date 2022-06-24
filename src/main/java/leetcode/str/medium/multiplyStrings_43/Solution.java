package leetcode.str.medium.multiplyStrings_43;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.multiply("9", "9"));
    }

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) return "0";
        char[] num1Chars = num1.toCharArray();
        char[] num2Chars = num2.toCharArray();
        int num1Len = num1Chars.length - 1;
        int num2Len = num2Chars.length - 1;
        String res = "0";
        for (int i = num1Len; i >= 0; i--) {
            StringBuilder stringBuilder = new StringBuilder();
            // 将num1的每一位与num2相乘
            int carry = 0;
            for (int k = 0; k < num1Len - i; k++) {
                stringBuilder.append("0");
            }
            for (int j = num2Len; j >= 0; j--) {
                int tmp = (num1Chars[i] - '0') * (num2Chars[j] - '0') + carry;
                stringBuilder.append(tmp % 10);
                carry = tmp / 10;
            }
            if (carry != 0) stringBuilder.append(carry);
            res = addNum(res, stringBuilder.reverse().toString());
        }
        return res;
    }

    private String addNum(String s1, String s2) {
        StringBuilder stringBuilder = new StringBuilder();
        int carry = 0;
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        int s1CharsLen = s1Chars.length - 1;
        int s2CharsLen = s2Chars.length - 1;
        while (s1CharsLen >= 0 || s2CharsLen >= 0) {
            int n1 = s1CharsLen < 0 ? 0 : s1Chars[s1CharsLen--] - '0';
            int n2 = s2CharsLen < 0 ? 0 : s2Chars[s2CharsLen--] - '0';
            int tmp = n1 + n2 + carry;
            stringBuilder.append(tmp % 10);
            carry = tmp / 10;
        }
        if (carry != 0) stringBuilder.append(carry);
        return stringBuilder.reverse().toString();
    }
}
