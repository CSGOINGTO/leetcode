package leetcode.array.easy.merge_88;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums1 = {1, 2, 3, 0, 0, 0};
//        solution.merge1(nums1, 3, new int[]{2, 5, 6}, 3);
//        System.out.println(Arrays.toString(nums1));

        int[] nums2 = {1, 0};
        solution.merge1(nums2, 1, new int[]{0}, 1);
        System.out.println(Arrays.toString(nums2));

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // 记录插入的个数
        int count = 0;
        for (int i = 0; i < m + count; i++) {
            for (int j = count; j < n; j++) {
                if (nums1[i] > nums2[j]) {
                    System.arraycopy(nums1, i, nums1, i + 1, m + count - i);
                    nums1[i] = nums2[j];
                    count++;
                }
            }
        }
        // 插入的个数小于num2的有效长度
        if (count < n) {
            System.arraycopy(nums2, count, nums1, m + count, n - count);
        }
    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        int n1 = nums1.length - 1;
        // 按照从大到小的顺序依次放入到nums1数组中
        for (int i = n1; i >= 0; i--) {
            // 比较m和n都大于1时位置的元素大小，把大的放到数组nums1中
            if (m >= 1 && n >= 1 && nums1[m - 1] >= nums2[n - 1]) {
                nums1[i] = nums1[m - 1];
                m--;
            } else if (m >= 1 && n >= 1 && nums1[m - 1] < nums2[n - 1]) {
                nums1[i] = nums2[n - 1];
                n--;
                // 如果nums1中已经没有元素可以比较，则直接将nums2中的元素全部搬到nums1中
            } else if (m == 0 && n >= 1) {
                nums1[i] = nums2[n - 1];
                n--;
            }
        }
    }
}
