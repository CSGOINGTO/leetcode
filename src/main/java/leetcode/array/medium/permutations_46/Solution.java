package leetcode.array.medium.permutations_46;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> tmpList, boolean[] visited) {
        if (tmpList.size() == nums.length) {
            res.add(new ArrayList<>(tmpList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            tmpList.add(nums[i]);
            dfs(nums, res, tmpList, visited);
            tmpList.remove((Integer) nums[i]);
            visited[i] = false;
        }
    }
}
