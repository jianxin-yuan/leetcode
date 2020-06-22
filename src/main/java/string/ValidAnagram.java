package string;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2020/3/10 2:19 下午
 *
 * 有效的字母异位词
 * https://leetcode-cn.com/problems/valid-anagram/solution/you-xiao-de-zi-mu-yi-wei-ci-by-leetcode/
 * <p>
 * 字母异位词:它是指两个字符串所包含的字母的出现次数都相同,只是顺序不一样
 */
public class ValidAnagram {

    @Test
    public void test() {
        Assert.assertTrue(isAnagram2("anagram", "nagaram"));
        Assert.assertFalse(isAnagram2("rat", "car"));
        Assert.assertFalse(isAnagram2("ab", "a"));
    }


    // 排序法: 将2个字符串排序,比较每个字符是否相同
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    //维护一个数组,遍历字符串,s -'a' ++ , t-'a' --,当2个字符串是异位词时,最终++和--会抵消,最后判断数组是否中的数是否都为0即可
    public boolean isAnagram2(String s, String t) {
        //长度判断
        if (s.length() != t.length()) {
            return false;
        }

        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            //s在各位置上+
            arr[s.charAt(i) - 'a']++;
            //t在各位置上-
            arr[t.charAt(i) - 'a']--;
        }

        for (int i : arr) {
            //判断如果有不是0的,表示2个字符串中字符出现的次数不同或字符不同
            if (i != 0) {
                return false;
            }
        }

        return true;

    }
}
