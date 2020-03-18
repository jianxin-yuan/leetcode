package array;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2020/3/6 8:48 下午
 *
 * ref: https://leetcode-cn.com/problems/move-zeroes/solution/dong-hua-yan-shi-283yi-dong-ling-by-wang_ni_ma/
 */
public class 移动零 {
    public static void main(String[] args) {

        int[] arr = {0, 1, 0, 3, 12};
        moveZero(arr);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 类似快慢指针,当为0是,快指针移动,不为0是,快慢指针交换值,同时前移一位
     *
     * @param arr
     */
    public static void moveZero(int[] arr) {
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        //int i = 0, j = 0;
        //while (j < arr.length) {
        //    if (arr[j] == 0) {
        //        j++;
        //    } else {
        //        int temp = arr[i];
        //        arr[i] = arr[j];
        //        arr[j] = temp;
        //        i++;
        //        j++;
        //    }
        //}
    }
}
