package array;

/**
 * @author yuan
 * @date 2020/3/5 2:43 下午
 *
 * ref :https://leetcode-cn.com/problems/single-number/solution/xue-suan-fa-jie-guo-xiang-dui-yu-guo-cheng-bu-na-y/
 *
 * 异或: 相同为0,不同为1,
 *
 *      1^0 = 1
 *      1^1 = 0
 *      a^b^a = b
 *
 */
public class 只出现一次的数字 {
    public static void main(String[] args) {
        int[] arr1 = {2,2,1};
        int[] arr2 = {4,1,2,1,2};

        System.out.println(singleNumber(arr1));
        System.out.println(singleNumber(arr2));
    }

    public static int singleNumber(int[] arr) {
        int result = 0;
        for (int i : arr) {
            result ^= i;
        }

        return result;
    }
}
