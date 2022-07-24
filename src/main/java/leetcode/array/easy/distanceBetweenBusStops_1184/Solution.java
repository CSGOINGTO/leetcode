package leetcode.array.easy.distanceBetweenBusStops_1184;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.distanceBetweenBusStops(new int[]{7, 10, 1, 12, 11, 14, 5, 0}, 7, 2);
    }

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        // 顺时针
        int s = Math.min(start, destination);
        int e = Math.max(start, destination);
        int tmp1 = 0;
        for (int i = s; i < e; i++) {
            tmp1 += distance[i];
        }
        // 逆时针
        int tmp2 = 0;
        for (int i = e; i < distance.length; i++) {
            tmp2 += distance[i];
        }
        for (int i = 0; i < s; i++) {
            tmp2 += distance[i];
        }
        return Math.min(tmp1, tmp2);
    }

    public int distanceBetweenBusStops1(int[] distance, int start, int destination) {
        int s = Math.min(start, destination);
        int e = Math.max(start, destination);
        int all = 0;
        for (int i = 0; i < distance.length; i++) {
            all += distance[i];
        }
        int se = 0;
        for (int i = s; i < e; i++) {
            se += distance[i];
        }
        return Math.min(se, all - se);
    }
}
