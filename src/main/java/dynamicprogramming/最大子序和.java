package dynamicprogramming;

/**
 * @author yuan
 * @date 2020/3/22 1:55 下午
 * <p>
 * https://leetcode-cn.com/problems/maximum-subarray/solution/zui-da-zi-xu-he-by-leetcode/
 */
public class 最大子序和 {

    //贪心算法: 使用2个变量存储当前最大和 / 历史最大和, 最后返回2个值中大的一个
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0], currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //如果num > currentSum + num,则表示前面的值为负数,所有从num开始重新计算最优解
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }

    //动态规划思路: 遍历数组,如果num[i-1] > 0 ,表示对结果有增益,则nums[i] += nums[i-1]
    // 然后比较maxNum = Math.max(maxNum,nums[i])
    public int maxSubArray2(int[] nums) {
        int maxNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
            maxNum = Math.max(nums[i], maxNum);
        }

        return maxNum;
    }

}
