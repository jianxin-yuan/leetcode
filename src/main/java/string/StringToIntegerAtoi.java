package string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author yuan
 * @date 2020/3/11 2:30 下午
 *
 * 字符串转换整数
 * https://leetcode-cn.com/problems/string-to-integer-atoi/solution/jin-liang-bu-shi-yong-ku-han-shu-nai-xin-diao-shi-/
 */
public class StringToIntegerAtoi {

    @Test
    public void test() {
        Assert.assertEquals(42, myAtoi("42"));
        Assert.assertEquals(-42, myAtoi("   -42"));
        Assert.assertEquals(4193, myAtoi("4193 with words"));
        Assert.assertEquals(0, myAtoi("words and 987"));
        Assert.assertEquals(-2147483648, myAtoi("-91283472332"));
    }

    //字符串转int
    public static int myAtoi(String str) {
        //trim
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }

        char[] chars = str.toCharArray();

        int sign = 1;
        int index = 0;
        if (chars[0] == '+') {
            index++;
        } else if (chars[0] == '-') {
            index++;
            sign = -1;
        }

        int result = 0;
        for (int i = index; i < chars.length; i++) {
            if (chars[i] > '9' || chars[i] < '0') {
                return result * sign;
            }

            //题目中说：环境只能存储 32 位大小的有符号整数，因此，需要提前判断乘以 10 以后是否越界
            // ,判断result > Integer.MAX_VALUE / 10表示后续result*10是否会溢出
            // result == Integer.MAX_VALUE / 10 && (chars[i]-'0')>7 表示后续result * 10 + (chars[i] - '0')是否会溢出
            // int 最大值为2147483647,个位数7,判断也可写成 (chars[i] - '0') > Integer.MAX_VALUE % 10
            if (sign == 1) {
                if (result > Integer.MAX_VALUE / 10
                        || (result == Integer.MAX_VALUE / 10 && (chars[i] - '0') > 7)) {
                    return Integer.MAX_VALUE;
                }
            }

            // int最小值为-2147483648,判断也可写成 (chars[i] - '0') > -(Integer.MIN_VALUE % 10)
            if (sign == -1) {
                if (result > Integer.MAX_VALUE / 10
                        || (result == Integer.MAX_VALUE / 10 && (chars[i] - '0') > 8)) {
                    return Integer.MIN_VALUE;
                }
            }
            result = result * 10 + (chars[i] - '0');
        }
        return result * sign;
    }
}
