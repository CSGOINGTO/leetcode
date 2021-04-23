package leetcode.array.medium.subsets_II_90;

import java.util.*;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, res, new ArrayDeque<>(), new boolean[nums.length], 0);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, Deque<Integer> deque, boolean[] visited, int k) {
        res.add(new ArrayList<>(deque));
        for (int i = k; i < nums.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) continue;
            visited[i] = true;
            deque.addLast(nums[i]);
            dfs(nums, res, deque, visited, i + 1);
            deque.removeLast();
            visited[i] = false;
        }
    }
}
