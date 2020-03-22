package dynamicprogramming;

/**
 * @author yuan
 * @date 2020/3/22 10:51 上午
 *
 * 交易此时不限.但是每次卖出之后要隔一天才能再次买入
 */
public class 最佳买卖股票时机含冷冻期 {

    /**
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
     * dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i])
     * 解释：第 i 天选择 buy 的时候，要从 i-2 的状态转移，而不是 i-1 。
     */
    public int maxProfit(int[] prices) {

        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        int dp_prev = 0; //代表dp[i-2][0]
        for (int i = 0; i < prices.length; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_prev - prices[i]);
            dp_prev = temp;
        }

        return dp_i_0;
    }
}
