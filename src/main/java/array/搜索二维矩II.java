package array;

/**
 * @author yuan
 * @date 2020/3/29 12:10 下午
 * <p>
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/solution/sou-suo-er-wei-ju-zhen-ii-by-leetcode-2/
 * <p>
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 */
public class 搜索二维矩II {

    /**
     * 思路:数组从上到下升序,从左到右升序,所以从左下角开始的元素,它右边的都比它大,上边的比它小.
     * 所以从左下角开始, if num > target,col++ ; if num < target,row--,直到边界还没找到就是false
     */
    public static boolean searchMatrix2(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[row].length) {
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

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        return helper(matrix, target, 0, 0);
    }

    public static boolean helper(int[][] matrix, int target, int i, int j) {
        if (matrix[i][j] == target) {
            return true;
        } else if (matrix[i][j] > target) {
            return false;
        } else {
            if (j + 1 < matrix[i].length) {
                if (helper(matrix, target, i, j + 1)) {
                    return true;
                }
            }

            if (i + 1 < matrix.length) {
                return helper(matrix, target, i + 1, j);
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(searchMatrix2(arr, 5));
        System.out.println(searchMatrix2(arr, 20));
    }
}
