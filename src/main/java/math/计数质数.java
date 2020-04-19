package math;

/**
 * @author yuan
 * @date 2020/3/24 17:36
 * <p>
 * https://leetcode-cn.com/problems/count-primes/solution/ru-he-gao-xiao-pan-ding-shai-xuan-su-shu-by-labula/
 */
public class 计数质数 {

    //厄拉多塞筛法
    public static int countPrimes(int n) {
        boolean[] arr = new boolean[n];
        for (int i = 2; i < Math.sqrt(n); i++) {
            //如果一个数是素数,那么它的倍数不会是素数
            if (!arr[i]) {
                //筛选掉i的整数倍的数,2倍开始
                for (int j = 2 * i; j < n; j += i) {
                    arr[j] = true;
                }
            }
        }

        //最后统计数组中false的数量即可
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!arr[i]) count++;
        }
        return count;


    }


}
