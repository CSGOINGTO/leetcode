package leetcode.array.medium.maximumLengthOfRepeatedSubarray_718;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findLength1(new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 0, 1, 1}));
    }

    public int findLength3(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return 0;
        }
        int max = 0;
        int nums1Len = nums1.length;
        int nums2Len = nums2.length;
        int[] dp = new int[nums2Len + 1];
        for (int i = 1; i <= nums1Len; i++) {
            for (int j = nums2Len; j >= 1; j--) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = dp[j - 1] + 1;
                } else {
                    dp[j] = 0;
                }
                System.out.print(dp[j] + " ");
                max = Math.max(max, dp[j]);
            }
            System.out.println(" ");
        }
        return max;
    }

    public int findLength2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return 0;
        }
        int max = 0;
        int nums1Len = nums1.length;
        int nums2Len = nums2.length;
        int[][] dp = new int[nums1Len + 1][nums2Len + 1];
        for (int i = 1; i <= nums1Len; i++) {
            for (int j = 1; j <= nums2Len; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    public int findLength1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return 0;
        }
        int max = 0;
        int nums1Len = nums1.length;
        int nums2Len = nums2.length;
        // nums1不动，nums2滑动
        for (int i = 0; i < nums1Len; i++) {
            int len = Math.min(nums2Len, nums1Len - i);
            int maxLen = maxLength(nums1, nums2, i, 0, len);
            max = Math.max(maxLen, max);
        }
        // nums2不动，nums1滑动
        for (int i = 0; i < nums2Len; i++) {
            int len = Math.min(nums1Len, nums2Len - i);
            int maxLen = maxLength(nums1, nums2, 0, i, len);
            max = Math.max(max, maxLen);
        }
        return max;
    }

    private int maxLength(int[] nums1, int[] nums2, int nums1Start, int nums2Start, int len) {
        int res = 0;
        int tmp = 0;
        for (int i = 0; i < len; i++) {
            if (nums1[nums1Start + i] == nums2[nums2Start + i]) {
                tmp++;
            } else {
                tmp = 0;
            }
            res = Math.max(res, tmp);
        }
        return res;
    }

    public int findLength(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return 0;
        }
        int res = 0;
        int maxLen = 0;
        // 1,2,3,2,1
        // 3,2,1,4,7
        // 负责nums1的位置
        int left = 0;
        // 负责nums2的位置
        int right = nums2.length - 1;
        int len = 0;
        while (len <= nums1.length + nums2.length - 1) {
            len++;
            // 当nums2还没有滑动完毕，nums1的初始位置不变，len由nums2决定
            if (right >= 0) {
                if (isMatch(nums1, nums2, 0, right, nums2.length - right)) {
                    maxLen = Math.max(maxLen, nums2.length - right);
                }
                right--;
                // 当nums2滑动完毕后，nums2的初始位置不变，len由nums1决定
            } else {
                if (isMatch(nums1, nums2, left, 0, nums1.length - left)) {
                    maxLen = Math.max(maxLen, nums1.length - left);
                }
                left++;
            }
            res = Math.max(res, maxLen);
        }
        return res;
    }

    /**
     * 判断相交的数组部分是否是公共部分
     */
    private boolean isMatch(int[] nums1, int[] nums2, int nums1Start, int nums2Start, int len) {
        while (len > 0) {
            if (nums1[nums1Start++] != nums2[nums2Start++]) {
                return false;
            }
            len--;
        }
        return true;
    }
}
