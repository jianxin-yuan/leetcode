package primary.array;

import java.util.HashMap;

/**
 * @author yuan
 * @date 2020/3/7 8:40 下午
 *
 * ref : https://leetcode-cn.com/problems/valid-sudoku/solution/36-jiu-an-zhao-cong-zuo-wang-you-cong-shang-wang-x/
 */
public class 有效的数独 {
    public static void main(String[] args) {
        char[][][] arr = {
                {
                        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                },
                {
                        {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                }
        };

        for (char[][] chars : arr) {
            System.out.println(isValidSudoku(chars));
        }
        System.out.println("====");
        for (char[][] chars : arr) {
            System.out.println(isValidSudoku2(chars));
        }
    }

    // 需要判断3个方面,每列/每行/每个3x3网格.所以需要3个存放map的数组,对应 行/列/小网格
    // 判断是否是同一个3x3网格的关键,利用 box_index = (row/3)*3 + column/3  算出每个位置所对应的3x3小网格index(0...8)
    // 遍历9x9网格,将每个数出现的位置利用hashMap保存(value,count),当出现在同列/同行/同个3x3网格中出现,表示不符合,遍历完全部数没退出表示符合
    public static boolean isValidSudoku(char[][] arr) {
        // 创建3个数组,用来保存行/列/box的每个数出现次数映射关系
        HashMap<Character, Integer>[] rows = new HashMap[9];
        HashMap<Character, Integer>[] columns = new HashMap[9];
        HashMap<Character, Integer>[] subBoxes = new HashMap[9];
        // 数组初始化
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            columns[i] = new HashMap<>();
            subBoxes[i] = new HashMap<>();
        }


        //遍历9x9
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                if (arr[i][j] == '.') {
                    continue;
                }


                //判断行
                if (rows[i].containsKey(arr[i][j])) {
                    return false;
                } else {
                    rows[i].put(arr[i][j], 1);
                }

                //判断列
                if (columns[j].containsKey(arr[i][j])) {
                    return false;
                } else {
                    columns[j].put(arr[i][j], 1);
                }

                //判断每个3x3
                int boxIndex = (i / 3) * 3 + j / 3;
                if (subBoxes[boxIndex].containsKey(arr[i][j])) {
                    return false;
                } else {
                    subBoxes[boxIndex].put(arr[i][j], 1);
                }


            }
        }
        return true;
    }


    // 改进: 将hashMap数组用boolean数组代替
    public static boolean isValidSudoku2(char[][] arr) {
        // 创建3个数组,用来保存行/列/box的每个数是否出现过.默认false表示为出现过
        boolean[][] rows = new boolean[9][9];
        boolean[][] columns = new boolean[9][9];
        boolean[][] subBoxes = new boolean[9][9];


        //遍历9x9
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == '.') {
                    continue;
                }

                //计算在3x3中的位置坐标0...8,当着横坐标
                int box_index = (i / 3) * 3 + j / 3;

                // 将每个小方格中的值当着一个竖坐标,当出现值相同时,就会有true出现
                // * 方格中的数为0~9的char字符,同'1'相减,正好是0~8,可用作坐标
                // 在rows / subBoxes中充当竖坐标,在columns中充当横坐标
                int value_index = arr[i][j] - '1';

                if (rows[i][value_index] || columns[value_index][j] || subBoxes[box_index][value_index]) {
                    return false;
                }

                // 设置值,表示
                rows[i][value_index] = true;
                columns[value_index][j] = true;
                subBoxes[box_index][value_index] = true;
            }
        }
        return true;
    }

}
