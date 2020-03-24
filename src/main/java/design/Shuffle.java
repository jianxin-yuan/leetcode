package design;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author yuan
 * @date 2020/3/24 15:49
 *
 * https://leetcode-cn.com/problems/shuffle-an-array/solution/da-luan-shu-zu-by-leetcode/
 */
public class Shuffle {
    //保存原始数据
    private int[] origin;

    public Shuffle(int[] nums) {
        this.origin = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return origin;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int[] arr = origin.clone();
        for (int i = 0; i < arr.length; i++) {
            int j = ThreadLocalRandom.current().nextInt(i, arr.length);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }
}
