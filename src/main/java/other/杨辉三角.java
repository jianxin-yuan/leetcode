package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yuan
 * @date 2020/3/28 10:34 上午
 *
 * https://leetcode-cn.com/problems/pascals-triangle/solution/javadi-gui-dong-tai-gui-hua-by-jeromememory/
 *
 * 规律: 每行元素个数等于行数,首尾都是1
 *      从第三行开始,除了首尾数外,其余的数都等于上一行的对应位置加上后一位的数
 */
public class 杨辉三角 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if (numRows == 0) {
            return list;
        }

        if (numRows == 1) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            list.add(row);
            return list;
        }

        list = generate(numRows - 1);
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 0; i < numRows - 2; i++) {
            row.add(list.get(numRows - 2).get(i) + list.get(numRows - 2).get(i + 1));
        }

        row.add(1);
        list.add(row);
        return list;
    }

    /**
     * 1
     * 1 1
     * 1 2 1
     * 1 3 3 1
     * 1 4 6 4 1
     */
    public static List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if (numRows == 0) {
            return list;
        }

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            int j;
            for (j = 0; j < i - 1; j++) {
                row.add(list.get(i - 1).get(j) + list.get(i - 1).get(j + 1));
            }

            if (i != 0) {
                row.add(1);
            }
            list.add(row);
        }
        return list;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = generate(9);
        //List<List<Integer>> lists = generate2(9);
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
