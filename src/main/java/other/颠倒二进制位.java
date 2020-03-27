package other;

/**
 * @author yuan
 * @date 2020/3/27 9:29 下午
 * <p>
 * https://leetcode-cn.com/problems/reverse-bits/solution/dian-dao-er-jin-zhi-wei-by-gpe3dbjds1/
 */
public class 颠倒二进制位 {
    public static int reverseBits(int n) {
        int res = 0;
        int i = 32;
        while (i-- > 0) {
            //res 左移一位
            res <<= 1;
            // n & 1 可以得到最低位数字
            res += (n & 1);
            // n 右移一位
            n >>= 1;
        }
        return res;
    }
}
