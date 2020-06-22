package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yuan
 * @date 2020/3/18 11:46
 *
 * 二叉树的层次遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/
 */
public class BinaryTreeLevelOrderTraversalIi {

    public static void main(String[] args) {
        Integer[] arr = {3, 9, 20, null, null, 15, 7};
        TreeNode root = TreeNode.createTree(arr, 0);
        List<List<Integer>> lists = levelOrder(root);

        System.out.println(Arrays.toString(lists.toArray()));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
            res.add(list);
        }
        return res;
    }
}
