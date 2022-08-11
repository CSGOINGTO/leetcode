package leetcode.array.medium.singleNumber_III_260;

public class Solution {

    public static void main(String[] args) {
        new Solution().singleNumber(new int[]{1, 2, 1, 3, 2, 5});
    }

    /**
     * 位运算（同为0，异为1）
     * 特点：
     * 1. 相同数字之间异或结果为0
     * 2. 任何数字与0异或结果都为自身
     * <p>
     * 解法思路：
     * 1. 因为测试用例中只有两个不同的数字，并且其他相同的数字出现的次数必为2次。这样就可以以使用位运算把相同数字的影响消除掉（相同数字异或为0）
     * 2. 然后找出不同数字中不同的某一位
     * 3. 根据上一步获取到的结果对测试用例中的数字进行分组
     */
    public int[] singleNumber(int[] nums) {
        // 1. 获取到不同数字之间的异或的结果
        int xor = 0;
        for (int num : nums) {
            xor = xor ^ num;

        }
        // 2. 获取到不同数字之间异或结果中最后一位不为0的位置（可以根据这个结果将数组中的数字分为2组）
        int bit = xor & (-xor);
        // 3. 根据数字&bit的结果，将数组中的数字分为两组。又因为相同的数字肯定为2个，因此异或肯定为0，而不同的数字又被分到了不同组，因此可以得到不同的数字
        int x = 0, y = 0;
        for (int num : nums) {
            if ((num & bit) == 0) {
                x = x ^ num;
            } else {
                y = y ^ num;
            }
        }
        return new int[]{x, y};
    }

    public void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & 1 << i) == 0 ? "0" : "1");
        }
        System.out.println();
    }
}
