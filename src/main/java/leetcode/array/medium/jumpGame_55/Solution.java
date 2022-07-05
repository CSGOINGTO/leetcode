package leetcode.array.medium.jumpGame_55;

public class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) return true;
        int maxRight = nums[0]; // 当前能到达数组的最右边的下标
        for (int i = 1; i <= maxRight; i++) { // 遍历到当前能到达数组最右边的下标
            maxRight = Math.max(nums[i] + i, maxRight); // 在可以遍历到的元素中取最右边的下标
            if (maxRight >= nums.length - 1) return true; // 如果可以到达数组末尾，则表示符合题意
        }
        return false;
    }
}
