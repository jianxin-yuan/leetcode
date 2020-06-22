package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yuan
 * @date 2020/3/18 9:53 下午
 * <p>
 * 对称二叉树
 * <p>
 * https://leetcode-cn.com/problems/symmetric-tree/solution/dui-cheng-er-cha-shu-by-leetcode/
 */
public class SymmetricTree {

    //迭代:利用BFS思想,每次往队里加入同一层级元素,lef和right交叉加入队里,那么队列中每相邻2个元素相同
    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        //加2个root
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null) return false;
            if (node1.val != node2.val) return false;
            queue.add(node1.left);
            queue.add(node2.right);
            queue.add(node1.right);
            queue.add(node2.left);
        }
        return true;
    }


    //递归
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode r1, TreeNode r2) {
        //都为null
        if (r1 == null && r2 == null) return true;
        //只有一个为null
        if (r1 == null || r2 == null) return false;
        //判断r1=r2 && r1.left = r2.right && r1.right = r2.left
        return (r1.val == r2.val)
                && isMirror(r1.left, r2.right)
                && isMirror(r1.right, r2.left);
    }
}
