package leetcode.array.easy.maximumSumWithExactlyKElements_2656;

public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{5,5,5,12,12,12,12,12,1,23,1,23,1,31,23,12};
        Solution solution = new Solution();
        System.out.println(solution.maximizeSum(nums, 12));
    }

    public int maximizeSum(int[] nums, int k) {
        int res = getMaxNum(nums);
        return res * k + (k * (k - 1) / 2);
    }

    private int getMaxNum(int[] nums) {
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i];
            for (int j = i; j < nums.length; j++) {
                tmp = Math.max(tmp, nums[j]);
            }
            res = Math.max(res, tmp);
        }
        return res;
    }
}
