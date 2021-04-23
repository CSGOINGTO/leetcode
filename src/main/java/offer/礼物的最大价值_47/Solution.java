package offer.礼物的最大价值_47;

public class Solution {

    /**
     * 根据只能向右或下的规则，第一排和第一列需要做特殊处理。
     * 其他的取dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid(i, j)
     * 时间复杂度O(m * n)
     * 空间复杂度O(m * n)
     */
    public int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int row = grid.length;
        int column = grid[0].length;
        int[][] dp = new int[row][column];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0 && j == 0) continue;
                // 第一行，第j列的值 = 第j - 1列加上当前值
                if (i == 0) {
                    dp[i][j] = grid[0][j] + dp[0][j - 1];
                    // 第一列，第i行的值 = 第i - 1行加上当前值
                } else if (j == 0) {
                    dp[i][j] = grid[i][0] + dp[i - 1][0];
                    // 取j - 1列或i - 1行中的最大值加上当前值
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[row - 1][column - 1];
    }

    /**
     * 直接在所给的数组上进行处理
     * 时间复杂度O(m * n)
     * 空间复杂度O(1)
     */
    public int maxValue1(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int row = grid.length;
        int column = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0 && j == 0) continue;
                if (i == 0) {
                    grid[0][j] = grid[0][j - 1] + grid[0][j];
                } else if (j == 0) {
                    grid[i][0] = grid[i - 1][j] + grid[i][0];
                } else {
                    grid[i][j] = Math.max(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[row - 1][column - 1];
    }
}
