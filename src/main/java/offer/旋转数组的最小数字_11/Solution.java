package offer.旋转数组的最小数字_11;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minArray(new int[]{3,3,1,3}));
    }

    /*
    比较同一侧数值与mid的关系，如果数值相同则比较的那一侧下标 -1
     */
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) return 0;
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            // 1,2,3,4,5     3 < 5 right = mid
            if (numbers[mid] < numbers[right]) {
                right = mid;
                // 3,4,5,1,2  5 > 2 left = mid + 1
            } else if (numbers[mid] > numbers[right]) {
                left = mid + 1;
                // 5,5,5,1,5 5 = 5 right--
            } else {
                right--;
            }
        }
        return numbers[left];
    }
}
