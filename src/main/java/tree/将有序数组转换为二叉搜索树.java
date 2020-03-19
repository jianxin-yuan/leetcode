package tree;

/**
 * @author yuan
 * @date 2020/3/18 10:21 下午
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/solution/jiang-you-xu-shu-zu-zhuan-huan-wei-er-cha-sou-s-15/
 */
public class 将有序数组转换为二叉搜索树 {
    int[] arr;

    //每次选择中间节点作为root节点
    public TreeNode sortedArrayToBST(int[] nums) {
        this.arr = nums;
        return helper(0, nums.length - 1);
    }

    public TreeNode helper(int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = helper(left, mid - 1);
        node.right = helper(mid + 1, right);
        return node;
    }
}
