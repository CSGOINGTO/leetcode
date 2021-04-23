package leetcode.array.medium.permutations_II_47;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.permuteUnique(new int[]{1, 1, 2, 2}));
    }

    //输入：nums = [1,1,2]
    //输出：
    //[[1,1,2],
    // [1,2,1],
    // [2,1,1]]
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, res, new ArrayDeque<>(), new boolean[nums.length]);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, Deque<Integer> tmpRes, boolean[] visited) {
        if (tmpRes.size() == nums.length) {
            res.add(new ArrayList<>(tmpRes));
            System.out.println("YYY--获取到结果, tmpRes: " + tmpRes + ", visited: " + Arrays.toString(visited));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 如果当前层的元素已经使用过，则直接进入下一次的循环
            if (visited[i]) {
//                if (i == nums.length - 1)
//                    System.out.println("<--visited退出循环...");
                continue;
            }

            // 如果当前层的元素和上一层的元素相同，并且上一层的元素没有使用过，则直接进入下次循环(即通过递归进到for循环之后，需要判断当前循环中是否与此次for循环的状态一致)
            if (i > 0 && !visited[i - 1] && nums[i] == nums[i - 1]) {
                System.out.println("i = " + i + ", nums: " + Arrays.toString(nums) + ", nums[i] == nums[i - 1]进入下次循环...");
                if (i == nums.length - 1)
                    System.out.println("<--i = " + i + ", nums: " + Arrays.toString(nums) + ", nums[i] == nums[i - 1]退出循环...");
                continue;
            }
            visited[i] = true;
            tmpRes.addLast(nums[i]);
            System.out.println("-->进入递归前，i = " + i + ", tmpRes = " + tmpRes + ", visited = " + Arrays.toString(visited));
            dfs(nums, res, tmpRes, visited);
            System.out.println("<--递归返回后，i = " + i + ", tmpRes = " + tmpRes + ", visited = " + Arrays.toString(visited));
            tmpRes.removeLast();
            visited[i] = false;
            System.out.println("---for循环结束后状态，i = " + i + ", tmpRes = " + tmpRes + ", visited = " + Arrays.toString(visited));
            if (i == nums.length - 1) System.out.println("<--for循环正常退出！！！");
        }
    }

    public List<List<Integer>> permuteUnique1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        // 排序（升序或者降序都可以），排序是剪枝的前提
        Arrays.sort(nums);
        // 使用 Deque 是 Java 官方 Stack 类的建议
        Deque<Integer> path = new ArrayDeque<>(nums.length);
        dfs1(nums, res, path, new boolean[nums.length]);
        return res;
    }

    private void dfs1(int[] nums, List<List<Integer>> res, Deque<Integer> path, boolean[] visited) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (visited[i]) continue;
            // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            path.addLast(nums[i]);
            visited[i] = true;
            // 进入下一层
            dfs1(nums, res, path, visited);
            // 回溯部分的代码，和 dfs 之前的代码是对称的
            visited[i] = false;
            path.removeLast();
        }
    }
}
