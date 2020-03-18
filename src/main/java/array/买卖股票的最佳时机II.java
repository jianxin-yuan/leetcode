package array;

/**
 * @author yuan
 * @date 2020/3/5 11:48 上午
 * ref: https://github.com/MisterBooo/LeetCodeAnimation/blob/master/notes/LeetCode%E7%AC%AC122%E5%8F%B7%E9%97%AE%E9%A2%98%EF%BC%9A%E4%B9%B0%E5%8D%96%E8%82%A1%E7%A5%A8%E7%9A%84%E6%9C%80%E4%BD%B3%E6%97%B6%E6%9C%BAII.md
 *
 * 从第二天开始观察，如果当前价格（今天）比之前价格（昨天）高，则把差值加入到利润中（因为我们可以昨天买入，今天卖出，如果明天价位更高的话，还可以今天买入，明天再抛出）。以此类推，遍历完整个数组后即可求得最大利润。
 */
public class 买卖股票的最佳时机II {
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
}
