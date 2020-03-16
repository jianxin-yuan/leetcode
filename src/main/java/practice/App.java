package practice;

/**
 * @author yuan
 * @date 2020/3/13 9:25 下午
 */
public class App {

    public static void main(String[] args) {
        MyStack<String> myStack = new MyStack<>();
        myStack.push("aa");
        myStack.push("bb");

        System.out.println(myStack);

        System.out.println(myStack.pop());
        System.out.println(myStack);


        System.out.println(myStack.isEmpty());
        System.out.println(myStack.size());

        System.out.println(myStack.peek());

        System.out.println(myStack.isEmpty());
        System.out.println(myStack.size());


    }
}
