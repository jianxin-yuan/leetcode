package dynamicprogramming;

/**
 * @author yuan
 * @date 2020/3/19 11:22
 */
public class 爬楼梯 {

    /**
     * 思路1:动态规划
     * 用f(n)表示到达第n阶台阶的方法数目，初始化f(1)=1,f(2)=2，表示到达第1阶台阶共有1种方法，到达第2阶台阶共有两种方法。
     * 由于每次只能登1个或2个台阶，那么登第三个台阶时，最后一步一定是从第二个台阶（3-1）跨一步，或者从第一个台阶(3-2)跨两步，这二者之一，
     * 那么到达第三个台阶的方法数目其实就是到达第二个台阶的方法数目加上到达第一个台阶的方法数目，即f(3)=f(1)+f(2)。后面的以此类推
     * <p>
     * 令 dp[i] 表示能到达第 i 阶的方法总数：
     * dp[i]=dp[i-1]+dp[i-2]
     */
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }


    /**
     * 思路2:计算斐波那契数
     * 利用斐波那契数列:1,1,2,3,5,8,13
     * 可以看出从第二个数开始和我们的算法f(n) = f(n-1) + f(n-2) 一样
     */
    public int climbStairs2(int n) {
        if (n == 1) return 1;
        int a = 1;
        int b = 2;
        for (int i = 3; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
