package leetcode.array.hard.minimumNumberOfRefuelingStops_871;

import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] stations = {{10, 60}, {20, 30}, {30, 30}, {60, 40}};
        System.out.println(solution.minRefuelStops(100, 10, stations));
    }


    /**
     * 贪心：只能能到加油站就将油放入备用，并且备用中的油是按照从大到小排列的
     * 这样油不够用的时候就去备用库中加油，如果备用库中的油不足以到达下一个加油站或者终点，那么表示无法到达终点。
     * <p>
     * 1. 先把备用油加上，此时只需要判断是否可以到达加油站，如果到达不了，则返回-1；
     * 2. 使用备用油判断是否可以到达终点，如果到达不了，则返回-1。
     */
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        // 没有加油站时，判断初始的油量是否能到到目的地
        if (stations.length == 0) {
            return startFuel >= target ? 0 : -1;
        }
        int ans = 0;
        PriorityQueue<Integer> p = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        int fuel = startFuel;
        for (int[] station : stations) {
            // 油量不足，加油
            while (fuel < station[0]) {
                Integer oil = p.poll();
                if (oil == null) return -1;
                fuel += oil;
                ans++;
            }
            // 备用油
            p.offer(station[1]);
        }
        while (fuel < target) {
            Integer oil = p.poll();
            if (oil == null) return -1;
            fuel += oil;
            ans++;
        }
        return ans;
    }

}
