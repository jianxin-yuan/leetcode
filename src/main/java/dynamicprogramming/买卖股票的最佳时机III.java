package dynamicprogramming;

/**
 * @author yuan
 * @date 2020/3/22 11:30 上午
 * <p>
 * 最多交易2次
 */
public class 买卖股票的最佳时机III {


    /**
     * base case
     * dp[-1][k][0] = 0
     * dp[-1][k][1] = -∞
     * dp[i][0][0] = 0
     * dp[i][0][1] = -∞
     * 状态转移方程:
     * dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1]+prices[i])
     * dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i])
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int n = prices.length;
        int max_k = 2;
        int[][][] dp = new int[n][max_k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int k = max_k; k >= 1; k--) {
                if (i - 1 == -1) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][max_k][0];
    }
}
