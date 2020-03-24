package design;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/min-stack/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-38/
 *
 * 无辅助栈的思路: 在每个最小值前面入栈一个以前的最小值,这个样当前最小值出栈时,再次出栈可取得前一个最小值
 */
class MinStackNotHelper {

    private Stack<Integer> data;
    //保存当前最小值
    private int min;

    public MinStackNotHelper() {
        data = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    //入栈
    public void push(int x) {
        // 如果x<=min,则先将min入栈,更新min,然后入栈x
        if (x <= min) {
            data.push(min);
            min = x;
        }
        data.push(x);
    }

    //出栈
    public void pop() {
        //如果出栈元素为当前min,则再次出栈更新min
        if (data.pop().equals(min)) {
            min = data.pop();
        }
    }

    //返回栈顶元素
    public int top() {
        return data.peek();
    }

    //获取最小值
    public int getMin() {
        return min;
    }
}