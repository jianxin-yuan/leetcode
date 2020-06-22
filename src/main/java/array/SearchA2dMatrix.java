package array;

import java.util.Arrays;

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

        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                //因为每一个都是有序的,所以对每行可以使用二分查找进一步加快搜索速度
                //return binarySearch(matrix[row], target);
                return Arrays.binarySearch(matrix[row], target) != -1;
            } else {
                row++;
            }
        }
        return false;
    }

    public static boolean binarySearch(int[] arr, int target) {
        int left = 0;
        //因为最后一个已经判断过了,这里不用再次判断
        int right = arr.length - 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] > target) {
                right = --mid;
            } else {
                left = ++mid;
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
        System.out.println(searchMatrix2(arr, 3));
        System.out.println(searchMatrix2(arr, 31));


        System.out.println(Arrays.binarySearch(arr[0], 3));
    }
}
