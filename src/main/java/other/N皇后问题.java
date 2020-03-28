package other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yuan
 * @date 2020/3/28 2:05 下午
 * <p>
 * https://leetcode-cn.com/problems/n-queens/solution/hui-su-suan-fa-xiang-jie-by-labuladong/
 */
public class N皇后问题 {

    public static void main(String[] args) {
        N皇后问题 a = new N皇后问题();
        List<List<String>> lists = a.solveNQueens(4);
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println("====");
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        LinkedList<String> row = new LinkedList<>();
        backtrace(n, row, res);
        return res;
    }

    private void backtrace(int n, LinkedList<String> row, List<List<String>> res) {
        if (n == row.size()) {
            res.add(new ArrayList<>(row));
            return;
        }

        for (int i = 0; i < n; i++) {
            String s = writeQ(n, i);
            //判断条件
            if (!isValid(i, s, row)) {
                continue;
            }
            //加入选择
            row.add(s);
            //进入下一层
            backtrace(n, row, res);
            //撤销选择
            row.removeLast();
        }
    }

    private boolean isValid(int i, String s, List<String> row) {
        //循环row中的每个string,判断Q的位置不能同一列,同一行,任意斜线
        int index = s.indexOf("Q");
        int rowIndex = row.size();

        for (String s1 : row) {
            int j = row.indexOf(s1);
            int gap = rowIndex - j;

            int qIndex = s1.indexOf("Q");
            //同一列
            if (index == qIndex) {
                return false;
            }
            //任意对角线
            if (qIndex + gap == index || qIndex - gap == index) {
                return false;
            }
        }
        return true;
    }

    private String writeQ(int n, int i) {
        StringBuilder str = new StringBuilder();
        while (n-- > 0) {
            if (n == i) {
                str.append("Q");
            } else {
                str.append(".");
            }
        }
        return str.toString();
    }
}
