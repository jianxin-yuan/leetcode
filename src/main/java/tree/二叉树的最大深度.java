package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yuan
 * @date 2020/3/17 15:55
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/solution/er-cha-shu-de-zui-da-shen-du-by-leetcode/
 */
public class 二叉树的最大深度 {

    //递归:树的深度等于1+max(max(left),max(right)),遍历每个节点,可以得到每颗子树的最大深度,算出来加上root节点即可.
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    //BFS思路: 利用队列,每次循环队列中的元素,加入左右子树,每加一次depth++
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            depth++;// 2
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                //从队列中移除一个头元素
                TreeNode treeNode = queue.poll();
                //加入左右子树
                if (treeNode.left != null) queue.add(treeNode.left);
                if (treeNode.right != null) queue.add(treeNode.right);
            }
        }
        return depth;
    }


}
