package link;

/**
 * @author yuan
 * @date 2020/3/14 11:34 上午
 * <p>
 * <p>
 * 删除链表的倒数第N个节点
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/shan-chu-lian-biao-de-dao-shu-di-nge-jie-dian-by-l/
 * <p>
 * 链表问题使用dummy node 和双指针是很重要的技巧
 */
public class RemoveNthNodeFromEndOfList {


    //使用dummy做头结点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //定义一个假加点作为头指针
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        //第一次遍历计算链表长度
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        //第二次删除L-n+1位置的节点
        length = length - n;
        //将dummy作为新链表头节点开始循环,这样可以避免极端情况下删除头结点导致的头节点变化的情况
        temp = dummy;
        while (length > 0) {
            length--;
            temp = temp.next;
        }

        //将L-n位置的元素的next改为L-n+2位置的节点,就将L-n+1位置的节点删除了
        temp.next = temp.next.next;

        return dummy.next;
    }

    //利用dummy 和双指针,一个指针先向前移动n+1位,然后2个指针同时移动,知道第一个指针为null,
    //此时第二个指针指向的节点就是需要被删除的节点的上一位,将其next节点改为next.next即可
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy, second = dummy;
        while (n + 1 > 0) {
            n--;
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }


}
