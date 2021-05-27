package leetcode.array.medium.mergeIntervals_56;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] nums = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(solution.merge1(nums)));
    }

    public int[][] merge1(int[][] intervals) {
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

    public int[][] merge(int[][] intervals) {
        Set<int[]> res = new HashSet<>();
        Map<Integer, int[]> startMap = new HashMap<>();
        Map<Integer, int[]> endMap = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            startMap.put(intervals[i][0], intervals[i]);
            endMap.put(intervals[i][1], intervals[i]);
        }
        for (Map.Entry<Integer, int[]> startEntry : startMap.entrySet()) {
            int[] tmp = null;
            for (Map.Entry<Integer, int[]> endEntry : endMap.entrySet()) {
                int[] startArray = startEntry.getValue();
                int[] endArray = endEntry.getValue();
                if (startArray[1] >= endArray[0]) {
                    if (tmp == null) {
                        tmp = new int[2];
                        tmp[0] = startArray[0];
                        tmp[1] = endArray[1];
                    } else {
                        if (tmp[1] < endArray[1]) {
                            tmp[1] = endArray[1];
                        }
                    }
                }
                if (tmp != null) res.add(tmp);
            }
        }
        int[][] resArray = new int[res.size()][2];
        int index = 0;
        for (int[] a : res) {
            resArray[index++] = a;
        }
        return resArray;
    }
}
