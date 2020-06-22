package dynamicprogramming;

/**
 * @author yuan
 * @date 2020/3/22 11:52 上午
 *
 * 买卖股票的最佳时机IV
 */
public class StockTrading4 {

    /**
     * 一次交易由买入和卖出构成，至少需要两天。所以说有效的限制 k 应该不超过 n/2，
     * 如果超过，就没有约束作用了，相当于 k = +infinity。这种情况是之前解决过的。
     */
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) return 0;
        int n = prices.length;
        if (k > n / 2) {
            return maxProfit2(prices);
        }
        int[][][] dp = new int[n][k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int j = k; j >= 1; j--) {
                if (i - 1 == -1) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }

    public static int maxProfit2(int[] prices) {
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            //保留上一次的dp_i_0
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
        }
        return dp_i_0;
    }
}
