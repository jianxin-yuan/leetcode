package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuan
 * @date 2020/3/29 11:01 上午
 * 多数元素
 * https://leetcode-cn.com/problems/majority-element/solution/du-le-le-bu-ru-zhong-le-le-ru-he-zhuang-bi-de-qiu-/
 */
public class MajorityElement {

    /**
     * hash计数
     */
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            if (count > nums.length / 2) {
                return num;
            }
            map.put(num, count);

        }
        return -1;
    }

    /**
     * 摩尔计数: 如果一个数组中存在众数,则这个数出现的次数大于其余所有数出现次数的和
     * 设置一个candidate = arr[0], count = 1
     * 遍历数组,如果num = candidate,则count + 1,否则count - 1,
     * 当count == 0时,将candidate更改为当前num,count改为1,遍历完成后的candidate就是所求的数
     */
    public static int majorityElement2(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 3};
        System.out.println(majorityElement2(arr));
    }

}
