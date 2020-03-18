package tree;

import java.util.LinkedList;
import java.util.Queue;
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


    //创建一个二叉树,i=0表示root
    public static TreeNode createTree(Integer[] arr, int i) {
        if (i >= arr.length || arr[i] == null)
            return null;
        TreeNode root = new TreeNode(arr[i]);
        root.left = createTree(arr, 2 * i + 1);
        root.right = createTree(arr, 2 * i + 2);
        return root;
    }


    //广度优先遍历(层级遍历)
    public static void breadth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ,");
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }

    //深度优先遍历(前序/中序/后序)
    //输入:{1,2,3,4,5,6,7,8,9}
    //输出: 1 ,2 ,4 ,8 ,9 ,5 ,3 ,6 ,7
    // 先序遍历输出-递归: 根节点-左子树-右子树
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
            //前序遍历是根->左->右，而栈可以逆序，所以先右再左；
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
    }

    public static void preOrderNoRecursion2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                System.out.print(node.val + " ,");
                node = node.left;
            } else {
                node = stack.pop();
                node = node.right;
            }
        }
    }

    //将上面if 改为while是一样的
    public static void preOrderNoRecursion3(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                System.out.print(node.val + " ,");
                node = node.left;
            }
            node = stack.pop();
            node = node.right;

        }
    }


    //输出: 8 ,4 ,9 ,2 ,5 ,1 ,6 ,3 ,7
    // 中序遍历输出-递归: 左子树-根节点-右子树
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
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                System.out.print(node.val + " ,");
                node = node.right;

            }
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

    //后序遍历-非递归形式
    public static void postOrderNoRecursion(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        TreeNode node;
        //s1加入的顺序是:根-左-右,所以push到s2中的顺序就是根-右-左,所以最后s2pop的时候就是左-右-根
        while (!s1.isEmpty()) {
            node = s1.pop();
            s2.push(node);
            if (node.left != null) s1.push(node.left);
            if (node.right != null) s1.push(node.right);
        }

        while (!s2.isEmpty()) {
            System.out.print(s2.pop().val + " ,");
        }

    }

    //计算树节点数量 = 左子树 + 右子树 + 1(root)
    public static int treeCount(TreeNode root) {
        if (root == null) return 0;
        return treeCount(root.left) + treeCount(root.right) + 1;
    }

    //计算树的深度 = max(treeDepth(左子树) + treeDepth(右子树)) + 1(root)
    public static int treeDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
    }

    //判断两棵树是不是相等:root相等.左子树相等,右子树相等
    static boolean is_SameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return true;
        else {
            return t1 != null && t2 != null && t1.val == t2.val
                    && is_SameTree(t1.left, t2.left) && is_SameTree(t1.right, t2.right);
        }
    }


    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        //TreeNode root = TreeNode.buildTree(arr);
        TreeNode root = TreeNode.createTree(arr, 0);
        System.out.print("先序遍历 :");
        TreeNode.preOrder(root);
        System.out.println();


        System.out.print("中序遍历 :");
        TreeNode.inOrder(root);
        System.out.println();

        System.out.print("后序遍历 :");
        TreeNode.postOrder(root);
        System.out.println();


        System.out.print("先序遍历-非递归 :");
        TreeNode.preOrderNoRecursion(root);
        System.out.println();

        System.out.print("先序遍历-非递归方法2 :");
        TreeNode.preOrderNoRecursion2(root);
        System.out.println();

        System.out.print("先序遍历-非递归方法3 :");
        TreeNode.preOrderNoRecursion3(root);
        System.out.println();

        System.out.print("中序遍历-非递归 :");
        TreeNode.inOrderNoRecursion(root);
        System.out.println();

        System.out.print("后序遍历-非递归 :");
        TreeNode.postOrderNoRecursion(root);
        System.out.println();


        System.out.print("层次遍历 :");
        TreeNode.breadth(root);
        System.out.println();


        System.out.println("节点数量=" + treeCount(root));
        System.out.println("树的深度=" + treeDepth(root));


    }
}
