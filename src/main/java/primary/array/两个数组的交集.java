package primary.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author yuan
 * @date 2020/3/5 5:01 下午
 * <p>
 * ref : https://leetcode-cn.com/problems/intersection-of-two-arrays/solution/liang-ge-shu-zu-de-jiao-ji-by-leetcode/
 */
public class 两个数组的交集 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 2, 3};
        int[] arr2 = {11, 22, 33, 44, 2, 2, 55};

        //Object[] result = intersection(arr1, arr2);
        int[] result = intersection2(arr1, arr2);
        System.out.println(Arrays.toString(result));
    }

    /**
     * 利用hashSet特性,retainAll方法可直接获取2个集合的交集
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public static Object[] intersection(Integer[] arr1, Integer[] arr2) {

        Set<Integer> set1 = new HashSet<>(Arrays.asList(arr1));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(arr2));

        set1.retainAll(set2);

        return set1.toArray();
    }


    /**
     * 先将2个数组排序,然后从头开始遍历,找到相同的元素就加入新数组中
     * @param arr1
     * @param arr2
     * @return
     */
    public static int[] intersection2(int[] arr1, int[] arr2) {
        //数组排序
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int i = 0; //arr1的指针
        int j = 0; //arr2的指针
        int num = 0;//返回结果的指针
        int[] result = new int[Math.max(arr1.length, arr2.length)];
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] > arr2[j]) {
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else {
                result[num++] = arr1[i];
                i++;
                j++;
            }
        }

        return Arrays.copyOf(result, num );

    }
}
