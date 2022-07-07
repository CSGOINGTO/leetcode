package leetcode.array.medium.mergeIntervals_56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] nums = new int[][]{{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
        System.out.println(Arrays.deepToString(solution.merge1(nums)));
    }

    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals == null || intervals.length == 0) return res.toArray(new int[0][]);
        // 对起点终点进行排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int i = 0;
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            // 如果有重叠，循环判断哪个起点满足条件
            while (i < intervals.length - 1 && intervals[i + 1][0] <= right) {
                i++;
                right = Math.max(right, intervals[i][1]);
            }
            // 将现在的区间放进res里面
            res.add(new int[]{left, right});
            // 接着判断下一个区间
            i++;
        }
        return res.toArray(new int[0][]);
    }

    public int[][] merge1(int[][] intervals) {
        return doMerge(intervals, false, new boolean[intervals.length]);
    }

    public int[][] doMerge(int[][] intervals, boolean isDo, boolean[] isVisited) {
        List<int[]> resList = new ArrayList<>();
        /*
         1. 依次判断当前数组和其他的数组是否可以合并
         2. 已经判断过的数组不在被处理
         3. 将合并之后的结果再次进行合并的处理，直到没有合并处理之后，即为最终的结果（防止出现（小区间1，小区间2，大区间），
            如果小区间1和小区间2不能合并的话，第一次的结果将是（大区间，小区间2），因此需要再次合并，直到没有合并操作了为止）
         */


        for (int i = 0; i < intervals.length; i++) {
            if (isVisited[i]) continue;
            int left = intervals[i][0];
            int right = intervals[i][1];
            isVisited[i] = true;
            for (int j = 0; j < intervals.length; j++) {
                if (isVisited[j]) continue;
                int a = intervals[j][0];
                int b = intervals[j][1];
                if (a > right || b < left) {
                    continue;
                } else if ((b == left) || (a < left && left < b && b <= right)) {
                    left = a;
                } else if (a < left && b >= right) {
                    left = a;
                    right = b;
                } else if (left < a && b <= right) {
                    left = left;
                    right = right;
                } else if ((left < a && a < right && right < b) || (right == a && a < b) || (left == a && right < b)) {
                    right = b;
                }
                isVisited[j] = true;
                isDo = true;
            }
            int[] tmp = new int[]{left, right};
            resList.add(tmp);
        }
        if (isDo) {
            int[][] intervalsTmp = resList.toArray(new int[0][]);
            return doMerge(intervalsTmp, false, new boolean[intervalsTmp.length]);
        }
        return resList.toArray(new int[0][]);
    }
}
