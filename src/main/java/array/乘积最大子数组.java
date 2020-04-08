package array;

/**
 * @author yuan
 * @date 2020/4/8 15:07
 * <p>
 * https://leetcode-cn.com/problems/maximum-product-subarray/solution/hua-jie-suan-fa-152-cheng-ji-zui-da-zi-xu-lie-by-g/
 */
public class 乘积最大子数组 {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int currentMax = 1;
        int currentMin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = currentMax;
                currentMax = currentMin;
                currentMin = temp;
            }

            currentMax = Math.max(nums[i], nums[i] * currentMax);
            currentMin = Math.min(nums[i], nums[i] * currentMin);

            max = Math.max(currentMax, max);
        }
        return max;
    }
}
