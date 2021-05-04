package leetcode.array.medium.containerWithMostWater_11;

public class Solution {

    /**
     * 暴力解法
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if (height.length <= 1) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int minHeight = Math.min(height[i], height[j]);
                max = Math.max(max, minHeight * (j - i));
            }
        }
        return max;
    }

    /**
     * 双指针法
     *
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        if (height.length <= 1) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int minHeight = height[left] < height[right] ? height[left++] : height[right--];
            max = Math.max(max, minHeight * (right - left + 1));
        }
        return max;
    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     */
    public int maxArea2(int[] height) {
        if (height == null || height.length == 0) return 0;
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left != right) {
            res = Math.max(res, Math.min(height[left], height[right]) * (right - left));
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }
}
