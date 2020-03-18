package string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author yuan
 * @date 2020/3/13 2:17 下午
 * https://leetcode-cn.com/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode/
 */
public class 最长公共前缀 {

    @Test
    public void test() {
        String[] arr1 = {"flower", "flow", "flight"};
        String[] arr2 = {"dog", "racecar", "car"};
        Assert.assertEquals("fl", longestCommonPrefix(arr1));
        Assert.assertEquals("", longestCommonPrefix(arr2));

    }

    // 从第一次数开始,利用indexOf方法查询在后续字符串中出现的位置,
    // 如果不是0,表示当前字符串不是公共前缀,将字符串减少一位,继续比较,直到等于0.
    // 若最后字符串为"",表示没有公共前缀,直接返回
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                //字符串去掉末位
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}
