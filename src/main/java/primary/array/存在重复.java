package primary.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author yuan
 * @date 2020/3/5 2:14 下午
 * <p>
 * ref : https://leetcode-cn.com/problems/contains-duplicate/solution/
 * <p>
 * 解1: 先对数组排序,如果有重复的元素必定是在相邻位置
 * 解2: 利用hash表来判断.如hashSet,循环数组,利用set.add()方法.如果返回false,表示插入失败,说明有重复元素
 */
public class 存在重复 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 1};
        int[] arr2 = {1, 2, 3, 4};
        int[] arr3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(containsDuplicate(arr1));
        System.out.println(containsDuplicate(arr2));
        System.out.println(containsDuplicate(arr3));

        System.out.println("==========");
        System.out.println(containsDuplicate2(arr1));
        System.out.println(containsDuplicate2(arr2));
        System.out.println(containsDuplicate2(arr3));
    }

    public static boolean containsDuplicate(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsDuplicate2(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (!set.add(i)) {
                return true;
            }
        }
        return false;
    }
}
