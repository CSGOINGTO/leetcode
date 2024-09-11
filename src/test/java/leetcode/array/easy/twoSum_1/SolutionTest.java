package leetcode.array.easy.twoSum_1;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SolutionTest {

    @Test
    public void test() {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15, 12, 131, 21313, 132, 133, 42, 456, 67, 867, 2123, 14, 1}, 25)));
    }


    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        Arrays.sort(nums);
        for (int num : nums) {
            int search = search(nums, target - num);
            if (search != Integer.MAX_VALUE) {
                return new int[]{map.get(num), map.get(target - num)};
            }
        }
        return new int[0];
    }

    private int search(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        while (leftIndex <= rightIndex) {
            int mid = leftIndex + (rightIndex - leftIndex) / 2;
            if (nums[mid] == target) return target;
            if (nums[mid] < target) leftIndex = mid + 1;
            if (nums[mid] > target) rightIndex = mid - 1;
        }
        return Integer.MAX_VALUE;
    }

}
