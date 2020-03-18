package tree;

import java.util.Stack;

/**
 * @author yuan
 * @date 2020/3/18 13:35
 * https://leetcode-cn.com/problems/validate-binary-search-tree/solution/yan-zheng-er-cha-sou-suo-shu-by-leetcode/
 */
public class 验证二叉搜索树 {

    //利用中序遍历的特性: 左子树-根-右子树的顺序,对二叉搜索树而言.左节点值 < 根节点 < 右节点 , 所以遍历二叉树,判断每一个节点都比前一个节点小
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prevNode = null;

        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            if (prevNode != null && node.val <= prevNode.val) return false;
            prevNode = node;
            node = node.right;
        }
        return true;
    }
}
