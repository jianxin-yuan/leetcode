package dynamicprogramming;

/**
 * @author yuan
 * @date 2020/3/5 11:48 上午
 *
 * 买卖股票的最佳时机II
 * ref: https://github.com/MisterBooo/LeetCodeAnimation/blob/master/notes/LeetCode%E7%AC%AC122%E5%8F%B7%E9%97%AE%E9%A2%98%EF%BC%9A%E4%B9%B0%E5%8D%96%E8%82%A1%E7%A5%A8%E7%9A%84%E6%9C%80%E4%BD%B3%E6%97%B6%E6%9C%BAII.md
 * <p>
 * 从第二天开始观察，如果当前价格（今天）比之前价格（昨天）高，则把差值加入到利润中（因为我们可以昨天买入，今天卖出，如果明天价位更高的话，还可以今天买入，明天再抛出）。以此类推，遍历完整个数组后即可求得最大利润。
 *
 * 可以交易无数次
 */
public class StockTrading2 {
    public static void main(String[] args) {
        int[] source1 = {7, 1, 5, 3, 6, 4};
        int[] source2 = {1, 2, 3, 4, 5};
        int[] source3 = {7, 6, 4, 3, 1};

        System.out.println(maxProfit(source1));
        System.out.println(maxProfit(source2));
        System.out.println(maxProfit(source3));
    }

    public static int maxProfit(int[] arr) {
        int profit = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                profit += arr[i] - arr[i - 1];
            }
        }
        return profit;
    }

    /**
     * base case
     * dp[-1][k][0] = 0
     * dp[-1][k][1] = -∞
     * dp[i][0][0] = 0
     * dp[i][0][1] = -∞
     * <p>
     * 状态转移方程:
     * dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1]+prices[i])
     * dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i])
     * <p>
     * 如果 k 为正无穷，那么就可以认为 k 和 k - 1 是一样的。可以这样改写框架：
     * <p>
     * dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i])
     * = max(dp[i-1][k][1],dp[i-1][k][0]-prices[i])
     * <p>
     * 此时发现状态转移方程和K无关了,所以简化为:
     * dp[i][0] = max(dp[i-1][0],dp[i-1][1]+prices[i])
     * dp[i][1] = max(dp[i-1][1],dp[i-1][0]-prices[i])
     */
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
