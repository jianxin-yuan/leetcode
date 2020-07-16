package array;

/**
 * @author yuan
 * @date 2020/3/29 12:48 下午
 * <p>
 * 搜索二维矩阵
 * <p>
 * https://leetcode-cn.com/problems/search-a-2d-matrix/submissions/
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 * <p>
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 */
public class SearchA2dMatrix {

    /**
     * 从右上角开始,左边的都比它小,下面的都比它大,
     * if num > target , col-- ; if num < target, row ++
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }


    public static boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col <= matrix[row].length - 1) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                row--;
            } else {
                col++;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] arr = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println(searchMatrix(arr, 3));
        System.out.println(searchMatrix(arr, 31));
        System.out.println("====");
        System.out.println(searchMatrix(arr, 3));
        System.out.println(searchMatrix(arr, 31));
    }
}
