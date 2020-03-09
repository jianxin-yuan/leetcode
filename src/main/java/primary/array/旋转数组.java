package primary.array;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2020/3/5 1:33 下午
 * ref : https://leetcode-cn.com/problems/rotate-array/solution/xuan-zhuan-shu-zu-by-leetcode/
 * <p>
 * 这个方法基于这个事实：当我们旋转数组 k 次， k\%nk%n 个尾部元素会被移动到头部，剩下的元素会被向后移动。
 * <p>
 * 在这个方法中，我们首先将所有元素反转。然后反转前 k 个元素，再反转后面 n-kn−k 个元素，就能得到想要的结果。
 * <p>
 * 假设 n=7n=7 且 k=3k=3 。
 * <p>
 * 原始数组                  : 1 2 3 4 5 6 7
 * 反转所有数字后             : 7 6 5 4 3 2 1
 * 反转前 k 个数字后          : 5 6 7 4 3 2 1
 * 反转后 n-k 个数字后        : 5 6 7 1 2 3 4 --> 结果
 */
public class 旋转数组 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 9;
        // 翻转整个数组
        reverse(arr, 0, arr.length - 1);
        // 翻转前k%arr.length个元素
        reverse(arr, 0, k % arr.length - 1);
        // 翻转后续元素
        reverse(arr, k % arr.length, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
