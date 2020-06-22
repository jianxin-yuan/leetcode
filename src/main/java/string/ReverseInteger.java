package string;

/**
 * @author yuan
 * @date 2020/3/9 1:43 下午
 * <p>
 *     整数反转
 * https://leetcode-cn.com/problems/reverse-integer/solution/zheng-shu-fan-zhuan-by-leetcode/
 */
public class ReverseInteger {
    public static void main(String[] args) {
        int[] arr = {123, -123, 120};
        for (int i : arr) {
            System.out.println(reverseInt(i));
        }
    }


    public static int reverseInt(int num) {
        //使用long来避免int溢出
        long temp = 0;
        while (num != 0) {
            // 得到个位数
            int pop = num % 10;
            // 计算新值
            temp = temp * 10 + pop;
            //判断是否溢出
            if (temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE) {
                return 0;
            }
            //除以10
            num /= 10;
        }
        return (int) temp;
    }
}
