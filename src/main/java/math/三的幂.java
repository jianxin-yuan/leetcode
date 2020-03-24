package math;

/**
 * @author yuan
 * @date 2020/3/24 17:42
 */
public class 三的幂 {

    //3的幂一定能被3整除,一直除以3,最后如果是3的幂,则n==1,否则不是3的幂
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }

}
