package array;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2020/2/19 1:36 下午
 * 删除排序数组中的重复项
 * ref : https://github.com/MisterBooo/LeetCodeAnimation/blob/master/notes/LeetCode%E7%AC%AC26%E5%8F%B7%E9%97%AE%E9%A2%98%EF%BC%9A%E5%88%A0%E9%99%A4%E6%8E%92%E5%BA%8F%E6%95%B0%E7%BB%84%E4%B8%AD%E7%9A%84%E9%87%8D%E5%A4%8D%E9%A1%B9.md
 * <p>
 * 使用快慢指针来记录遍历的坐标。
 * <p>
 * 开始时这两个指针都指向第一个数字
 * 如果两个指针指的数字相同，则快指针向前走一步
 * 如果不同，将快指针的对应值复制到慢指针位置,同时两个指针都向前走一步
 * 当快指针走完整个数组后，慢指针当前的坐标加1就是数组中不同数字的个数
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {

        //int[] nums = {1, 1, 2};
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len = removeDuplicates(nums);

        System.out.println(Arrays.toString(Arrays.copyOf(nums, len)));

    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int i = 0, j = 0;
        while (i < nums.length) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
            i++;
        }

        return j + 1;
    }
}

