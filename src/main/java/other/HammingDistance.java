package other;

/**
 * @author yuan
 * @date 2020/3/27 10:06 下午
 *
 * 汉明距离
 * https://leetcode-cn.com/problems/hamming-distance/solution/yi-ming-ju-chi-by-leetcode/
 */
public class HammingDistance {

    //利用 ^ 运算相同为0.不同为1,计算一个结果,然后统计这个结果二进制中1的个数
    public int hammingDistance2(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    //手写统计
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int count = 0;
        while (z != 0) {
            if ((z & 1) == 1) {
                count++;
            }
            z >>= 1;
        }
        return count;
    }


}
