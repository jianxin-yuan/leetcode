package dynamicprogramming;

/**
 * @author yuan
 * @date 2020/3/20 17:05
 * <p>
 * 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3/
 * 只能交易一次
 */
public class StockTrading1 {
    //找出数组中2个数间最大的差值,且后一个数大于前一个数
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int value = prices[j] - prices[i];
                if (value > 0 && value > maxProfit) {
                    maxProfit = value;
                }
            }
        }
        return maxProfit;
    }

    /**
     * 动态规划  i:第几天,k:可交易次数,1:持有,0:未持有
     * <p>
     * base case :
     * dp[i][0][0]=0
     * dp[i][0][1]= -∞
     * dp[-1][k][0]=0
     * dp[-1][k][1]= -∞
     * <p>
     * 状态转移方程:
     * dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1] + prices[i])
     * dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k-1][0] - prices[i])
     * <p>
     * 由于只能交易一次,k=1为固定值,所以可以简化为二维数组,由于dp[i-1][k-1][0] = dp[i-1][0][0] = 0
     * 所以简化状态转移方程:
     * dp[i][0] = max(dp[i-1][0],dp[i-1][1] + prices[i])
     * dp[i][1] = max(dp[i-1][1], - prices[i])
     */
    public int maxProfit2(int[] prices) {
        if (prices.length == 0) return 0;
        int length = prices.length;
        int[][] dp = new int[length][2];
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
            } else {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            }
        }
        return dp[length - 1][0];
    }


    //简化版本,由于最终状态至于相邻状态有关,不需要维护整个数组,用一个变量保存就行了,空间复杂度O(1)
    public int maxProfit3(int[] prices) {
        //base case: dp[-1][0] = 0, dp[-1][1] = -infinity
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        return dp_i_0;
    }

    //贪心算法，从左向右，维护一个最小值，与每一天的股票价格做差，差最大的为答案
    public int maxProfit4(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }
}
