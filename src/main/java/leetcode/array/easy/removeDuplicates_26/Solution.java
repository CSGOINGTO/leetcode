package leetcode.array.easy.removeDuplicates_26;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates3(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[len]) {
                nums[++len] = nums[i];
            }
        }
        return ++len;
    }

    public int removeDuplicates1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = 1;
        for (int left = 0; left < nums.length; left++) {
            int repeatLen = 0;
            for (int right = left + 1; right < nums.length; right++) {
                if (nums[left] == nums[right]) {
                    repeatLen++;
                    continue;
                }
                if (right == nums.length - 1 && nums[left] == nums[right]) {
                    repeatLen++;
                    nums[res] = nums[right];
                    res++;
                    left += repeatLen;
                    break;
                }
                nums[res] = nums[right];
                res++;
                left += repeatLen;
                break;
            }
        }
        return res;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0;
        for (int right = left; right < nums.length; right++) {
            if (nums[left] != nums[right]) {
                if (left != right) nums[++left] = nums[right];
                left++;
            }
        }
        return left + 1;
    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     */
    public int removeDuplicates3(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int left = 0;
        for (int right = 1; right < len;) {
            if (nums[left] == nums[right]) {
                right++;
                continue;
            }
            nums[++left] = nums[right];
        }
        return left + 1;
    }
}
