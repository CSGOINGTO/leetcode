package leetcode.array.medium.coinChange_322;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        Solution solution = new Solution();
        System.out.println(solution.coinChange(coins, 11));
    }

    int[] memo;

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[amount] == (amount + 1) ? -1 : dp[amount];
    }

    public int coinChange2(int[] coins, int amount) {
        // 自底向上的动态规划
        if (coins.length == 0) {
            return -1;
        }

        // memo[n]的值： 表示的凑成总金额为n所需的最少的硬币个数
        int[] memo = new int[amount + 1];
        memo[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && memo[i - coins[j]] < min) {
                    min = memo[i - coins[j]] + 1;
                }
            }
            // memo[i] = (min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min);
            memo[i] = min;
        }

        return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];
    }

    public int coinChange1(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        memo = new int[amount];
        return findWay(coins, amount);
    }

    // memo[n] 表示钱币n可以被换取的最少的硬币数，不能换取就为-1
    // findWay函数的目的是为了找到 amount数量的零钱可以兑换的最少硬币数量，返回其值int
    public int findWay(int[] coins, int amount) {
        System.out.println(Arrays.toString(memo));
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        // 记忆化的处理，memo[n]用赋予了值，就不用继续下面的循环
        // 直接的返回memo[n] 的最优值
        if (memo[amount - 1] != 0) {
            return memo[amount - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = findWay(coins, amount - coins[i]);
            if (res >= 0 && res < min) {
                min = res + 1; // 加1，是为了加上得到res结果的那个步骤中，兑换的一个硬币
            }
        }
        memo[amount - 1] = (min == Integer.MAX_VALUE ? -1 : min);
        return memo[amount - 1];
    }


//    private int res = Integer.MAX_VALUE;
//
//    public int coinChange(int[] coins, int amount) {
//        if (coins == null || coins.length == 0) return -1;
//        dfs(coins, amount, 0);
//        return res == Integer.MIN_VALUE ? -1 : res;
//    }
//
//    private void dfs(int[] coins, int amount, int count) {
//        if (amount < 0) return;
//        if (amount == 0) {
//            res = Math.min(res, count);
//        }
//        for (int coin : coins) {
//            dfs(coins, amount - coin, count + 1);
//        }
//    }
}
