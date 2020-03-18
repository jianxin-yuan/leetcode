package tree;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author yuan
 * @date 2020/3/18 13:35
 */
public class 验证二叉搜索树 {

    @Test
    public void test() {
        Integer[] arr = {5, 1, 4, null, null, 3, 6};
        TreeNode root = TreeNode.createTree(arr, 0);
        Assert.assertFalse(isValidBST(root));


        Integer[] arr2 = {2, 1, 3};
        TreeNode root2 = TreeNode.createTree(arr2, 0);
        Assert.assertTrue(isValidBST(root2));
    }

    public boolean isValidBST(TreeNode root) {
        if (root != null) {
            boolean res = true;
            if (root.left != null) {
                res = root.val > root.left.val;
            }
            if (root.right != null) {
                res &= root.val < root.right.val;
            }
            if (res) {
                return isValidBST(root.left) && isValidBST(root.right);
            }
            return false;
        }
        return true;
    }
}
