package other;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yuan
 * @date 2020/3/28 4:34 下午
 *
 * 回溯算法思想入门案列
 *   https://leetcode-cn.com/problems/n-queens/solution/hui-su-suan-fa-xiang-jie-by-labuladong/
 */
public class BackTrace {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> permute = permute(arr);
        for (List<Integer> integers : permute) {
            System.out.println(Arrays.toString(integers.toArray()));
        }
    }

    /**
     * 返回输入数字的全排列
     */
    static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track, res);
        return res;
    }

    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素
    // 结束条件：nums 中的元素全都在 track 中出现
    static void backtrack(int[] nums, LinkedList<Integer> track, List<List<Integer>> res) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i]))
                continue;
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track, res);
            // 取消选择
            track.removeLast();
        }
    }
}
