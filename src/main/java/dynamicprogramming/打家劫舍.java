package dynamicprogramming;

/**
 * @author yuan
 * @date 2020/3/22 2:17 下午
 * <p>
 * https://leetcode-cn.com/problems/house-robber/solution/da-jia-jie-she-by-leetcode/217208
 */
public class 打家劫舍 {

    /**
     * 设f(x)为打劫前x家房子所能得到的最大的资金，很容易想到动态规划的边界条件，即：
     * f(1)=nums[1]
     * f(2)=max(nums[1],nums[2])
     * 然后是最关键的动态转移方程，如果要打劫第n家，就必然不能打劫第n-1家，
     * 所以打劫第n家得到的钱一共是第n家的钱加上前n-2家获得的最多的钱，
     * 即：f(n-2)+nums(n)，如果不打劫第n家，获得的最大收益就是f(n-1)，
     * 两者我们要去较大的那个，所以动态转移方程是：
     * f(n)=max(nums[n]+f(n-2),f(n-1))
     */
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int[] answer = new int[nums.length];
        answer[0] = nums[0];
        answer[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            answer[i] = Math.max(nums[i] + answer[i - 2], answer[i - 1]);
        }
        return answer[nums.length - 1];
    }
}
