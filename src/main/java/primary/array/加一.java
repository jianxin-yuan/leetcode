package primary.array;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2020/3/6 8:34 下午
 *
 * ref : https://leetcode-cn.com/problems/plus-one/solution/java-shu-xue-jie-ti-by-yhhzw/
 */
public class 加一 {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 3, 2, 1},
                {2, 9, 9},
                {9, 9, 9},
        };

        for (int[] i : arr) {
            System.out.println(Arrays.toString(plusOne(i)));
        }

    }

    public static int[] plusOne(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            //加1
            arr[i] += 1;
            //对10取模,只要没有进位,则还是等于原数,进位了就是10%10=0
            arr[i] %= 10;
            // 如果没有进位,直接返回,进位了,进行下一次循环
            // 类似低位数进位了,继续判断高位数,低位数没进位,就可以直接返回了
            if (arr[i] != 0) {
                return arr;
            }
        }

        //若循环结束都没有返回,说明是类似9,99,999这样的数,所有位都进位导致
        //所有需要返回10,100,1000这样的数,巧妙的做法,new 一个新数组,第一个数设置为1,其他自动补0
        arr = new int[arr.length + 1];
        arr[0] = 1;
        return arr;
    }
}
