package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yuan
 * @date 2020/3/7 8:05 下午
 * <p>
 * ref :https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-2/
 */
public class 两数之和 {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int sum = 17;
        int[] result = twoSum1(arr, sum);
        int[] result2 = twoSum2(arr, sum);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(result2));


        //从有序数组中找出2数之和
        Arrays.sort(arr);
        int[] result3 = twoSum3(arr, sum);
        System.out.println(Arrays.toString(result3));
    }

    // 暴力破解
    public static int[] twoSum1(int[] arr, int sum) {
        int[] result = new int[2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[i] + arr[j] == sum) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }


    //利用hast表
    public static int[] twoSum2(int[] arr, int sum) {
        int[] result = new int[2];
        //计算出sum和每个数的差值.放入map,然后找出值为差值的数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                result[0] = map.get(arr[i]);
                result[1] = i;
                return result;
            }

            map.put(sum - arr[i], i);
        }
        return result;
    }

    // 同样从数组中找2数之和,不同点是数组有序
    // 此时,可利用2分查找的思想,使用2个指针不断向中间移动,如果头指针和尾指针之和大于sum,则尾指针移动,小于,则头指针移动
    public static int[] twoSum3(int[] arr, int sum) {
        int[] result = new int[2];
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] > sum) {
                right--;
            } else if (arr[left] + arr[right] < sum) {
                left++;
            } else {
                result[0] = left;
                result[1] = right;
                break;
            }
        }

        return result;
    }


}
