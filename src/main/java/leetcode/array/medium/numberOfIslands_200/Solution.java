package leetcode.array.medium.numberOfIslands_200;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    /**
     * 深度优先搜索解法
     * 时间复杂度O(m * n)
     * 空间复杂度O(m * n)
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid[0].length == 0) return 0;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // 当遇到岛屿时，进行遍历
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    // 岛屿的数量为进行深度优先搜索的次数
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        // 如果i/j不符合边界条件或者当前位置为水的话，直接返回
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] == '0') {
            return;
        }
        // 将遍历到的地方改成水
        grid[i][j] = '0';
        // 按照4个方向依次遍历
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    /**
     * 广度优先搜索解法
     * 时间复杂度O(m * n)
     * 空间复杂度O(m * n)
     */
    public int numIslands1(char[][] grid) {
        if (grid == null || grid[0].length == 0) return 0;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] tmpArray = queue.poll();
            int c = tmpArray[0];
            int r = tmpArray[1];
            if (c >= 0 && c <= grid.length - 1 && r >= 0 && r <= grid[0].length - 1 && grid[i][j] == '1') {
                grid[c][r] = '0';
                queue.offer(new int[]{c - 1, r});
                queue.offer(new int[]{c + 1, r});
                queue.offer(new int[]{c, r + 1});
                queue.offer(new int[]{c, r - 1});
            }
        }
    }
}
