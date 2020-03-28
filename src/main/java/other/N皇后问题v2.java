package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yuan
 * @date 2020/3/28 2:05 下午
 * <p>
 * https://leetcode-cn.com/problems/n-queens/solution/hui-su-suan-fa-xiang-jie-by-labuladong/
 */
public class N皇后问题v2 {

    public static void main(String[] args) {
        N皇后问题v2 a = new N皇后问题v2();
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
        //初始化,全部置为.
        char[][] arr = new char[n][n];
        for (char[] chars : arr) {
            Arrays.fill(chars, '.');
        }
        backtrace(0, arr, res);
        return res;
    }

    private void backtrace(int row, char[][] arr, List<List<String>> res) {
        if (row == arr.length) {
            res.add(arrToList(arr));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!isValid(row, i, arr)) {
                continue;
            }
            arr[row][i] = 'Q';
            backtrace(row + 1, arr, res);
            arr[row][i] = '.';
        }
    }

    private boolean isValid(int row, int col, char[][] arr) {
        //检查同一列
        for (int i = 0; i < row; i++) {
            if (arr[i][col] == 'Q') {
                return false;
            }
        }
        //检查右上角
        for (int i = row - 1, j = col + 1; i >= 0 && j < arr.length; i--, j++) {
            if (arr[i][j] == 'Q') {
                return false;
            }
        }
        //检查左上角
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (arr[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private List<String> arrToList(char[][] arr) {
        List<String> list = new ArrayList<>();
        for (char[] chars : arr) {
            list.add(new String(chars));
        }
        return list;
    }


}
