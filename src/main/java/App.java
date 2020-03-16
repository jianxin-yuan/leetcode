import primary.list.LinkedList;

/**
 * @author yuan
 * @date 2020/3/5 11:07 上午
 */
public class App {
    public static void main(String[] args) throws Exception {


        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("aa");
        linkedList.add("bb");
        linkedList.add("cc");

        linkedList.print();
        System.out.println(linkedList.size());
    }


}
