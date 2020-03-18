package link;

import java.util.Objects;

/**
 * @author yuan
 * @date 2020/3/14 12:31 下午
 */
public class LinkedList<E> {
    private Node<E> head;
    private Node<E> last;
    private int size;

    public void add(E node) {
        //头结点为空
        Node<E> newNode = new Node<>(node, null);
        if (head == null) {
            head = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = last.next;
        }
        size++;
    }


    public int size() {
        return size;
    }

    public void print() {
        Node node = head;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }


    public static class Node<E> {
        private E val;
        private Node<E> next;


        public Node(E val, Node<E> next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(val, node.val) &&
                    Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next);
        }

        @Override
        public String toString() {
            return val.toString();
        }
    }


}
