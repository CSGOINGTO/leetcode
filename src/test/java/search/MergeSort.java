package search;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        new MergeSort().mergeSort(new int[]{3, 5, 2, 1, 65, 78, 433, 123, 123, 14, 2523, 45, 2345, 2, 5});
    }

    public void mergeSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private void sort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(nums, left, mid);
            sort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    private void merge(int[] nums, int left, int mid, int right) {
        // [left, mid]  [mid + 1, right]有序
        int[] tmpArray = new int[right - left + 1];
        int l1 = left;
        int l2 = mid + 1;
        int index = 0;
        while (l1 <= mid && l2 <= right) {
            if (nums[l1] <= nums[l2]) {
                tmpArray[index++] = nums[l1++];
            } else {
                tmpArray[index++] = nums[l2++];
            }
        }
        while (l1 <= mid) {
            tmpArray[index++] = nums[l1++];
        }
        while (l2 <= right) {
            tmpArray[index++] = nums[l2++];
        }
        for (int i = 0; i < tmpArray.length; i++) {
            nums[left + i] = tmpArray[i];
        }
    }
}
