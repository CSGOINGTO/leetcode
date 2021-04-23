package offer.把字符串转换成整数_67;

public class Solution {

    public int strToInt1(String str) {
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 0, sign = 1, length = str.length();
        if(length == 0) return 0;
        while(str.charAt(i) == ' ')
            if(++i == length) return 0;
        if(str.charAt(i) == '-') sign = -1;
        if(str.charAt(i) == '-' || str.charAt(i) == '+') i++;
        for(int j = i; j < length; j++) {
            if(str.charAt(j) < '0' || str.charAt(j) > '9') break;
            if(res > bndry || res == bndry && str.charAt(j) > '7')
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (str.charAt(j) - '0');
        }
        return sign * res;
    }

    public int strToInt(String str) {
        if (str == null) return 0;
        char[] str_chars = str.trim().toCharArray();
        if (str_chars.length == 0) return 0;
        int flag = Integer.MAX_VALUE / 10;
        int sign = 1;
        int result = 0;
        int i = 1;
        if (str_chars[0] == '-') sign = -1;
        else if (str_chars[0] != '+') i = 0;
        for (int j = i; j < str_chars.length; j++) {
            if (str_chars[j] > '9' || str_chars[j] < '0') break;
            if (result > flag || (result == flag && str_chars[j] > '7')) return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            result = result * 10 + (str_chars[j] - '0');
        }
        return result * sign;
    }
}
