package offer.连续子数组的最大和_42;

public class Solution {
    /**
     * 动态规划：dp(n) = dp(n - 1) + nums[i] 与 nums[i] 中的最大值
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     */
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int tmp = res;
        for (int i = 1; i < nums.length; i++) {
            tmp = Math.max(tmp + nums[i], nums[i]);
            res = Math.max(res, tmp);
        }
        return res;
    }
}
