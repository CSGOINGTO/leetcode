package leetcode.array.medium.combinationSum_39;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, res, new ArrayList<>(), target, 0);
        return res;
    }

    private void dfs(int[] candidates, List<List<Integer>> res, List<Integer> tmpList, int target, int flag) {
        if (target == 0) {
            res.add(new ArrayList<>(tmpList));
            return;
        }
        if (target < 0) return;
        for (int i = flag; i < candidates.length; i++) {
            if (target - candidates[i] < 0) continue;
            tmpList.add(candidates[i]);
            dfs(candidates, res, tmpList, target - candidates[i], i);
            tmpList.remove((Integer) candidates[i]);
        }
    }
}
