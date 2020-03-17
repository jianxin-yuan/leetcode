package primary.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author yuan
 * @date 2020/3/17 15:54
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }


    public static TreeNode buildTree(Integer[] array) {
        List<TreeNode> nodeList = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            nodeList.add(new TreeNode(array[i]));
        }

        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            nodeList.get(parentIndex).left = nodeList.get(parentIndex * 2 + 1);
            nodeList.get(parentIndex).right = nodeList.get(parentIndex * 2 + 2);
        }
        int lastparentIndex = array.length / 2 - 1;
        nodeList.get(lastparentIndex).left = nodeList.get(lastparentIndex * 2 + 1);
        if (array.length % 2 == 1)
            nodeList.get(lastparentIndex).right = nodeList.get(lastparentIndex * 2 + 2);

        return nodeList.get(0);
    }


    //深度优先遍历
    public static void depth() {

    }

    //广度优先遍历
    public static void breadth() {

    }

    //输入:{1,2,3,4,5,6,7,8,9}
    // 先序遍历输出-递归
    //输出: 1 ,2 ,4 ,8 ,9 ,5 ,3 ,6 ,7
    public static void preOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ,");
            preOrder(node.left);
            preOrder(node.right);

        }
    }

    // 先序遍历-非递归形式
    public static void preOrderNoRecursion(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + " ,");
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
    }

    // 中序遍历输出-递归
    //输出: 8 ,4 ,9 ,2 ,5 ,1 ,6 ,3 ,7
    public static void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.val + " ,");
            inOrder(node.right);
        }
    }

    // 中序遍历-非递归形式
    public static void inOrderNoRecursion(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
    }

    // 后序遍历输出-递归
    //输出: 8 ,9 ,4 ,5 ,2 ,6 ,7 ,3 ,1
    public static void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.val + " ,");

        }
    }

    // 后序遍历-非递归形式
    public static void postOrderNoRecursion(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
            System.out.print(node.val + " ,");
        }
    }


    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        TreeNode root = TreeNode.buildTree(arr);
        System.out.print("先序遍历:");
        TreeNode.preOrder(root);
        System.out.println();


        System.out.print("中序遍历:");
        TreeNode.inOrder(root);
        System.out.println();

        System.out.print("后序遍历:");
        TreeNode.postOrder(root);
        System.out.println();


        System.out.print("先序遍历-非递归:");
        TreeNode.preOrderNoRecursion(root);
        System.out.println();

        System.out.print("中序遍历-非递归:");
        TreeNode.inOrderNoRecursion(root);
        System.out.println();

        System.out.print("后序遍历-非递归:");
        TreeNode.postOrderNoRecursion(root);
        System.out.println();


    }
}
