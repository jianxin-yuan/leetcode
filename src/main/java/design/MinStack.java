package design;

import java.util.Stack;


class MinStack {

    private Stack<Integer> data;
    //使用一个辅助栈保存最小值
    private Stack<Integer> helper;

    public MinStack() {
        data = new Stack<>();
        helper = new Stack<>();
    }

    //入栈
    public void push(int x) {
        data.push(x);
        //如果helper为空,或者栈顶元素大于等于x,则入栈
        if (helper.isEmpty() || helper.peek() >= x) {
            helper.push(x);
        }
    }

    //出栈
    public void pop() {
        Integer pop = data.pop();
        //如果出栈元素等于helper栈顶元素,则helper出栈
        if (helper.peek().equals(pop)) {
            helper.pop();
        }
    }

    //返回栈顶元素
    public int top() {
        return data.peek();
    }

    //获取最小值
    public int getMin() {
        return helper.peek();
    }
}