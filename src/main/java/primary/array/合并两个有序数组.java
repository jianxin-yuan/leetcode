package primary.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2020/3/16 11:33
 * https://leetcode-cn.com/problems/merge-sorted-array/solution/he-bing-liang-ge-you-xu-shu-zu-by-leetcode/
 */
public class 合并两个有序数组 {

    @Test
    public void test() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge2(nums1, 3, nums2, 3);

        int[] result = {1, 2, 2, 3, 5, 6};
        Assert.assertArrayEquals(nums1, result);
    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //使用临时数组保存nums1,循环nums1和nums2,依次加入nums1
        int[] temp = Arrays.copyOfRange(nums1, 0, m);
        int index = 0;
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (temp[i] < nums2[j]) {
                nums1[index++] = temp[i++];
            } else {
                nums1[index++] = nums2[j++];
            }
        }

        if (i < m) {
            System.arraycopy(temp, i, nums1, index, m - i);
        }
        if (j < n) {
            System.arraycopy(nums2, j, nums1, index, n - j);
        }
    }

    //从数组末尾开始遍历,大的放后面
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[index--] = nums1[i--];
            } else {
                nums1[index--] = nums2[j--];
            }
        }
        //将nums2中剩余的元素加入nums1
        if (j >= 0) {
            System.arraycopy(nums2, 0, nums1, 0, j + 1);
        }
    }
}
