package other;

/**
 * @author yuan
 * @date 2020/3/28 11:53 上午
 */
public class 缺失数字 {
    /**
     * 数据为[0...n]
     * 坐标i = [0...n]
     * <p>
     * a ^ a = 0;
     * a ^ 0 = a;
     *
     *
     * 所以遍历数组,用i ^ arr[i],因为i和arr[i]中有一个元素不同,其余相同个,所以最后剩下的就是缺失是数
     */
    public static int missingNumber(int[] nums) {
        //[0,1,3]
        //[0,1,2]
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing = missing ^ i ^ nums[i];
        }
        return missing;
    }
    //public static int missingNumber2(int[] nums) {
    //    for (int i = 0; i < nums.length; i++) {
    //        nums
    //    }
    //    return missing;
    //}

    public static void main(String[] args) {
        System.out.println(1^2^3^2^1);
       // System.out.println(0^1^2^3^4^5^6^7^8 ^ );
    }
}
