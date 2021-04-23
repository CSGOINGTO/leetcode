package offer.股票的最大利润_63;

public class Solution {
    /**
     * 暴力解法
     * 时间复杂度O(n2)
     * 空间复杂度O(1)
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }

    /**
     * 动态规划
     * dp(i) = Math.max(dp(i - 1), prices[i] - min)
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     */
    public int maxProfit1(int[] prices) {
        int max = 0;
        if (prices == null || prices.length == 0) return max;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }

    /**
     * 动态规划
     */
    public int maxProfit2(int[] prices) {
        int max = 0;
        int cost = Integer.MAX_VALUE;
        for (int price : prices) {
            cost = Math.min(cost, price);
            max = Math.max(max, price - cost);
        }
        return max;
    }


}
