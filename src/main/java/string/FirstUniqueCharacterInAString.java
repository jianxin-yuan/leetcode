package string;


import org.junit.Assert;
import org.junit.Test;

/**
 * @author yuan
 * @date 2020/3/10 1:26 下午
 *
 * 字符串中的第一个唯一字符
 * <p>
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/solution/liang-ci-bian-li-zi-fu-chuan-qiu-de-wei-yi-zi-fu-b/
 * <p>
 * //注意事项：您可以假定该字符串只包含小写字母。题目限定为小写字母.所有只需要维护一个26长度的数组
 */

public class FirstUniqueCharacterInAString {



    @Test
    public void test() {
        Assert.assertEquals(0, firstUniqChar2("leetcode"));
        Assert.assertEquals(2, firstUniqChar2("loveleetcode"));
        Assert.assertEquals(-1, firstUniqChar2("aabbcc"));
    }

    //利用数组维护26个字母出现的次数,重点是利用 char-'a'的值作为数组下标0...25
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        // 计算字符串中每个字符出现的次数
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }

        //遍历字符串,找出第一个单次的字符
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    //利用2个方法,indexOf, lastIndexOf,计算第一次出现的index和最后一次出现的index,
    // 当2个index一样说明只出现了一次
    public int firstUniqChar2(String s) {
       int index = s.length();
        // range = [a...z]小写字母
        for (int i = 'a'; i <= 'z'; i++) {
            int firstIndex = s.indexOf(i);
            int lastIndex = s.lastIndexOf(i);
            if (firstIndex == lastIndex && firstIndex != -1) {
                index = Math.min(index, firstIndex);
            }
        }

        //index == s.length,说明没有只出现一次的字符
        if (index == s.length()) {
            return -1;
        }else{
            return index;
        }
    }
}
