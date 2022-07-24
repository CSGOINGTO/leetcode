package leetcode.array.medium.uniquePaths_62;

public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePaths1(51, 9)); //1916797311
    }

    private int count = 0;

    /**
     * 回溯解法，超时
     */
    public int uniquePaths(int m, int n) {
        if (m == 0) return 0;
        if (m == 1 || n == 1) return 1;
        dfs(0, 0, new boolean[m][n]);
        return count;
    }

    private void dfs(int m, int n, boolean[][] isVisited) {
        // 如果可以到达右下角，则是一个合法的路径
        if ((m == isVisited.length - 1 || n == isVisited[m].length - 1)) {
            count++;
            return;
        }

        // 判断是否可以向右侧走
        if (m < isVisited.length - 1 && n < isVisited[m].length - 1 && !isVisited[m + 1][n]) {
            isVisited[m + 1][n] = true;
            dfs(m + 1, n, isVisited);
            isVisited[m + 1][n] = false;
        }
        // 判断是否可以向下走
        if (m < isVisited.length - 1 && n < isVisited[m].length - 1 && !isVisited[m][n + 1]) {
            isVisited[m][n + 1] = true;
            dfs(m, n + 1, isVisited);
            isVisited[m][n + 1] = false;
        }
    }

    /**
     * dp解法
     */
    public int uniquePaths1(int m, int n) {
        if (m == 0) return 0;
        if (m == 1 || n == 1) return 1;
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
