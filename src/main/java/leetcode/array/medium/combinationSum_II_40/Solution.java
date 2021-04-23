package leetcode.array.medium.combinationSum_II_40;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> tmpRes = new HashSet<>();
        Arrays.sort(candidates);
        sum(candidates, tmpRes, new ArrayList<>(), new boolean[candidates.length], target, 0);
        for (List<Integer> set : tmpRes) {
            res.add(new ArrayList<>(set));
        }
        return res;
    }

    private void sum(int[] candidates, Set<List<Integer>> res, List<Integer> tmpList, boolean[] visited, int target, int k) {
        if (target == 0) {
            res.add(new ArrayList<>(tmpList));
            System.out.println("~~~找到符合条件的tmpList：" + tmpList);
            return;
        }
        if (target < 0) {
            System.out.println("xxx非法的target: " + target);
            return;
        }
        for (int i = k; i < candidates.length; i++) {
            if (visited[i]) continue;
            if (target - candidates[i] < 0) continue;
            visited[i] = true;
            tmpList.add(candidates[i]);
            System.out.println("-->递归之前的i值：" + i + ", 当前tmpList为：" + tmpList + ", 剩余的target为：" + (target - candidates[i]) + ", 剩余未遍历的nums：" + Arrays.toString(Arrays.copyOfRange(candidates, i + 1, candidates.length)));
            sum(candidates, res, tmpList, visited, target - candidates[i], i + 1);
            tmpList.remove((Integer) candidates[i]);
            System.out.println("<--递归之后的i值：" + i + ", 当前tmpList为：" + tmpList + ", 剩余的target为：" + (target - candidates[i]));
            visited[i] = false;
        }
    }

    public List<List<Integer>> combinationSum21(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // 关键步骤
        Arrays.sort(candidates);

        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(candidates, len, 0, target, path, res);
        return res;
    }

    /**
     * @param candidates 候选数组
     * @param len        冗余变量
     * @param begin      从候选数组的 begin 位置开始搜索
     * @param target     表示剩余，这个值一开始等于 target，基于题目中说明的"所有数字（包括目标数）都是正整数"这个条件
     * @param path       从根结点到叶子结点的路径
     * @param res
     */
    private void dfs(int[] candidates, int len, int begin, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++) {
            // 大剪枝：减去 candidates[i] 小于 0，减去后面的 candidates[i + 1]、candidates[i + 2] 肯定也小于 0，因此用 break
            if (target - candidates[i] < 0) {
                break;
            }

            // 小剪枝：同一层相同数值的结点，从第 2 个开始，候选数更少，结果一定发生重复，因此跳过，用 continue
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.addLast(candidates[i]);
            // 调试语句 ①
            // System.out.println("递归之前 => " + path + "，剩余 = " + (target - candidates[i]));

            // 因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
            dfs(candidates, len, i + 1, target - candidates[i], path, res);

            path.removeLast();
            // 调试语句 ②
            // System.out.println("递归之后 => " + path + "，剩余 = " + (target - candidates[i]));
        }
    }

}
