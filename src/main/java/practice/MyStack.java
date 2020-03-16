package practice;


import java.util.Arrays;

/**
 * @author yuan
 * @date 2020/3/13 8:59 下午
 * <p>
 * 自己实现一个栈，要求这个栈具有push()、pop()（返回栈顶元素并出栈）、peek() （返回栈顶元素不出栈）、isEmpty()、size()这些基本的方法。
 * <p>
 * 提示：每次入栈之前先判断栈的容量是否够用，如果不够用就用Arrays.copyOf()进行扩容；
 */
public class MyStack<T> {

    private int cap;
    private int size;

    private Object[] arr;

    public MyStack() {
        cap = 8;
        arr = new Object[cap];
    }

    //入栈
    public void push(T t) {
        if (cap == size) {
            cap = 2 * cap;
            arr = Arrays.copyOf(arr, cap);
        }
        arr[size++] = t;
    }

    private Object removeElement() {
        return arr[--size];
    }

    //出栈
    public T pop() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (T) removeElement();
    }

    //返回栈顶元素不出栈
    public T peek() {
        return (T) arr[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }


    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(arr, 0, size ));
    }
}
