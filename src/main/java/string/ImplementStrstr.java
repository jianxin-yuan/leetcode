package string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author yuan
 * @date 2020/3/12 3:07 下午
 * <p>
 * 实现strStr
 * <p>
 * https://leetcode-cn.com/problems/implement-strstr/solution/shi-xian-strstr-by-leetcode/
 */
public class ImplementStrstr {

    @Test
    public void test() {
        Assert.assertEquals(2, strStr("hello", "ll"));
        Assert.assertEquals(-1, strStr("aaaaa", "bba"));
        Assert.assertEquals(0, strStr("aaaaa", ""));
        Assert.assertEquals(0, strStr("a", "a"));
        Assert.assertEquals(4, strStr("mississippi", "issip"));
        Assert.assertEquals(9, strStr("mississippi", "pi"));
    }


    //定义2个指针,一个用于循环haystack,一个循环needle,KMP什么的太难
    public static int strStr(String haystack, String needle) {
        if ("".equals(needle) || haystack.equals(needle)) {
            return 0;
        }
        int j = 0;
        int i = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
                i++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == needle.length()) {
            return i - j;
        }
        return -1;
    }
}

