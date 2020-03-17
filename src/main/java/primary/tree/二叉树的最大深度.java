package primary.tree;

/**
 * @author yuan
 * @date 2020/3/17 15:55
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/solution/er-cha-shu-de-zui-da-shen-du-by-leetcode/
 */
public class 二叉树的最大深度 {

    //递归:树的深度等于1+max(max(left),max(right)),遍历每个节点,可以得到每颗子树的最大深度,算出来加上root节点即可.
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }


}
