package array;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2020/3/8 9:23 下午
 *
 * ref: https://leetcode-cn.com/problems/rotate-image/solution/yi-ci-xing-jiao-huan-by-powcai/
 */
public class 旋转图像 {
    public static void main(String[] args) {

        int[][][] arr = {
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}

                },
                {
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}
                }
        };
        for (int[][] ints : arr) {
            rotate(ints);
            for (int[] anInt : ints) {
                System.out.println(Arrays.toString(anInt));
            }

            System.out.println("======");
        }

    }

    //查找规律,发现对任意坐标(i,j),顺时针旋转90度的坐标转移规律为
    // (i,j) --> (j,n-i-1) --> (n-i-1,n-j-1) --> (n-j-1,i) - (i,j)
    public static void rotate(int[][] arr) {
        int n = arr.length;
        //关于i,j的边界条件说明:
        //  n=3时,需要遍历1,2这2个数,此时max(i)=0,max(j)=1
        //  n=4时,需要遍历1,2,3,6这4个数,此时max(i)=1,max(j)=2
        // 发现i,j边界条件为: max(i) = n /2 , max(j) = n-i-j,同时j>=i,不然会重复旋转已旋转过的元素
        // 所以 i = 0;i < n/2; j=i;j<n-i-1
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[n - j - 1][i];
                arr[n - j - 1][i] = arr[n - i - 1][n - j - 1];
                arr[n - i - 1][n - j - 1] = arr[j][n - i - 1];
                arr[j][n - i - 1] = temp;

            }
        }
    }
}
