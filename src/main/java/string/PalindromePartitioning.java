package string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yuan
 * @date 2020/4/16 10:30
 * <p>
 *     分割回文串
 * https://leetcode-cn.com/problems/palindrome-partitioning/solution/hui-su-you-hua-jia-liao-dong-tai-gui-hua-by-liweiw/
 * 回溯算法
 */
public class PalindromePartitioning {

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        LinkedList<String> trace = new LinkedList<>();
        backTrace(s, 0, s.length(), trace, res);
        return res;
    }

    public static void backTrace(String str, int start, int len, LinkedList<String> trace, List<List<String>> res) {
        if (start == len) {
            res.add(new ArrayList<>(trace));
            return;
        }

        for (int i = start; i < len; i++) {
            if (!isPalindrome(str, start, i)) {
                continue;
            }
            trace.add(str.substring(start, i + 1));
            backTrace(str, i + 1, len, trace, res);
            trace.removeLast();
        }

    }

    public static boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start) == str.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

}
