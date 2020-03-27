package other;

/**
 * @author yuan
 * @date 2020/3/25 11:34
 *
 * https://leetcode-cn.com/problems/number-of-1-bits/solution/wei-1de-ge-shu-by-leetcode/
 *
 *
 *  & 运算 : 2个都为1,结果为1,否则为0
 *  | 运算 : 有1个为1,结果为1,2个都为0,结果为0
 *  ! 运算 : 1变0,0变1
 *  ^ 运算 : 相同为1,不同为1
 */
public class 位1的个数 {

    /**
     * 只要了解了“颠倒二进制”的核心思想，对于这题来说是真的容易。
     * 对于一个二进制数n，n%2的结果表示的是最后一位是否为1，
     * n/2表示的是二进制数整体往右挪了一位，此时最后一位为当前倒数第二位，
     * 以此类推，最后只要设置一个计数器变量j进行计数即可
     */
    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }

        return bits;
    }

    /**
     * 在二进制表示中，数字 n 中最低位的 1 总是对应n−1 中的 0 。
     * 因此，将 n 和 n−1 & 运算总是能把 n 中最低位的 1 变成 0 ，并保持其他位不变。
     *
     * 5
     * 0000.0000.0000.0101
     * 4
     * 0000.0000.0000.0100

     *
     *
     *
     *    0000.0000.0000.0101
     *    0000.0000.0000.0100
     *    5 & 4 = 0000.0000.0000.0100 , count=1,n = 0000.0000.0000.0100 (4)
     *
     *    0000.0000.0000.0100
     *    0000.0000.0000.0011
     *    4 & 3 = 0000.0000.0000.0000 ,n = 0,结束,所有count=2
     *
     */
    public static int hammingWeight2(int n) {
        int bits = 0;
        while (n != 0) {
            bits++;
            n &= n - 1;
        }
        return bits;
    }

    public static void main(String[] args) {

        System.out.println(3^8);
    }
}
