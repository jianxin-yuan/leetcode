package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yuan
 * @date 2020/3/18 13:56
 */
public class BinaryTreeInorderTraversal {


    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;
        while (!s.isEmpty() || curr != null) {
            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}
