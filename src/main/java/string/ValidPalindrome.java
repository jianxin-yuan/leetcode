package string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author yuan
 * @date 2020/3/11 2:08 下午
 *
 * 验证回文串
 * <p>
 * https://leetcode-cn.com/problems/valid-palindrome/solution/java-shuang-zhi-zhen-jie-fa-by-liuguili/
 * <p>
 * 回文字符串:"回文串"是一个正读和反读都一样的字符串，比如"level"或者"noon"等等就是回文串
 */
public class ValidPalindrome {
    @Test
    public void test() {
        Assert.assertFalse(isPalindrome("race a car"));
        Assert.assertTrue(isPalindrome("A man, a plan, a canal: Panama"));
        Assert.assertTrue(isPalindrome("level"));

    }

    //双指针一头一尾向中间靠拢判断每个字符是否相同,跳过空格,标点符号等
    public static boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; ) {

            // 判断不是字符或数字跳过
            if (!Character.isLetterOrDigit(chars[i])) {
                i++;
                continue;
            }

            if (!Character.isLetterOrDigit(chars[j])) {
                j--;
                continue;
            }

            //相等
            if (Character.toLowerCase(chars[i]) == Character.toLowerCase(chars[j])) {
                i++;
                j--;
                continue;
            }
            return false;
        }
        return true;
    }
}
