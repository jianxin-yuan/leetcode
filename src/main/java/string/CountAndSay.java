package string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author yuan
 * @date 2020/3/12 4:22 下午
 *
 * 外观数列
 */
public class CountAndSay {

    @Test
    public void test() {
        Assert.assertEquals("1211", countAndSay(4));
        Assert.assertEquals("111221", countAndSay(5));
        Assert.assertEquals("312211", countAndSay(6));
        Assert.assertEquals("13112221", countAndSay(7));
    }


    //规律: 上一次数推出下一个数
    //1       1个1==11 ↓
    //11      2个1==21 ↓
    //21      1个2,1个1==1211 ↓
    //1211    1个1,1个2,2个1=111221 ↓
    //111221  3个1,2个2,1个1= 312211 ↓
    //312211  1个3,1个1,2个2,2个1=13112221 ↓
    //13112221
    public static String countAndSay(int n) {
        String str = "1";
        for (int i = 1; i < n; i++) {
            int count = 1;
            char ch = str.charAt(0);
            StringBuilder builder = new StringBuilder();
            for (int j = 1; j < str.length(); j++) {
                if (str.charAt(j) == ch) {
                    count++;
                } else {
                    builder.append(count).append(ch);
                    ch = str.charAt(j);
                    count = 1;
                }
            }
            builder.append(count).append(ch);
            str = builder.toString();
        }

        return str;
    }
}
