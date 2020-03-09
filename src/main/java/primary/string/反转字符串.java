package primary.string;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2020/3/9 1:28 下午
 *
 *  https://leetcode-cn.com/problems/reverse-string/solution/fan-zhuan-zi-fu-chuan-by-leetcode/
 */
public class 反转字符串 {
    public static void main(String[] args) {
        char[][] arr = {
                {'h', 'e', 'l', 'l', 'o'},
                {'H', 'a', 'n', 'n', 'a', 'h'}
        };

        for (char[] chars : arr) {
            reverseString(chars);
            System.out.println(Arrays.toString(chars));
        }
    }

    // 定义2个指针,i++,j--,互换位置
    public static void reverseString(char[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
